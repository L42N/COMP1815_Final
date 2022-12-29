package SubGUI;

import javax.swing.*;

public class EditAuthorWindow {
    private JButton backButton;
    private JButton submitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel authorEditPanel;

    public static void bookWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new EditAuthorWindow().authorEditPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
