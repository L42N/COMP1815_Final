package SubGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookWindow {
    private JTextField titleFieldEntry;
    private JTextField authorFieldEntry;
    private JTextField pubFieldEntry;
    private JTextField pubYearFieldEntry;
    private JTextField subjectFieldEntry;
    private JButton submitButton;
    private JPanel addBookPanel;
    private JButton backButton;


    public AddBookWindow() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void bookWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new AddBookWindow().addBookPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}


