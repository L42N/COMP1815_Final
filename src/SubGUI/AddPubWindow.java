package SubGUI;

import KotlinClass.Pub;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class AddPubWindow {
    private JTextField pubField;
    private JButton submitButton;
    private JPanel addPubWindow;

    public AddPubWindow() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pubField.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(null, "Missing Fields", "Error!", 1);
                } else {
                    // Creates author vairable for new entry
                    Pub add = new Pub("69", pubField.getText());

                    try {
                        // Appends new book variable to book CSV and author to author CSV
                        BufferedWriter publisherWriter = new BufferedWriter(new FileWriter("resources/Publisher.csv", true));
                        publisherWriter.append(add.getId());
                        publisherWriter.append(",");
                        publisherWriter.append(pubField.getText());
                        publisherWriter.newLine();
                        publisherWriter.close();

                    } catch (Exception f) {

                    }
                }
            }
        });
    }

    public static void publisherWindow(){
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new AddPubWindow().addPubWindow);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
