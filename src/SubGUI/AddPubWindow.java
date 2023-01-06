package SubGUI;

import KotlinClass.Pub;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AddPubWindow {
    private  static  JFrame frame;
    private JTextField pubField;
    private JButton submitButton;
    private JPanel addPubWindow;
    private JTextField pubIDTextField;

    public AddPubWindow() {
        // Submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If publisher field is empty, raise error
                if (pubField.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(null, "Missing Fields", "Error!", 1);
                } else {
                    // Creates author vairable for new entry
                    Pub add = new Pub(pubIDTextField.getText(), pubField.getText());

                    try {
                        // Appends new book variable to book CSV and author to author CSV
                        BufferedWriter publisherWriter = new BufferedWriter(new FileWriter("resources/Publisher.csv", true));
                        publisherWriter.append(pubIDTextField.getText());
                        publisherWriter.append(",");
                        publisherWriter.append(pubField.getText());
                        publisherWriter.newLine();
                        publisherWriter.close();

                    // Raise exception
                    } catch (Exception f) {

                    }
                    // Close frame once complete
                    frame.dispose();
                }
            }
        });
}

    public static void publisherWindow(){
        frame = new JFrame("GUIBOI");
        frame.setContentPane(new AddPubWindow().addPubWindow);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
