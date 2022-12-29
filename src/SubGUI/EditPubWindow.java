package SubGUI;

import javax.swing.*;

public class EditPubWindow {
    private JTextField textField1;
    private JButton backButton;
    private JButton submitButton;
    private JPanel authorEditPanel;

    public static void publisherWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new EditPubWindow().authorEditPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
