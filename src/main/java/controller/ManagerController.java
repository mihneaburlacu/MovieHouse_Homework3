package controller;

import model.DBContextMovie;
import model.DBContextUser;
import model.User;
import view.AdministratorView;
import view.ManagerView;
import view.ViewAndFilterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Filter;

public class ManagerController {
    private ManagerView managerView;
    private User manager;

    public ManagerController(User user, String language) {
        this.manager = user;
        this.managerView = new ManagerView(user, language);
        managerView.setVisible(true);

        managerView.addViewButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String language = managerView.returnLanguage();
                FilterAndViewController filterAndViewController = new FilterAndViewController(language);
            }
        });
    }
}
