import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.IOException;

public class Controller extends WindowAdapter implements ActionListener, ListSelectionListener, KeyListener {

    public final static String DATA_FILE_PATH = "./Pictures.json";

    private Model model;
    private View view;

    public Controller(View view)
    {
        this.view = view;
        model = view.getModel();
    }

    // zdarzenia z GUI
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==view.getSearchButton())
       {
           onSearchButtonClick();
       }
       else if (e.getSource()==view.getShowAllButton())
       {
           onShowAllButtonClick();
       }
       else if(e.getSource()==view.getSortByAuthor())
       {
           onSortByAuthorButtonClick();
       }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JTable table = view.getTable();
        int index = table.getSelectedRow();

        if(index != -1)
        {
            String picturePath = model.getPicturePath(index);
           try
           {
               view.setImage(picturePath);
           } catch (IOException ex)
           {
               ex.printStackTrace();
           }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==127)
        {
            JTable table = view.getTable();
            int index = table.getSelectedRow();

            model.removeByIndex(index);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        try
        {
            model.save(DATA_FILE_PATH);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void onSearchButtonClick(){
        if(view.isSearchByPhraseRadioButtonSelected())
        {
            model.filterByPhrase(view.getSearchPhrase());
        }
        else if (view.isSearchByTagRadioButtonSelected())
        {
            model.filterByTag(view.getSearchPhrase());
        }
    }

    private void onShowAllButtonClick(){
        model.filterByPhrase("");
    }

    private void  onSortByAuthorButtonClick(){
        model.sortByAuthor();
    }



}
