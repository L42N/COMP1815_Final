import KotlinAlgo.BubbleSort;
import KotlinAlgo.MergeSort;
import KotlinAlgo.SearchAlgo;
import KotlinClass.Author;
import KotlinClass.Book;
import KotlinClass.DataPersistence;
import KotlinClass.Pub;
import Scala.RadixSort;
import SubGUI.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;


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
    private JButton addNewPublisherButton;
    private JButton closeButton;
    private JButton refreshButton;
    private JTabbedPane tabbedPane;
    private JPanel runTimePanel;
    private JPanel controlPanel;
    private JButton addNewBookButton;
    private JButton deleteBookButton;
    private JButton editBookButton;
    private JTable authInfoTable;
    private JButton authExitButton;
    private JButton authLoadButton;
    private JButton authSearchButton;
    private JTextField authLoad;
    private JTextField authSearchEntry;
    private JButton addNewAuthorButton;
    private JButton editAuthorButton;
    private JButton deleteAuthorButton;
    private JScrollPane authScrollPane;
    private JPanel bookPanel;
    private JPanel authControlPanel;
    private JTable pubInfoTable;
    private JButton pubLoadButton;
    private JButton pubSearchButton;
    private JTextField pubLoad;
    private JTextField pubSearchEntry;
    private JButton editPublisherButton;
    private JButton deletePublisherButton;
    private JPanel authPanel;
    private JPanel pubPanel;
    private JScrollPane pubScrollPane;
    private JButton pubExitButton;
    private JPanel pubControlPanel;
    private List<Book> books;
    private List<Author> authors;
    private List<Pub> pubs;

    public MainGUI() {
        // Load books by retrieving path from text field for use in getBooks function
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                books = DataPersistence.INSTANCE.getBooks(loadField.getText());
                bookTable();
            }
        });

        // Load authors by retrieving path from text field for use in getAuthors function
        authLoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authors = DataPersistence.INSTANCE.getAuthors(authLoad.getText());
                authorTable();
            }
        });

        // Load publishers by retrieving path from text field for use in getPublishers function
        pubLoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pubs = DataPersistence.INSTANCE.getPublishers(pubLoad.getText());
                publisherTable();
            }
        });

        // Add book
        addNewBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookWindow window = new AddBookWindow();
                window.bookWindow();
            }
        });

        // Add author
        addNewAuthorButton.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                AddAuthorWindow window = new AddAuthorWindow();
                window.authorWindow();
            }
        });

        // Add publisher
        addNewPublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPubWindow window = new AddPubWindow();
                window.publisherWindow();
            }
        });

        // Delete book
        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                DeleteBookWindow window = new DeleteBookWindow();
