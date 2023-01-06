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

    // Edit author window
    public EditAuthorWindow(java.util.List<Author> authors, Author author) {
        // Set text fields to authors current name
        editFirstName.setText(author.getFirstName());
        editLastName.setText(author.getLastName());

        // When submit button is pressed, update authors name
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Overwrite fields with new entry
                author.setFirstName(editFirstName.getText());
                author.setLastName(editLastName.getText());


                for (Author i : authors) {
                    if (i == author) {
                        i = author;
                        break;
                    }
                }
                
                // Append new author name to author CSV
                try {
                    BufferedWriter authorWriter = new BufferedWriter(new FileWriter("resources/Author.csv", false));
                    authors.forEach(author -> {
                        try {
                            authorWriter.append(String.format("%s,%s,%s\n",
                                    author.getId(),
                                    author.getFirstName(),
                                    author.getLastName()));
                        
                        // Raise exception
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                    
                    authorWriter.close();
                    
                // Raise exception
                } catch(Exception f){
                    f.printStackTrace();
                }
                
                // Close frame once complete
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
