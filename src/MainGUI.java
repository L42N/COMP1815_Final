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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    private JRadioButton firstNameRadioButton;
    private JRadioButton lastNameRadioButton;
    private JRadioButton IDRadioButton;
    private JRadioButton pubNameRadioButton;
    private List<Book> books;
    private List<Author> authors;
    private List<Pub> pubs;

    public MainGUI() {
        // Load books by retrieving path from text field for use in getBooks function from DataPersistence
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                books = DataPersistence.INSTANCE.getBooks(loadField.getText());
                bookTable();  // Refresh table
            }
        });

        // Load authors by retrieving path from text field for use in getAuthors function from DataPersistence
        authLoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authors = DataPersistence.INSTANCE.getAuthors(authLoad.getText());
                authorTable();  // Refresh table
            }
        });

        // Load publishers by retrieving path from text field for use in getPublishers function from DataPersistence
        pubLoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pubs = DataPersistence.INSTANCE.getPublishers(pubLoad.getText());
                publisherTable();  // Refresh table
            }
        });

        // Add book
        addNewBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookWindow window = new AddBookWindow();
                window.bookWindow();  // Open add book window
            }
        });

        // Add author
        addNewAuthorButton.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                AddAuthorWindow window = new AddAuthorWindow();
                window.authorWindow();  // Open add author window
            }
        });

        // Add publisher
        addNewPublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPubWindow window = new AddPubWindow();
                window.publisherWindow();  // Open add publisher window
            }
        });

        // Delete book
        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel deleteBookModel = (DefaultTableModel) InfoTable.getModel();
                // Delete row
                if(InfoTable.getSelectedRowCount()==1){
                    for (int i =0; i < books.size(); i++){
                        if (InfoTable.getValueAt(InfoTable.getSelectedRow(),0).toString() == books.get(i).getId()){
                            books.remove(i);  // Remove from list
                            break;
                        }
                    }
                    
                    // Update book records for list
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
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        bookWriter.close();
                        
                    // Raise error
                    } catch(Exception f){
                        f.printStackTrace();
                    }
                    
                    // Remove row
                    deleteBookModel.removeRow(InfoTable.getSelectedRow());
                
                } else{
                    if(InfoTable.getRowCount() == 0){
                        // If table is empty (no data) then display message
                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    
                    }else{
                        // If table is not empty but row is not selected or multiple is selected
                        JOptionPane.showMessageDialog(null, "Please Select One Element to Delete");
                    }
                }
            }
        });

        // Delete author
        deleteAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // DeleteBookWindow window = new DeleteBookWindow();
                // window.bookWindow();
                DefaultTableModel deleteBookModel = (DefaultTableModel) authInfoTable.getModel();
                // Delete row
                if(authInfoTable.getSelectedRowCount()==1){
                    for (int i =0; i < authors.size(); i++){
                        if (authInfoTable.getValueAt(authInfoTable.getSelectedRow(),0).toString() == authors.get(i).getId()){
                            authors.remove(i);  // Remove from list
                            break;
                        }
                    }
                    
                    // Update author records for list
                    try {
                        BufferedWriter authorWriter = new BufferedWriter(new FileWriter("resources/Author.csv", false));

                        authors.forEach(author -> {
                            try {
                                authorWriter.append(String.format("%s,%s,%s\n",
                                        author.getId(),
                                        author.getFirstName(),
                                        author.getLastName()));
                                
                            // Raise error
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        authorWriter.close();
                    // Raise error
                    } catch(Exception f){
                        f.printStackTrace();
                    }
                    deleteBookModel.removeRow(authInfoTable.getSelectedRow());
                
                } else{
                    if(authInfoTable.getRowCount()==0){
                        // if table is empty (no data) then display message
                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    }else{
                        // if table is not empty but row is not selected or multiple is selected
                        JOptionPane.showMessageDialog(null, "Please Select One Element to Delete");
                    }
                }
            }
        });

        // Delete publisher
        deletePublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel deletePubModel = (DefaultTableModel) pubInfoTable.getModel();
                // Delete row
                if(pubInfoTable.getSelectedRowCount()==1){
                    for (int i =0; i < pubs.size(); i++){
                        if (pubInfoTable.getValueAt(pubInfoTable.getSelectedRow(),0).toString() == pubs.get(i).getId()){
                            pubs.remove(i);  // Remove from list
                            break;
                        }
                    }
                    // Update publisher records for list
                    try {
                        BufferedWriter pubWriter = new BufferedWriter(new FileWriter("resources/Publisher.csv", false));
                        pubs.forEach(pub -> {
                            try {
                                pubWriter.append(String.format("%s,%s,\n",
                                        pub.getId(),
                                        pub.getPubName()));
                            // Raise error
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        pubWriter.close();
                    
                    // Raise error
                    } catch(Exception f){
                        f.printStackTrace();
                    }
                    deletePubModel.removeRow(pubInfoTable.getSelectedRow());
                
                } else{
                    if(pubInfoTable.getRowCount()==0){
                        // if table is empty (no data) then display message
                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    }else{
                        // if table is not empty but row is not selected or multiple is selected
                        JOptionPane.showMessageDialog(null, "Please Select One Element to Delete");
                    }
                }
            }
        });

        // Edit book
        editBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(InfoTable.getSelectedRowCount()==1){
                    for (Book book : books) {
                        // Edit selected row
                        if (InfoTable.getValueAt(InfoTable.getSelectedRow(), 0).toString() == book.getId()) {
                            EditBookWindow.bookWindow(books, book);  // Open EditBookWindow
                            break;
                        }
                    }

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

        // Edit author
        editAuthorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(authInfoTable.getSelectedRowCount()==1){
                    for (Author author : authors) {
                        // Edit selected row
                        if (authInfoTable.getValueAt(authInfoTable.getSelectedRow(), 0).toString() == author.getId()) {
                            EditAuthorWindow.authorWindow(authors, author);  // Open EditAuthorWindow
                            break;
                        }
                    }
                } else{
                    if(authInfoTable.getRowCount()==0){
                        // if table is empty (no data) then display message
                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    }else{
                        // if table is not empty but row is not selected or multiple is selected
                        JOptionPane.showMessageDialog(null, "Please Select One Element to Delete");
                    }
                }
            }
        });

        // Edit publisher
        editPublisherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Edit selected row
                if(pubInfoTable.getSelectedRowCount()==1){
                    for (Pub pub : pubs) {
                        if (pubInfoTable.getValueAt(pubInfoTable.getSelectedRow(), 0).toString() == pub.getId()) {
                            EditPubWindow.publisherWindow(pubs, pub);  // Open EditPublisherWindow
                            break;
                        }
                    }

                } else{
                    if(pubInfoTable.getRowCount()==0){
                        // if table is empty (no data) then display message
                        JOptionPane.showMessageDialog(null, "Table is Empty");
                    }else{
                        // if table is not empty but row is not selected or multiple is selected
                        JOptionPane.showMessageDialog(null, "Please Select One Element to Delete");
                    }
                }
            }
        });
        
        // Search book button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Sort by author
                if (authorRadioButton.isSelected()) {

                    // Get text from search field
                    var searchInput = searchField.getText().toLowerCase();

                    // Execute sort algorithm by author
                    var filteredBooks = SearchAlgo.INSTANCE.searchAuthor(searchInput,books);

                    DefaultTableModel bookModel = (DefaultTableModel) InfoTable.getModel();  // Load infotable
                    bookModel.setRowCount(0);
                    // Create sorted author object
                    filteredBooks.forEach(book -> {
                        Object[] bookRow = new Object[]{
                                book.getId(),
                                book.getTitle(),
                                book.getAuthors(),
                                book.getYearOfPublication(),
                                book.getPublisher(),
                                book.getSubject()
                        };
                        bookModel.addRow(bookRow);  // Load author object
                    });
                    
                // Sort by book
                } else{
                    
                    // Get text from search field
                    var searchInput = searchField.getText().toLowerCase();

                    // Execute sort algorithm by book
                    var filteredAuthors = SearchAlgo.INSTANCE.searchTitle(searchInput,books);

                    DefaultTableModel bookModel = (DefaultTableModel) InfoTable.getModel();  // Load infotable
                    bookModel.setRowCount(0);
                    // Create sorted book object
                    filteredAuthors.forEach(book -> {
                        Object[] bookRow = new Object[]{
                                book.getId(),
                                book.getTitle(),
                                book.getAuthors(),
                                book.getYearOfPublication(),
                                book.getPublisher(),
                                book.getSubject()
                        };
                        bookModel.addRow(bookRow);  // Load book object
                    });
                }
            }
        });

        // Search author button
        authSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Sort by last name
                if (lastNameRadioButton.isSelected()) {
                    
                    // Get text from search field
                    var searchInput = authSearchEntry.getText().toLowerCase();
                    
                    // Execute sort algorithm by first name
                    var filteredAuthorLast = SearchAlgo.INSTANCE.searchAuthorLast(searchInput, authors);

                    DefaultTableModel authModel = (DefaultTableModel) authInfoTable.getModel();  // Load infotable
                    authModel.setRowCount(0);
                    filteredAuthorLast.forEach(author -> {
                        // Create sorted author object by first name
                        Object[] authRow = new Object[]{
                                author.getId(),
                                author.getFirstName(),
                                author.getLastName(),
                        };
                        authModel.addRow(authRow);  // Load author object
                    });
                
                // Sort by first name
                } else  {

                    // Get text from search field
                    var searchInput = authSearchEntry.getText().toLowerCase();

                    // Execute sort algorithm by last name
                    var filteredAuthorLast = SearchAlgo.INSTANCE.searchAuthorFirst(searchInput, authors);

                    DefaultTableModel authModel = (DefaultTableModel) authInfoTable.getModel();  // Load infotable
                    authModel.setRowCount(0);
                    filteredAuthorLast.forEach(author -> {
                        // Create sorted author object by first name
                        Object[] authRow = new Object[]{
                                author.getId(),
                                author.getFirstName(),
                                author.getLastName(),
                        };
                        authModel.addRow(authRow);  // Load author object
                    });

                }
            }
        });

        // Search publisher button
        pubSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Search by publisher name
                if (pubNameRadioButton.isSelected()) {

                    // Get text from search field
                    var searchInput = pubSearchEntry.getText().toLowerCase();

                    // Execute sort algorithm by publisher
                    var filteredPub = SearchAlgo.INSTANCE.searchPub(searchInput, pubs);

                    DefaultTableModel pubModel = (DefaultTableModel) pubInfoTable.getModel();  // Load infotabl
                    pubModel.setRowCount(0);
                    // Create sorted publisher object
                    filteredPub.forEach(pub -> {
                        Object[] pubRow = new Object[]{
                                pub.getId(),
                                pub.getPubName(),
                        };
                        pubModel.addRow(pubRow);  // Load publisher object
                    });
                    
                // Search by publisher ID
                } else  {
                    // Get text from search field
                    var searchInput = pubSearchEntry.getText().toLowerCase();

                    // Execute sort algorithm by ID
                    var filteredPub = SearchAlgo.INSTANCE.searchPubID(searchInput, pubs);

                    DefaultTableModel pubModel = (DefaultTableModel) pubInfoTable.getModel();  // Load infotabl
                    pubModel.setRowCount(0);
                    // Create sorted publisher object
                    filteredPub.forEach(pub -> {
                        Object[] pubRow = new Object[]{
                                pub.getId(),
                                pub.getPubName(),
                        };
                        pubModel.addRow(pubRow);  // Load publisher object
                    });
                }
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
                        
                        // Merge sort by book
                        if (authorRadioButton.isSelected()) {
                            algorithm.authMergeSort(books);
                        // Merge sort by author
                        } else {
                            algorithm.mergeSort(books);
                        }
                    }

                    // Bubble Sort algorithm
                    else if (algorithmType.equals("Bubble Sort")) {

                        BubbleSort algorithm = new BubbleSort();
                        
                        // Bubble sort by book
                        if (BookButton.isSelected()) {
                            algorithm.bubbleSort(books);
                        // Bubble sort by author
                        } else {
                            algorithm.bubbleSortAuthor(books);
                        }
                    }

                    // Radix Sort algorithm
                    else if (algorithmType.equals("Radix Sort")) {

                        RadixSort algorithm = new RadixSort();

                        // Radix sort by book
                        if (authorRadioButton.isSelected()) {
                            books = algorithm.initRadixSort(books,false);
                        // Radix sort by author
                        } else {
                            books = algorithm.initRadixSort(books,true);
                        }
                    }

                    // Stop timing
                    long endTime = System.nanoTime();

                    // Calculate algorithm timings and display results
                    String timings = String.valueOf((endTime - startTime) / 1000000);
                    timeTextField.setText(timings + " milliseconds");

                    // Reload infotable to update page and display timing
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

        // Exit button (terminate code)
        authExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Exit button (terminate code)
        pubExitButton.addActionListener(new ActionListener() {
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