//                window.bookWindow();
                DefaultTableModel deleteBookModel = (DefaultTableModel) InfoTable.getModel();
                //delete row
                if(InfoTable.getSelectedRowCount()==1){
                    // If single row is selected then delete
                    deleteBookModel.removeRow(InfoTable.getSelectedRow());

                } else{
                    if(InfoTable.getRowCount()==0){
                        // if table is empty (no data) then display message
                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    }else{
                        // if table is not empty but row is not selected or multiple is selected
                        JOptionPane.showMessageDialog(null, "Please Select One Element to Delete");
                    }
                }
            }
        });

        // Delete author
        deleteAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteAuthorWindow window = new DeleteAuthorWindow();
                window.authorWindow();
            }
        });

        // Delete publisher
        deletePublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeletePubWindow window = new DeletePubWindow();
                window.publisherWindow();
            }
        });

        // Edit book
        editBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditBookWindow window = new EditBookWindow();
                window.bookWindow();

            }
        });

        // Edit author
        editAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditAuthorWindow window = new EditAuthorWindow();
                window.authorWindow();
            }
        });

        // Edit publisher
        editPublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditPubWindow window = new EditPubWindow();
                window.publisherWindow();
            }
        });
        
        // Search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (authorRadioButton.isSelected()) {

                    var searchInput = searchField.getText().toLowerCase();

                    var filteredBooks = SearchAlgo.INSTANCE.searchAuthor(searchInput,books);

                    DefaultTableModel bookModel = (DefaultTableModel) InfoTable.getModel();
                    bookModel.setRowCount(0);
                    filteredBooks.forEach(book -> {
                        Object[] bookRow = new Object[]{
                                book.getId(),
                                book.getTitle(),
                                book.getAuthors(),
                                book.getYearOfPublication(),
                                book.getPublisher(),
                                book.getSubject()
                        };
                        bookModel.addRow(bookRow);
                    });

                } else {

                    var searchInput = searchField.getText().toLowerCase();

                    var filteredAuthors = SearchAlgo.INSTANCE.searchTitle(searchInput,books);

                    DefaultTableModel bookModel = (DefaultTableModel) InfoTable.getModel();
                    bookModel.setRowCount(0);
                    filteredAuthors.forEach(book -> {
                        Object[] bookRow = new Object[]{
                                book.getId(),
                                book.getTitle(),
                                book.getAuthors(),
                                book.getYearOfPublication(),
                                book.getPublisher(),
                                book.getSubject()
                        };
                        bookModel.addRow(bookRow);
                    });
                }
            }
        });

        authSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var searchInput = authSearchEntry.getText().toLowerCase();

                var filteredAuthorLast = SearchAlgo.INSTANCE.searchAuthorLast(searchInput,authors);

                DefaultTableModel authModel = (DefaultTableModel) authInfoTable.getModel();
                authModel.setRowCount(0);
                filteredAuthorLast.forEach(author -> {
                    Object[] authRow = new Object[]{
                            author.getId(),
                            author.getFirstName(),
                            author.getLastName(),
                    };
                    authModel.addRow(authRow);
                });
            }
        });

        pubSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var searchInput = pubSearchEntry.getText().toLowerCase();

                var filteredPub = SearchAlgo.INSTANCE.searchPub(searchInput,pubs);

                DefaultTableModel pubModel = (DefaultTableModel) pubInfoTable.getModel();
                pubModel.setRowCount(0);
                filteredPub.forEach(pub -> {
                    Object[] pubRow = new Object[]{
                            pub.getId(),
                            pub.getPubName(),
                    };
                    pubModel.addRow(pubRow);
                });
            }

        });

        // Execute selected sort algorithm
        sortButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == sortButton){

                    // Execute algorithm & record timings
                    String algorithmType = sortCombobox.getSelectedItem().toString();

                    // Start timing
                    long startTime = System.nanoTime();

                    // Merge Sort algorithm
                    if (algorithmType.equals("Merge Sort")){

                        MergeSort algorithm = new MergeSort();

                        if (authorRadioButton.isSelected()) {
                            algorithm.authMergeSort(books);
                        } else {
                            algorithm.mergeSort(books);
                        }
                    }

                    // Bubble Sort algorithm
                    else if (algorithmType.equals("Bubble Sort")) {

                        BubbleSort algorithm = new BubbleSort();

                        if (BookButton.isSelected()) {
                            algorithm.bubbleSort(books);
                        } else {
                            algorithm.bubbleSortAuthor(books);
                        }
                    }

                    // Radix Sort algorithm
                    else if (algorithmType.equals("Radix Sort")) {

                        RadixSort algorithm = new RadixSort();

                        if (authorRadioButton.isSelected()) {
                            books = algorithm.initRadixSort(books,false);
                        } else {
                            books = algorithm.initRadixSort(books,true);
                        }
                    }

                    // Stop timing
                    long endTime = System.nanoTime();

                    // Calculate algorithm timings and display results
                    System.out.println("That took " + (endTime - startTime) + " nanoseconds");
                    String timings = String.valueOf((endTime - startTime) / 1000);
                    timeTextField.setText(timings + " milliseconds");

                    bookTable();

                }
            }
        });

        // Terminate code
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }

    // Create infotables for book, author and publisher with respective columns
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

    //Create main frame
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIBOI");
        frame.setContentPane(new MainGUI().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Refresh and load infotable (to be used after sort algorithm)
    public void bookTable() {
        DefaultTableModel bookModel = (DefaultTableModel) InfoTable.getModel();
        bookModel.setRowCount(0);
        books.forEach(book -> {
            Object[] bookRow = new Object[]{
                    book.getId(),
                    book.getTitle(),
                    book.getAuthors(),
                    book.getYearOfPublication(),
                    book.getPublisher(),
                    book.getSubject()
            };
            bookModel.addRow(bookRow);
        });
    }

    // Refresh and load AuthInfotable (to be used after sort algorithm)
    public void authorTable(){
        DefaultTableModel authModel = (DefaultTableModel)authInfoTable.getModel();
        authModel.setRowCount(0);
        authors.forEach(author -> {
            Object[] authRow = new Object[]{
                    author.getId(),
                    author.getFirstName(),
                    author.getLastName()
            };
            authModel.addRow(authRow);
        });
    }

    // Refresh and load PubInfotable (to be used after sort algorithm)
    public void publisherTable(){
        DefaultTableModel pubModel = (DefaultTableModel)pubInfoTable.getModel();
        pubModel.setRowCount(0);
        pubs.forEach(pub -> {
            Object[] pubRow = new Object[]{
                    pub.getId(),
                    pub.getPubName()
            };
            pubModel.addRow(pubRow);
        });
    }
}
