import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

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
}
