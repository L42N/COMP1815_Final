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


    //
    public AddBookWindow() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent b) {
                titleFieldEntry.getText();
                authorFieldEntry.getText();
                pubYearFieldEntry.getText();
                pubFieldEntry.getText();
                subjectFieldEntry.getText();

                if (titleFieldEntry.getText().isEmpty() || authorFieldEntry.getText().isEmpty() || pubYearFieldEntry.getText().isEmpty() ||
                        pubFieldEntry.getText().isEmpty() || subjectFieldEntry.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(null, "Missing Fields", "Error!", 1);
                } else {

                    Book add = new Book("69", titleFieldEntry.getText(), authorFieldEntry.getText(), pubYearFieldEntry.getText(), pubFieldEntry.getText(), subjectFieldEntry.getText());

                    try {

                        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\abdill\\IdeaProjects\\COMP1815_Trial\\resources\\Book.csv", true));
                        BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\abdill\\IdeaProjects\\COMP1815_Trial\\resources\\Author.csv", true));
                        writer.append(add.getId());
                        writer2.append(add.getId());
                        writer2.append(",");
                        writer.append(",");
                        writer.append(titleFieldEntry.getText());
                        writer.append(",");
                        writer.append(authorFieldEntry.getText());
                        writer2.append(authorFieldEntry.getText());
                        writer.append(",");
                        writer.append(pubYearFieldEntry.getText());
                        writer.append(",");
                        writer.append(pubFieldEntry.getText());
                        writer.append(",");
                        writer.append(subjectFieldEntry.getText());


                        writer.newLine();
                        writer.close();
                        writer2.newLine();
                        writer2.close();
                    } catch (Exception e) {

                    }


                }
            }
        });
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
