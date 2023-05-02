package controller;

import model.DBContextUser;
import model.Enums.Role;
import model.User;
import view.LogInView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController {
    private LogInView logInView;
    private static final DBContextUser dbContextUser = new DBContextUser();

    public LogInController() {
        this.logInView = new LogInView();
        logInView.setVisible(true);

        logInView.addLogInListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = logInView.getUsernameTextField();
                String password = logInView.getPasswordTextField();

                String query = dbContextUser.createFindQueryByUsernameAndPassword(username, password);
                User user = dbContextUser.findUser(query);

                if(user != null) {
                    Role role = user.getRole();

                    if(role == Role.ADMINISTRATOR) {
                        AdministratorController administratorController = new AdministratorController(user);
                    }
                    else if(role == Role.EMPLOYEE) {
                        EmployeeController employeeController = new EmployeeController(user);
                    }
                    else {
                        ManagerController managerController = new ManagerController(user);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again!");
                }
            }
        });
    }
}
