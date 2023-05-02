package view;

import model.Enums.Type;
import model.Movie;
import model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EmployeeView extends JFrame{

    private JPanel contentPane;
    private JLabel welcomeLabel;
    private JTable createTable;
    private JLabel insertUsernameLabel;
    private JButton createButton;
    private JTextField nameReadTextField;
    private JTextField idReadTextField;
    private JButton readButton;
    private JTable readTable;
    private JTable updateTable;
    private JTextField updateIDTextField;
    private JTextField nameDeleteTextField;
    private JTextField idDeleteTextField;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton chartsButton;
    private User employee;

    public EmployeeView(User employee) {
        setTitle("MovieHouse - Employee");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 785, 605);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel("Welcome, ");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(250, 10, 108, 29);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(356, 10, 130, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        JLabel createLabel = new JLabel("Create movie:");
        createLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createLabel.setBounds(10, 36, 108, 22);
        contentPane.add(createLabel);

        createTable = new JTable();
        createTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column"
                }
        ));
        createTable.setBounds(20, 90, 433, 16);
        contentPane.add(createTable);

        createButton = new JButton("Create");
        createButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createButton.setBounds(485, 82, 115, 29);
        contentPane.add(createButton);

        JLabel idInsertLabel = new JLabel("ID");
        idInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idInsertLabel.setBounds(36, 69, 45, 13);
        contentPane.add(idInsertLabel);

        JLabel nameInsertLabel = new JLabel("Name");
        nameInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel.setBounds(124, 69, 45, 13);
        contentPane.add(nameInsertLabel);

        JLabel typeInsertLabel = new JLabel("Type");
        typeInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        typeInsertLabel.setBounds(188, 69, 74, 13);
        contentPane.add(typeInsertLabel);

        JLabel categoryInsertLabel = new JLabel("Category");
        categoryInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        categoryInsertLabel.setBounds(282, 69, 76, 13);
        contentPane.add(categoryInsertLabel);

        JLabel lblYear = new JLabel("Year");
        lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblYear.setBounds(368, 69, 45, 13);
        contentPane.add(lblYear);

        JLabel readLabel = new JLabel("Read movie:");
        readLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readLabel.setBounds(10, 116, 108, 22);
        contentPane.add(readLabel);

        JLabel readNameLabel = new JLabel("Enter the name: ");
        readNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readNameLabel.setBounds(36, 148, 152, 22);
        contentPane.add(readNameLabel);

        nameReadTextField = new JTextField();
        nameReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nameReadTextField.setBounds(215, 150, 143, 19);
        contentPane.add(nameReadTextField);
        nameReadTextField.setColumns(10);

        JLabel readIDLabel = new JLabel("Enter ID: ");
        readIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel.setBounds(36, 180, 152, 22);
        contentPane.add(readIDLabel);

        idReadTextField = new JTextField();
        idReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idReadTextField.setColumns(10);
        idReadTextField.setBounds(215, 182, 143, 19);
        contentPane.add(idReadTextField);

        readButton = new JButton("Read");
        readButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readButton.setBounds(485, 155, 115, 29);
        contentPane.add(readButton);

        JLabel updateLabel = new JLabel("Update movie:");
        updateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateLabel.setBounds(10, 238, 108, 22);
        contentPane.add(updateLabel);

        readTable = new JTable();
        readTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column", "New column"
                }
        ));
        readTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        readTable.setBounds(20, 212, 433, 16);
        contentPane.add(readTable);

        updateTable = new JTable();
        updateTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column"
                }
        ));
        updateTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateTable.setBounds(20, 325, 433, 16);
        contentPane.add(updateTable);

        JLabel readIDLabel_1 = new JLabel("Enter ID: ");
        readIDLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_1.setBounds(36, 270, 152, 22);
        contentPane.add(readIDLabel_1);

        updateIDTextField = new JTextField();
        updateIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateIDTextField.setColumns(10);
        updateIDTextField.setBounds(215, 272, 143, 19);
        contentPane.add(updateIDTextField);

        JLabel nameInsertLabel_1 = new JLabel("Name");
        nameInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel_1.setBounds(46, 302, 45, 13);
        contentPane.add(nameInsertLabel_1);

        JLabel typeInsertLabel_1 = new JLabel("Type");
        typeInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        typeInsertLabel_1.setBounds(136, 302, 74, 13);
        contentPane.add(typeInsertLabel_1);

        JLabel categoryInsertLabel_1 = new JLabel("Category");
        categoryInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        categoryInsertLabel_1.setBounds(235, 301, 76, 13);
        contentPane.add(categoryInsertLabel_1);

        JLabel lblYear_1 = new JLabel("Year");
        lblYear_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblYear_1.setBounds(356, 301, 45, 13);
        contentPane.add(lblYear_1);

        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateButton.setBounds(485, 272, 115, 29);
        contentPane.add(updateButton);

        JLabel deleteLabel = new JLabel("Delete movie:");
        deleteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteLabel.setBounds(10, 351, 108, 22);
        contentPane.add(deleteLabel);

        JLabel readNameLabel_1 = new JLabel("Enter the name: ");
        readNameLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readNameLabel_1.setBounds(36, 383, 152, 22);
        contentPane.add(readNameLabel_1);

        JLabel readIDLabel_2 = new JLabel("Enter ID: ");
        readIDLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_2.setBounds(36, 415, 152, 22);
        contentPane.add(readIDLabel_2);

        nameDeleteTextField = new JTextField();
        nameDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        nameDeleteTextField.setColumns(10);
        nameDeleteTextField.setBounds(215, 385, 143, 19);
        contentPane.add(nameDeleteTextField);

        idDeleteTextField = new JTextField();
        idDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idDeleteTextField.setColumns(10);
        idDeleteTextField.setBounds(215, 417, 143, 19);
        contentPane.add(idDeleteTextField);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteButton.setBounds(485, 365, 115, 29);
        contentPane.add(deleteButton);

        JLabel viewLabel = new JLabel("View all movies sorted by type and by year");
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 445, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton("View or filter");
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(440, 447, 156, 29);
        contentPane.add(viewButton);

        JLabel lblOrFilter = new JLabel("Filter all movies by type, category or year");
        lblOrFilter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblOrFilter.setBounds(10, 465, 332, 22);
        contentPane.add(lblOrFilter);

        JLabel lblNewLabel = new JLabel("Or save lists with info about movies");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblNewLabel.setBounds(10, 484, 323, 22);
        contentPane.add(lblNewLabel);

        JLabel createChart = new JLabel("Create charts about movies:");
        createChart.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createChart.setBounds(10, 520, 323, 22);
        contentPane.add(createChart);

        chartsButton = new JButton("Create Charts");
        chartsButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        chartsButton.setBounds(440, 515, 156, 29);
        contentPane.add(chartsButton);

        this.employee = employee;
        setUsernameToInsertLabel(employee.getUsername());
    }

    public Movie getMovieFromCreateTable(int idCreator) {
        int ID = Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString());
        String name = createTable.getModel().getValueAt(0, 1).toString();
        String type = createTable.getModel().getValueAt(0, 2).toString();
        String category = createTable.getModel().getValueAt(0, 3).toString();
        int year = Integer.parseInt(createTable.getModel().getValueAt(0, 4).toString());
        int id_creator = idCreator;

        if(type.equals("SERIES")) {
            return new Movie(ID, name, model.Enums.Type.SERIES, category, year, id_creator);
        }
        else {
            return new Movie(ID, name, model.Enums.Type.ARTISTIC, category, year, id_creator);
        }
    }

    public String getNameFromReadTextField() {
        return nameReadTextField.getText();
    }

    public String getIDFromReadTextField() {
        return idReadTextField.getText();
    }

    public void setMovieToReadTable(Movie movie) {
        readTable.getModel().setValueAt(movie.getID(), 0, 0);
        readTable.getModel().setValueAt(movie.getName(), 0, 1);
        readTable.getModel().setValueAt(movie.getType().toString(), 0, 2);
        readTable.getModel().setValueAt(movie.getCategory(), 0, 3);
        readTable.getModel().setValueAt(movie.getYear(), 0, 4);
        readTable.getModel().setValueAt(movie.getIdCreator(), 0 , 5);
    }

    public int getIDFromUpdateTextField() {
        return Integer.parseInt(updateIDTextField.getText());
    }

    public String getNameFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 0).toString();
    }

    public String getTypeFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 1).toString();
    }

    public String getCategoryFromUpdateTable() {
        return updateTable.getModel().getValueAt(0, 2).toString();
    }

    public int getYearFromUpdateTable() {
        return Integer.parseInt(updateTable.getModel().getValueAt(0, 3).toString());
    }

    public String getNameFromDeleteTextField() {
        return nameDeleteTextField.getText();
    }

    public String getIDFromDeleteTextField() {
        return idDeleteTextField.getText();
    }

    public void addCreateButton(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    public void addReadButton(ActionListener actionListener) {
        readButton.addActionListener(actionListener);
    }

    public void addUpdateButton(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }

    public void addDeleteButton(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }

    public void setUsernameToInsertLabel(String username) {
        insertUsernameLabel.setText(username);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void addChartButton(ActionListener actionListener) {chartsButton.addActionListener(actionListener);}

}
