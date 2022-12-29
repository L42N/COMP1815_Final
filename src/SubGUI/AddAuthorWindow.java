package SubGUI;

import javax.swing.*;

public class AddAuthorWindow {
    private JTextField fnField;
    private JButton submitButton;
    private JTextField snField;
    private JPanel authorAddPanel;
    private JButton backButton;

    public static  void main(String[] args){
        bookWindow();
    }

    public static void authorWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new AddAuthorWindow().authorAddPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


