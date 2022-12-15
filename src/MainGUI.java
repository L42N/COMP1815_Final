import KotlinClass.DataPersistence;

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
    private JTextField loadField;
    private JTextField timeTextField;
    private JComboBox sortCombobox;
    private JLabel RuntimeLabel;
    private JButton pubAddButton;
    private JButton NUKEButton;
    private JButton refreshButton;
    private JTabbedPane tabbedPane;
    private JPanel runTimePanel;
    private JPanel controlPanel;
    private JButton addNewEntryButton;
    private JButton deleteButton;
    private JButton editButton;
    private JTable authInfoTable;
    private JButton authExitButton;
    private JButton authLoadButton;
    private JButton authSearchButton;
    private JButton AuthRefeshButton;
    private JTextField authLoad;
    private JTextField authSearchEntry;
    private JButton authAdd;
    private JButton authEdit;
    private JButton authDelete;
    private JScrollPane authScrollPane;
    private JPanel bookPanel;
    private JPanel authControlPanel;
    private JTable pubInfoTable;
    private JButton pubLoadButton;
    private JButton pubSearchButton;
    private JButton pubRefreshButton;
    private JTextField pubLoad;
    private JTextField pubSearchEntry;
    private JButton pubEditButton;
    private JButton pubDeleteButton;
    private JPanel authPanel;
    private JPanel pubPanel;
    private JScrollPane pubScrollPane;
    private JButton pubExitButton;
    private JPanel pubControlPanel;


    public MainGUI() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var result = DataPersistence.INSTANCE.getBooks(loadField.getText());
                DefaultTableModel model = (DefaultTableModel) InfoTable.getModel();
                result.forEach(book -> {
                    Object[] row = new Object[]{book.getId(),
                            book.getTitle(),
                            book.getAuthors(),
                            book.getYearOfPublication(),
                            book.getPublisher(),
                            book.getSubject()};
                    model.addRow(row);
                });
            }
        });




        NUKEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        addNewEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Object[] mainCols = {"ID", "Title", "Author" ,"Year", "Publisher", "Subject"};
        InfoTable = new JTable(new DefaultTableModel(mainCols, 0));
        scrollPane = new JScrollPane(InfoTable);

        Object[] authCols = {"ID", "First Name", "Surname" };
        authInfoTable = new JTable(new DefaultTableModel(authCols, 0));
        authScrollPane = new JScrollPane(authInfoTable);

        Object[] pubCols = {"ID", "Publisher Name"};
        pubInfoTable = new JTable(new DefaultTableModel(pubCols, 0));
        pubScrollPane = new JScrollPane(pubInfoTable);

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

