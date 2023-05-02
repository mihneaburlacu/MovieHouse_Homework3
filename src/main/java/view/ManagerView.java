package view;

import model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ManagerView extends JFrame{

    private JPanel contentPane;
    private JLabel welcomeLabel;
    private JLabel insertUsernameLabel;
    private JButton viewButton;

    public ManagerView(User user) {
        setTitle("MovieHouse - Manager");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 560, 410);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        welcomeLabel = new JLabel("Welcome, ");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setBounds(159, 10, 108, 29);
        contentPane.add(welcomeLabel);

        insertUsernameLabel = new JLabel("");
        insertUsernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        insertUsernameLabel.setBounds(263, 8, 130, 37);
        insertUsernameLabel.setForeground(Color.GREEN);
        contentPane.add(insertUsernameLabel);

        JLabel viewLabel = new JLabel("View all movies sorted by type and by year");
        viewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewLabel.setBounds(10, 96, 332, 22);
        contentPane.add(viewLabel);

        viewButton = new JButton("View, filter or save info");
        viewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        viewButton.setBounds(170, 220, 219, 29);
        contentPane.add(viewButton);

        JLabel lblOrSaveInfo = new JLabel("Or save info about movies");
        lblOrSaveInfo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblOrSaveInfo.setBounds(10, 162, 332, 22);
        contentPane.add(lblOrSaveInfo);

        insertUsernameLabel.setText(user.getUsername());

    }

    public void addViewButton(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }
}

