package SubGUI;

import javax.swing.*;

public class AddPubWindow {
    private JTextField pubField;
    private JButton button1;
    private JPanel addPubWindow;

    public static void publisherWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new AddPubWindow().addPubWindow);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
