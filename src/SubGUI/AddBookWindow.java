package SubGUI;

import KotlinClass.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddBookWindow {
    private JTextField titleFieldEntry;
    private JTextField authorFieldEntry;
    private JTextField pubFieldEntry;
    private JTextField pubYearFieldEntry;
    private JTextField subjectFieldEntry;
    private JButton submitButton;
    private JPanel addBookPanel;
    private JButton backButton;


    // Creates window for users to create new book and appends to book and author CSV
    public AddBookWindow() {
        // Run once user clicks on "submit"
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b) {
                titleFieldEntry.getText();
                authorFieldEntry.getText();
                pubYearFieldEntry.getText();
                pubFieldEntry.getText();
                subjectFieldEntry.getText();

                // Ensures all text fields are filled in, raises error if not
                if (titleFieldEntry.getText().isEmpty() || authorFieldEntry.getText().isEmpty() || pubYearFieldEntry.getText().isEmpty() ||
                        pubFieldEntry.getText().isEmpty() || subjectFieldEntry.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(null, "Missing Fields", "Error!", 1);
                } else {
                    // Creates book vairable for new entry
                    Book add = new Book("69", titleFieldEntry.getText(), authorFieldEntry.getText(), pubYearFieldEntry.getText(), pubFieldEntry.getText(), subjectFieldEntry.getText());

                    try {
                        // Appends new book variable to book CSV and author to author CSV
                        BufferedWriter bookWriter = new BufferedWriter(new FileWriter("C:\\Users\\abdill\\IdeaProjects\\COMP1815_Trial\\resources\\Book.csv", true));
                        bookWriter.append(add.getId());
                        bookWriter.append(",");
                        bookWriter.append(titleFieldEntry.getText());
                        bookWriter.append(",");
                        bookWriter.append(authorFieldEntry.getText());
                        bookWriter.append(",");
                        bookWriter.append(pubYearFieldEntry.getText());
                        bookWriter.append(",");
                        bookWriter.append(pubFieldEntry.getText());
                        bookWriter.append(",");
                        bookWriter.append(subjectFieldEntry.getText());
                        bookWriter.newLine();
                        bookWriter.close();

                        BufferedWriter authorWriter = new BufferedWriter(new FileWriter("C:\\Users\\abdill\\IdeaProjects\\COMP1815_Trial\\resources\\Author.csv", true));
                        authorWriter.append(add.getId());
                        authorWriter.append(",");
                        authorWriter.append(authorFieldEntry.getText());
                        authorWriter.newLine();
                        authorWriter.close();

                    } catch (Exception e) {

                    }
                }
            }
        });

        // Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book_title = titleFieldEntry.getText();
                System.out.println(book_title);
            }
        });
    }


    public static void bookWindow() {
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new AddBookWindow().addBookPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
