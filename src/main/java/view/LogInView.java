package view;

import model.Enums.Role;
import model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LogInView extends JFrame{

    private JPanel contentPane;
    private JButton LogInButton;
    private JLabel welcomeLabel;
    private JLabel logInLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JLabel imageLabel;


    public LogInView() {
        String[][] text = getTextFromFile();
        for(int i = 0; i < text.length; i++) {
            for(int j = 0; j < text[i].length; j++) {
                System.out.println(text[i][j] + ",");
            }
            System.out.println();
        }

        setTitle("MovieHouse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 710, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        LogInButton = new JButton("Log In");
        LogInButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        LogInButton.setBounds(250, 320, 157, 40);
        contentPane.add(LogInButton);

        welcomeLabel = new JLabel("Welcome to the Movie House Application!");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        welcomeLabel.setBounds(70, 10, 550, 65);
        contentPane.add(welcomeLabel);

        logInLabel = new JLabel("Please log in into your account!");
        logInLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        logInLabel.setBounds(155, 65, 360, 50);
        contentPane.add(logInLabel);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameLabel.setBounds(25, 160, 100, 30);
        contentPane.add(usernameLabel);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordLabel.setBounds(25, 230, 100, 30);
        contentPane.add(passwordLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(135, 160, 240, 30);
        contentPane.add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(135, 230, 240, 30);
        contentPane.add(passwordTextField);

        imageLabel = new JLabel("");
        ImageIcon img = new ImageIcon("src/Images/movie.png");
        imageLabel.setIcon(img);
        imageLabel.setBounds(454, 112, 166, 194);
        contentPane.add(imageLabel);
    }

    public void addLogInListener(ActionListener actionListener) {
        this.LogInButton.addActionListener(actionListener);
    }

    public String getUsernameTextField() {
        return usernameTextField.getText();
    }

    public String getPasswordTextField() {
        return passwordTextField.getText();
    }

    public String[][] getTextFromFile() {
        String[][] matrix = new String[3][6];

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Files/LogIn.csv"));
            int i = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] fields;

                fields = line.split(",");
                for (int j = 0; j < 6; j++) {
                    matrix[i][j] = fields[j];
                }

                i++;
            }
        } catch(Exception exp){
            exp.printStackTrace();
            System.out.println("Exception while reading from CSV File");
        }

        return matrix;
    }


}

