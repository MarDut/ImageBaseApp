import javafx.scene.control.RadioButton;

import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public class View {

    private Model model;
    private JFrame mainFrame;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTable table;
    private JButton showAllButton;
    private JRadioButton searchByPhraseRadioButton;
    private JRadioButton searchByTagRadioButton;
    private JLabel imageLabel;


    public View(Model model)
    {
        this.model = model;
    }

    public void show(Controller controller){
        searchTextField = new JTextField(35);
        searchButton = new JButton("Filter");
        table = new JTable();
        showAllButton = new JButton("Show all");
        table.setModel(model);
        searchButton.addActionListener(controller);
        showAllButton.addActionListener(controller);

        JPanel radioButtonPanel = new JPanel();
        searchByPhraseRadioButton = new JRadioButton("Search by Phrase", true);
        searchByTagRadioButton = new JRadioButton("Search by Tag");
        radioButtonPanel.add(searchByPhraseRadioButton);
        radioButtonPanel.add(searchByTagRadioButton);
        ButtonGroup group = new ButtonGroup();
        group.add(searchByPhraseRadioButton);
        group.add(searchByTagRadioButton);

        JPanel headerPanel = new JPanel();
        headerPanel.add(searchTextField);
        headerPanel.add(searchButton);
        headerPanel.add(showAllButton);
        headerPanel.add(radioButtonPanel);

        JScrollPane tablePanel = new JScrollPane(table);
        tablePanel.setPreferredSize(new Dimension(1000,500));

        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200,200));


        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, headerPanel, tablePanel);
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

        mainFrame = new JFrame("Image Base App");
        mainFrame.add(splitPane);
        mainFrame.add(imageLabel);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null); // formatka wyswioetli sie na srodku ekranu
        mainFrame.setExtendedState( mainFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH );
        mainFrame.setVisible(true);
    };

    public Model getModel(){
        return model;
    }

    public String getSearchPhrase(){
        return searchTextField.getText().trim();
    }

    public JButton getShowAllButton() {
        return showAllButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public boolean isSearchByPhraseRadioButtonSelected()
    {
        return searchByPhraseRadioButton.isSelected();
    }

    public boolean isSearchByTagRadioButtonSelected()
    {
        return searchByTagRadioButton.isSelected();
    }
}
