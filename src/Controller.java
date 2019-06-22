import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;

public class Controller extends WindowAdapter implements ActionListener, ListSelectionListener, KeyListener {

    public final static String DATA_FILE_PATH = "./Pictures.json";

    private Model model;
    private View view;

    public Controller(View view) {
        this.view = view;
        model = view.getModel();
    }

    // zdarzenia z GUI
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSearchButton()) {
            onSearchButtonClick();
        } else if (e.getSource() == view.getShowAllButton()) {
            onShowAllButtonClick();
        } else if (e.getSource() == view.getMenuSortByAuthor()) {
            onSortByAuthorButtonClick();
        }
        else if ((e.getSource() == view.getMenuSortByLocation()))
        {
            onSortByLocationButtonClick();
        }
        else if ((e.getSource() == view.getMenuSortByDate()))
        {
            onSortByDateButtonClick();
        }
        else if (e.getSource() == view.getMenuOpenFile()) {
            onMenuOpenFileClick();
        } else if (e.getSource() == view.getMenuSaveFile()) {
            onMenuSaveFileClick();
        } else if (e.getSource() == view.getMenuAdd()) {
            onMenuAddButtonClick();
        } else if (e.getSource() == view.getMenuEdit()) {
            onMenuEditButtonClick();
        }
        else if (e.getSource() == view.getMenuMinAuthor()) {
            onMenuMinAuthorButtonClick();
        }
        else if (e.getSource() == view.getMenuMinLocation()) {
            onMenuMinLocationButtonClick();
        }
        else if (e.getSource() == view.getMenuMinDate()) {
            onMenuMinDateButtonClick();
        }
        else if (e.getSource() == view.getMenuMaxAuthor()) {
            onMenuMaxAuthorButtonClick();
        }
        else if (e.getSource() == view.getMenuMaxLocation()) {
            onMenuMaxLocationButtonClick();
        }
        else if (e.getSource() == view.getMenuMaxDate()) {
            onMenuMaxDateButtonClick();
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JTable table = view.getTable();
        int index = table.getSelectedRow();

        if (index != -1) {
            String picturePath = model.getPicturePath(index);
            try {
                view.setImage(picturePath);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 127) {
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
    public void windowClosing(WindowEvent e) {
        try {
            model.save(DATA_FILE_PATH);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void onSearchButtonClick() {
        if (view.isSearchByPhraseRadioButtonSelected()) {
            model.filterByPhrase(view.getSearchPhrase());
        } else if (view.isSearchByTagRadioButtonSelected()) {
            model.filterByTag(view.getSearchPhrase());
        }
    }

    private void onShowAllButtonClick() {
        model.filterByPhrase("");
    }

    private void onSortByAuthorButtonClick() {
        model.sortByAuthor();
    }

    private void onSortByLocationButtonClick()
    {
        model.sortByLocation();
    }

    private void onSortByDateButtonClick()
    {
        model.sortByDate();
    }

    private void onMenuOpenFileClick() {
        JFileChooser openFileDialog = new JFileChooser();

        openFileDialog.setFileFilter(new FileNameExtensionFilter("JSON File", "json"));
        //metoda blokująca, dopóki user nie wciśnie ok lub X
        if (openFileDialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                model.open(openFileDialog.getSelectedFile().getPath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error occured:" + System.lineSeparator() + e.getMessage());
            }
        }
    }

    private void onMenuSaveFileClick() {
        JFileChooser saveFileDialog = new JFileChooser();

        saveFileDialog.setFileFilter(new FileNameExtensionFilter("JSON File", "json"));
        if (saveFileDialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                String filename = saveFileDialog.getSelectedFile().getPath();

                if (!filename.endsWith(".json")) {
                    filename += ".json";
                }

                model.save(filename);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error occured:" + System.lineSeparator() + e.getMessage());
            }
        }
    }

    private void onMenuAddButtonClick() {
        DataDialog dataDialog = new DataDialog();

        if (dataDialog.showDialog()) {
            try {
                model.addPicture(dataDialog.getPicture());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    private void onMenuEditButtonClick() {
        JTable table = view.getTable();
        int index = table.getSelectedRow();

        if (index != -1) {

            Picture picture = model.getPictureByIndex(index);

            DataDialog dataDialog = new DataDialog(picture);

            if (dataDialog.showDialog())
            {
                model.refreshData();
            } else
            {
                JOptionPane.showMessageDialog(null, "Select row to edit");
            }
        }
    }

    private void onMenuMinAuthorButtonClick()
    {
        model.showAuthorMinValue();
    }

    private void onMenuMinLocationButtonClick()
    {
        model.showLocationMinValue();
    }

    private void onMenuMinDateButtonClick()
    {
        model.showDateMinValue();
    }

    private void onMenuMaxAuthorButtonClick()
    {
        model.showAuthorMaxValue();
    }

    private void onMenuMaxLocationButtonClick()
    {
        model.showLocationMaxValue();
    }

    private void onMenuMaxDateButtonClick()
    {
        model.showDateMaxValue();
    }







}
