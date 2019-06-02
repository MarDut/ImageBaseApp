import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public class View {

    private Model model;
    private JFrame mainFrame;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTable table;


    public View(Model model)
    {
        this.model = model;
    }

    public void show(Controller controller){
        searchTextField = new JTextField(35);
        searchButton = new JButton("Filter");
        table = new JTable();
        table.setModel(model);
        searchButton.addActionListener(controller);

        JPanel headerPanel = new JPanel();
        headerPanel.add(searchTextField);
        headerPanel.add(searchButton);

        JScrollPane tablePanel = new JScrollPane(table);
        tablePanel.setPreferredSize(new Dimension(1000,500));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, headerPanel, tablePanel);
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

        mainFrame = new JFrame("Image Base App");
        mainFrame.add(splitPane);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null); // formatka wyswioetli sie na srodku ekranu
        mainFrame.setExtendedState( mainFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH );
        mainFrame.setVisible(true);
    }

    public Model getModel(){
        return model;
    }

    public String getSearchPhrase(){
        return searchTextField.getText().trim();
    }


}
