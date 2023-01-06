package SubGUI;

import KotlinClass.Book;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class EditBookWindow {
    private static JFrame frame;
    private JButton backButton;
    private JButton submitButton;
    private JTextField editSubjectField;
    private JTextField editPubField;
    private JTextField editPubYearField;
    private JPanel editBookPanel;
    private JTextField editTitleField;
    private JTextField editAuthorField;


    public EditBookWindow(java.util.List<Book> books, Book book) {
        // Set text fields to books current fields
        editTitleField.setText(book.getTitle());
        editAuthorField.setText(book.getAuthors());
        editPubYearField.setText(book.getYearOfPublication());
        editPubField.setText(book.getPublisher());
        editSubjectField.setText(book.getSubject());
        
        // When submit button is pressed, update authors name
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Overwrite fields with new entry
                book.setTitle(editTitleField.getText());
                book.setAuthors(editAuthorField.getText());
                book.setYearOfPublication(editPubYearField.getText());
                book.setPublisher(editPubField.getText());
                book.setSubject(editSubjectField.getText());

                for (Book i : books) {
                    if (i == book) {
                        i = book;
                        break;
                    }
                }
                // Append new book to book CSV
                try {
                    BufferedWriter bookWriter = new BufferedWriter(new FileWriter("resources/Book.csv", false));

                    books.forEach(book -> {
                        try {
                            bookWriter.append(String.format("%s,%s,%s,%s,%s,%s\n",
                                    book.getId(),
                                    book.getTitle(),
                                    book.getAuthors(),
                                    book.getYearOfPublication(),
                                    book.getPublisher(),
                                    book.getSubject()));

                        // Raise exception
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                    bookWriter.close();
                
                // Raise exception
                } catch(Exception f){
                    f.printStackTrace();
                }
                
                // Close frame once complete
                frame.dispose();
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

    public static void bookWindow(java.util.List<Book> books, Book book){
        frame = new JFrame("GUIBOI");
        frame.setContentPane(new EditBookWindow(books, book).editBookPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
