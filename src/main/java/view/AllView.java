package view;

import model.User;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AllView extends JFrame{

    private JPanel contentPane;
    private JTable table;
    private JTextField filterTextField;
    private JButton filterButton;

    public AllView() {
        setTitle("View all users");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 795, 570);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("View all or filter:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setBounds(300, 10, 190, 32);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "Name", "Username", "Password", "Role"},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "ID", "Name", "Username", "Password", "Role"
                }
        ));
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        table.setBounds(10, 66, 761, 347);
        contentPane.add(table);

        JLabel lblFilterAllUsers = new JLabel("Filter all users by role:");
        lblFilterAllUsers.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblFilterAllUsers.setBounds(10, 459, 180, 22);
        contentPane.add(lblFilterAllUsers);

        filterTextField = new JTextField();
        filterTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        filterTextField.setColumns(10);
        filterTextField.setBounds(190, 461, 143, 21);
        contentPane.add(filterTextField);

        filterButton = new JButton("Filter");
        filterButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        filterButton.setBounds(527, 456, 115, 29);
        contentPane.add(filterButton);

    }

    public void designTables(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    public void resetTable() {
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "Name", "Username", "Password", "Role"},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "ID", "Name", "Username", "Password", "Role"
                }
        ));
    }

    public void addFilterListener(ActionListener actionListener) {
        filterButton.addActionListener(actionListener);
    }

    public void setUserInTable(int row, User user) {
        this.table.getModel().setValueAt(user.getID(), row, 0);
        this.table.getModel().setValueAt(user.getName(), row, 1);
        this.table.getModel().setValueAt(user.getUsername(), row, 2);
        this.table.getModel().setValueAt(user.getPassword(), row, 3);
        this.table.getModel().setValueAt(user.getRole().toString(), row, 4);
    }

    public String getRoleFilter() {
        return filterTextField.getText();
    }

}

