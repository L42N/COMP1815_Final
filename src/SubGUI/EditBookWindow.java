package SubGUI;

import javax.swing.*;

public class EditBookWindow {
    private JButton backButton;
    private JButton submitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel editBookPanel;
    private JTextField textField5;
    private JTextField textfield5;

    public static void bookWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new EditBookWindow().editBookPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
