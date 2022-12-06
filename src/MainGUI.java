import SubGUI.AddBookWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private JPanel MainPanel;
    private JTable InfoTable;
    private JScrollPane scrollPane;
    private JButton loadButton;
    private JButton searchButton;
    private JButton sortButton;
    private JTextField searchField;
    private JRadioButton BookButton;
    private JRadioButton authorRadioButton;
    private JRadioButton publisherRadioButton;
    private JTextField loadField;
    private JTextField timeTextField;
    private JComboBox sortCombobox;
    private JLabel RuntimeLabel;
    private JButton addButton;
    private JButton NUKEButton;
    private JButton refreshButton;
    private JButton adminPowerButton;


    public MainGUI() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookWindow mywindow = new AddBookWindow();
            }
        });


        NUKEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Object[] cols = {"ID", "Title", "Author" ,"Year", "Publisher", "Subject", };
        InfoTable = new JTable(new DefaultTableModel(cols, 0));
        scrollPane = new JScrollPane(InfoTable);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new MainGUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}

