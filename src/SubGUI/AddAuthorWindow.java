package SubGUI;

import KotlinClass.Author;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AddAuthorWindow {
    private static JFrame frame;
    private JTextField fnField;
    private JButton submitButton;
    private JTextField snField;
    private JPanel authorAddPanel;
    private JButton backButton;
    private JTextField authIDField;

    public AddAuthorWindow() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ensures all text fields are filled in, raises error if not
                if (authIDField.getText().isEmpty()|| fnField.getText().isEmpty() || snField.getText().isEmpty()){
                    JOptionPane.showInternalMessageDialog(null, "Missing Fields", "Error!", 1);
                } else {
                    // Creates book vairable for new entry
                    Author add = new Author(authIDField.getText(), fnField.getText(), snField.getText());

                    try {
                        // Appends new book variable to book CSV and author to author CSV
                        BufferedWriter authorWriter = new BufferedWriter(new FileWriter("resources/Author.csv", true));
                        authorWriter.append(authIDField.getText());
                        authorWriter.append(",");
                        authorWriter.append(fnField.getText());
                        authorWriter.append(",");
                        authorWriter.append(snField.getText());
                        authorWriter.newLine();
                        authorWriter.close();

                    // Raise exception
                    } catch (Exception f) {

                    }
                    // Close frame once complete
                    frame.dispose();
                }
            }
        });

        // Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }


    public static void authorWindow(){
        frame = new JFrame("GUIBOI");
        frame.setContentPane(new AddAuthorWindow().authorAddPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


