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
        model.filterByPhrase(view.getSearchPhrase());
    }
}
