package SubGUI;

import KotlinClass.Author;
import KotlinClass.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EditAuthorWindow {
    private static  JFrame frame;
    private JButton backButton;
    private JButton submitButton;
    private JTextField editFirstName;
    private JTextField editLastName;
    private JPanel authorEditPanel;
    private JLabel firstName;
    private JLabel lastName;



    public EditAuthorWindow(java.util.List<Author> authors, Author author) {
        editFirstName.setText(author.getFirstName());
        editLastName.setText(author.getLastName());

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                author.setFirstName(editFirstName.getText());
                author.setLastName(editLastName.getText());


                for (Author i : authors) {
                    if (i == author) {
                        i = author;
                        break;
                    }
                }
                try {
                    BufferedWriter authorWriter = new BufferedWriter(new FileWriter("resources/Author.csv", false));

                    authors.forEach(author -> {
                        try {
                            authorWriter.append(String.format("%s,%s,%s\n",
                                    author.getId(),
                                    author.getFirstName(),
                                    author.getLastName()));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                    authorWriter.close();
                } catch(Exception f){
                    f.printStackTrace();
                }
                frame.dispose();
            }
        });
    }




    public static void authorWindow(java.util.List<Author> authors, Author author){
        frame = new JFrame("GUIBOI");
        frame.setContentPane(new EditAuthorWindow(authors, author).authorEditPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



}
