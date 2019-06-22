import javafx.scene.control.RadioButton;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.*;
import javax.swing.*;

public class View {

    public final static String NO_IMAGE_FILE_PATH = "./Media/image-not-available.jpg";

    private Model model;
    private JFrame mainFrame;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTable table;
    private JButton showAllButton;
    private JRadioButton searchByPhraseRadioButton;
    private JRadioButton searchByTagRadioButton;
    private JLabel imageLabel;
    private JButton sortByAuthor;
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuSort;
    private JMenu menuData;
    private JMenuItem menuOpenFile;
    private JMenuItem menuSaveFile;
    private JMenuItem menuSortByAuthor;
    private JMenuItem menuSortByLocation;
    private JMenuItem menuSortByDate;
    private JMenuItem menuAdd;
    private JMenuItem menuEdit;



    public View(Model model)
    {
        this.model = model;
    }

    public void show(Controller controller){
        searchTextField = new JTextField(35);
        searchButton = new JButton("Filter");
        table = new JTable();
        table.addKeyListener(controller);
        showAllButton = new JButton("Show all");
        sortByAuthor = new JButton("Sort by Author");
        sortByAuthor.addActionListener(controller);
        table.setModel(model);
        table.getSelectionModel().addListSelectionListener(controller);
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
        headerPanel.add(sortByAuthor);
        headerPanel.add(radioButtonPanel);

        JScrollPane tablePanel = new JScrollPane(table);
        tablePanel.setPreferredSize(new Dimension(1000,500));

        imageLabel = new JLabel();
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, headerPanel, tablePanel);
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);

            // MENU BAR

        // file
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuOpenFile = new JMenuItem("Open");
        menuSaveFile = new JMenuItem("Save");
        menuOpenFile.addActionListener(controller);
        menuSaveFile.addActionListener(controller);
        menuFile.add(menuOpenFile);
        menuFile.add(menuSaveFile);

        // sort
        menuSort = new JMenu("Sort by");
        menuBar.add(menuSort);
        menuSortByAuthor = new JMenuItem("author");
        menuSortByLocation = new JMenuItem("location");
        menuSortByDate = new JMenuItem("date");
        menuSortByAuthor.addActionListener(controller);
        menuSortByLocation.addActionListener(controller);
        menuSortByDate.addActionListener(controller);
        menuSort.add(menuSortByAuthor);
        menuSort.add(menuSortByLocation);
        menuSort.add(menuSortByDate);

        // data
        menuData = new JMenu("Data");
        menuBar.add(menuData);
        menuAdd = new JMenuItem("add");
        menuEdit = new JMenuItem("edit");
        menuAdd.addActionListener(controller);
        menuEdit.addActionListener(controller);
        menuData.add(menuAdd);
        menuData.add(menuEdit);

        mainFrame = new JFrame("Image Base App");
        mainFrame.setJMenuBar(menuBar);
        mainFrame.addWindowListener(controller);
        mainFrame.setLayout(new GridLayout(2,1));
        mainFrame.setMinimumSize(new Dimension(900,700));
        mainFrame.add(splitPane);
        mainFrame.add(imagePanel);
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

    public void setImage(String imagePath) throws IOException
    {
        BufferedImage image = loadImage(imagePath);
        imageLabel.setIcon(new ImageIcon(image));
    }

    public JTable getTable(){
        return table;
    }

    public JButton getSortByAuthor() {
        return sortByAuthor;
    }

    public JMenuItem getMenuOpenFile() {
        return menuOpenFile;
    }

    public JMenuItem getMenuSaveFile() {
        return menuSaveFile;
    }

    public JMenuItem getMenuSortByAuthor() {
        return menuSortByAuthor;
    }

    public JMenuItem getMenuSortByLocation() {
        return menuSortByLocation;
    }

    public JMenuItem getMenuSortByDate() {
        return menuSortByDate;
    }

    public JMenuItem getMenuAdd() {
        return menuAdd;
    }

    public JMenuItem getMenuEdit() {
        return menuEdit;
    }

    private BufferedImage loadImage(String imagePath) throws IOException
    {
        BufferedImage image;
        try
        {
            image = ImageIO.read(new File(imagePath));
        }
        catch (IOException e)
        {
            image = ImageIO.read(new File(NO_IMAGE_FILE_PATH));
        }
        return image;
    }


}
