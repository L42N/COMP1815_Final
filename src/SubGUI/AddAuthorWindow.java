package SubGUI;

import javax.swing.*;

public class AddAuthorWindow {
    private JTextField fnField;
    private JButton submitButton;
    private JTextField snField;
    private JPanel addPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new AddAuthorWindow().addPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


