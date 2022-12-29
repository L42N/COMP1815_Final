package SubGUI;

import javax.swing.*;

public class DeleteBookWindow {
    private JComboBox comboBox1;
    private JButton submitButton;
    private JButton backButton;
    private JPanel deleteBookPanel;

    public static void bookWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new DeleteBookWindow().deleteBookPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
