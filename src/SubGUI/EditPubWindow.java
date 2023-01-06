package SubGUI;

import KotlinClass.Pub;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditPubWindow{

    private static JFrame frame;
    private JTextField pubTextField;
    private JButton backButton;
    private JButton submitButton;
    private JPanel pubEditPanel;

    public EditPubWindow (java.util.List<Pub> pubs, Pub pub){
        // Set text fields to publishers current field
        pubTextField.setText(pub.getPubName());
        
        // When submit button is pressed, update publishers name
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Overwrite field with new entry
                pub.setPubName(pubTextField.getText());

                for(Pub i : pubs){
                    if(i == pub){
                        i = pub;
                        break;
                    }
                }

                // Append new book to book CSV
                try {
                    BufferedWriter pubWriter = new BufferedWriter(new FileWriter("resources/Publisher.csv", false));
                    pubs.forEach(pub -> {
                        try {
                            pubWriter.append(String.format("%s,%s\n",
                                    pub.getId(),
                                    pub.getPubName()));
                        // Raise exception
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                    pubWriter.close();
                
                // Raise exception
                } catch(Exception f){
                    f.printStackTrace();
                }

                // Close frame once complete
                frame.dispose();

            }
        });

    }

    public static void publisherWindow(java.util.List<Pub> pubs, Pub pub){
        frame = new JFrame("GUIBOI");
        frame.setContentPane(new EditPubWindow(pubs, pub).pubEditPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
