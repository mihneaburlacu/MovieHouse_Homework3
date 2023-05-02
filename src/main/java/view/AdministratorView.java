package view;

import model.Enums.Role;
import model.User;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class AdministratorView extends JFrame{

    private JPanel contentPane;
    private JLabel welcomeLabel;
    private JTable createTable;
    private JLabel insertUsernameLabel;
    private JButton createButton;
    private JTextField usernameReadTextField;
    private JTextField idReadTextField;
    private JButton readButton;
    private JTable readTable;
    private JTable updateTable;
    private JTextField updateIDTextField;
    private JTextField usernameDeleteTextField;
    private JTextField idDeleteTextField;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton updateButton;


    public AdministratorView(User administrator) {
        setTitle("MovieHouse - Administrator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 685, 575);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel("Welcome, ");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(250, 10, 108, 37);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(356, 10, 170, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        JLabel createLabel = new JLabel("Create user:");
        createLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createLabel.setBounds(10, 50, 108, 22);
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
        createTable.setBounds(20, 115, 420, 16);
        contentPane.add(createTable);

        createButton = new JButton("Create");
        createButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        createButton.setBounds(485, 100, 115, 29);
        contentPane.add(createButton);

        JLabel idInsertLabel = new JLabel("ID");
        idInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        idInsertLabel.setBounds(36, 85, 45, 13);
        contentPane.add(idInsertLabel);

        JLabel nameInsertLabel = new JLabel("Name");
        nameInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel.setBounds(124, 85, 45, 13);
        contentPane.add(nameInsertLabel);

        JLabel usernameInsertLabel = new JLabel("Username");
        usernameInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        usernameInsertLabel.setBounds(189, 85, 74, 13);
        contentPane.add(usernameInsertLabel);

        JLabel passwordInsertLabel = new JLabel("Password");
        passwordInsertLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        passwordInsertLabel.setBounds(284, 85, 74, 13);
        contentPane.add(passwordInsertLabel);

        JLabel lblRole = new JLabel("Role");
        lblRole.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblRole.setBounds(368, 85, 45, 13);
        contentPane.add(lblRole);

        JLabel readLabel = new JLabel("Read user:");
        readLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readLabel.setBounds(10, 150, 108, 22);
        contentPane.add(readLabel);

        JLabel readUsernameLabel = new JLabel("Enter the username: ");
        readUsernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readUsernameLabel.setBounds(36, 175, 152, 22);
        contentPane.add(readUsernameLabel);

        usernameReadTextField = new JTextField();
        usernameReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameReadTextField.setBounds(215, 178, 143, 19);
        contentPane.add(usernameReadTextField);
        usernameReadTextField.setColumns(10);

        JLabel readIDLabel = new JLabel("Enter ID: ");
        readIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel.setBounds(36, 206, 152, 22);
        contentPane.add(readIDLabel);

        idReadTextField = new JTextField();
        idReadTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idReadTextField.setColumns(10);
        idReadTextField.setBounds(215, 206, 143, 19);
        contentPane.add(idReadTextField);

        readButton = new JButton("Read");
        readButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readButton.setBounds(485, 184, 115, 29);
        contentPane.add(readButton);

        JLabel updateLabel = new JLabel("Update user:");
        updateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateLabel.setBounds(10, 263, 108, 22);
        contentPane.add(updateLabel);

        readTable = new JTable();
        readTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column"
                }
        ));
        readTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        readTable.setBounds(20, 235, 420, 16);
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
        updateTable.setBounds(20, 347, 420, 16);
        contentPane.add(updateTable);

        JLabel readIDLabel_1 = new JLabel("Enter ID: ");
        readIDLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_1.setBounds(36, 297, 152, 22);
        contentPane.add(readIDLabel_1);

        updateIDTextField = new JTextField();
        updateIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        updateIDTextField.setColumns(10);
        updateIDTextField.setBounds(215, 301, 143, 19);
        contentPane.add(updateIDTextField);

        JLabel nameInsertLabel_1 = new JLabel("Name");
        nameInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        nameInsertLabel_1.setBounds(47, 329, 45, 13);
        contentPane.add(nameInsertLabel_1);

        JLabel usernameInsertLabel_1 = new JLabel("Username");
        usernameInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        usernameInsertLabel_1.setBounds(143, 329, 74, 13);
        contentPane.add(usernameInsertLabel_1);

        JLabel passwordInsertLabel_1 = new JLabel("Password");
        passwordInsertLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        passwordInsertLabel_1.setBounds(238, 329, 74, 13);
        contentPane.add(passwordInsertLabel_1);

        JLabel lblRole_1 = new JLabel("Role");
        lblRole_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblRole_1.setBounds(356, 329, 45, 13);
        contentPane.add(lblRole_1);

        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        updateButton.setBounds(485, 313, 115, 29);
        contentPane.add(updateButton);

        JLabel deleteLabel = new JLabel("Delete user:");
        deleteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteLabel.setBounds(10, 383, 108, 22);
        contentPane.add(deleteLabel);

        JLabel readUsernameLabel_1 = new JLabel("Enter the username: ");
        readUsernameLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readUsernameLabel_1.setBounds(36, 413, 152, 22);
        contentPane.add(readUsernameLabel_1);

        JLabel readIDLabel_2 = new JLabel("Enter ID: ");
        readIDLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        readIDLabel_2.setBounds(36, 439, 152, 22);
        contentPane.add(readIDLabel_2);

        usernameDeleteTextField = new JTextField();
        usernameDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameDeleteTextField.setColumns(10);
        usernameDeleteTextField.setBounds(215, 413, 143, 19);
        contentPane.add(usernameDeleteTextField);

        idDeleteTextField = new JTextField();
        idDeleteTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        idDeleteTextField.setColumns(10);
        idDeleteTextField.setBounds(215, 443, 143, 19);
        contentPane.add(idDeleteTextField);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        deleteButton.setBounds(485, 416, 115, 29);
        contentPane.add(deleteButton);

        JLabel viewLabel = new JLabel("View all or filter all users:");
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 489, 220, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton("View");
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(485, 492, 115, 29);
        contentPane.add(viewButton);

        //pAdministrator = new PAdministrator(administrator, this);

        setUsernameOnLabel(administrator.getUsername());

    }

    public User getUserFromCreateTable() {
        String role = createTable.getModel().getValueAt(0, 4).toString();

        if (role.equals("ADMINISTRATOR")) {
            return new User(Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString()), createTable.getModel().getValueAt(0, 1).toString(), createTable.getModel().getValueAt(0, 2).toString(), createTable.getModel().getValueAt(0, 3).toString(), Role.ADMINISTRATOR);
        }
        else if (role.equals("MANAGER")){
            return new User(Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString()), createTable.getModel().getValueAt(0, 1).toString(), createTable.getModel().getValueAt(0, 2).toString(), createTable.getModel().getValueAt(0, 3).toString(), Role.MANAGER);
        }
        else {
            return new User(Integer.parseInt(createTable.getModel().getValueAt(0, 0).toString()), createTable.getModel().getValueAt(0, 1).toString(), createTable.getModel().getValueAt(0, 2).toString(), createTable.getModel().getValueAt(0, 3).toString(), Role.EMPLOYEE);
        }
    }

    public String getUsernameFromReadTextField() {
        return usernameReadTextField.getText();
    }

    public String getIDFromReadTextField() {
        return idReadTextField.getText();
    }

    public void setReadTable(User user) {
        readTable.getModel().setValueAt(user.getID(), 0, 0);
        readTable.getModel().setValueAt(user.getName(), 0, 1);
        readTable.getModel().setValueAt(user.getUsername(), 0, 2);
        readTable.getModel().setValueAt(user.getPassword(), 0, 3);
        readTable.getModel().setValueAt(user.getRole().toString(), 0, 4);
    }

    public int getIDFromTextFieldUpdate() {
        return Integer.parseInt(updateIDTextField.getText());
    }

    public String getNameFromUpdateTable(int row) {
        return updateTable.getModel().getValueAt(row, 0).toString();
    }

    public String getUsernameFromUpdateTable(int row) {
        return updateTable.getModel().getValueAt(row, 1).toString();
    }

    public String getPasswordFromUpdateTable(int row) {
        return updateTable.getModel().getValueAt(row, 2).toString();
    }

    public String getRoleFromUpdateTable(int row) {
        return updateTable.getModel().getValueAt(row, 3).toString();
    }

    public String getUsernameFromDeleteTextField() {
        return usernameDeleteTextField.getText();
    }

    public String getIDFromDeleteTextField() {
        return idDeleteTextField.getText();
    }

    public void addCreateListener(ActionListener actionListener) {
        this.createButton.addActionListener(actionListener);
    }

    public void addReadListener(ActionListener actionListener) {
        this.readButton.addActionListener(actionListener);
    }

    public void addUpdateListener(ActionListener actionListener) {
        this.updateButton.addActionListener(actionListener);
    }

    public void addDeleteListener(ActionListener actionListener) {
        this.deleteButton.addActionListener(actionListener);
    }

    public void addViewAllListener(ActionListener actionListener) {
        this.viewButton.addActionListener(actionListener);
    }

    public void setUsernameOnLabel(String username) {
        this.insertUsernameLabel.setText(username);
    }

    public void showMessage(String string) {
        JOptionPane.showMessageDialog(null, string);
    }
}
