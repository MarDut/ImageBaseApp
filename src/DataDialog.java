import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import  java.util.*;

public class DataDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField pathTextField;
    private JTextField authorTextField;
    private JTextField locaationTextField;
    private JTextField dateTextField;
    private JTextField tagsTextField;
    private boolean isOkButtonClicked;
    private Picture picture;

    public DataDialog() {
        initialize();
    }

    public DataDialog(Picture picture)
    {
        this.picture = picture;

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        initialize();

        pathTextField.setText(picture.getPath());
        authorTextField.setText(picture.getAuthor());
        locaationTextField.setText(picture.getLocation());
        dateTextField.setText(f.format(picture.getDate()));
        tagsTextField.setText(String.join(", " , picture.getTags()));
    }


    public boolean showDialog()
    {
        pack();
        setVisible(true);
        return isOkButtonClicked;
    }

    public Picture getPicture() throws ParseException
    {
        Picture picture = new Picture();

        updatePicture(picture);

        return picture;
    }

    private void updatePicture(Picture picture) throws ParseException
    {
        picture.setPath(pathTextField.getText().trim());
        picture.setAuthor(authorTextField.getText().trim());
        picture.setLocation(locaationTextField.getText().trim());
        picture.setDate(dateTextField.getText().trim());
        picture.setTags(tagsTextField.getText().trim());
    }

    private void onOK() {
        // dodawanie walidacji tutaj
        isOkButtonClicked = true;

        if(picture != null)
        {
            try
            {
                updatePicture(picture);
            }
            catch (Exception e )
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        dispose();
    }

    private void onCancel() {
        isOkButtonClicked = false;
        dispose();
    }

    private void initialize()
    {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);

        buttonOK.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)  {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
}
