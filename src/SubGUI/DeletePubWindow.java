package SubGUI;

import javax.swing.*;

public class DeletePubWindow {
    private JComboBox comboBox1;
    private JButton backButton;
    private JButton submitButton;
    private JPanel authorDeletePanel;

    public static void bookWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new DeletePubWindow().authorDeletePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
