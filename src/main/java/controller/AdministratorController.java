package controller;

import model.DBContextUser;
import model.User;
import view.AdministratorView;
import view.AllView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdministratorController {
    private AdministratorView administratorView;
    private AllView allView;
    private User administrator;
    private static final DBContextUser dbContextUser = new DBContextUser();

    public AdministratorController(User user) {
        this.administrator = user;
        this.administratorView = new AdministratorView(administrator);
        this.administratorView.setVisible(true);

        administratorView.addCreateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = administratorView.getUserFromCreateTable();
                dbContextUser.insert(user);
            }
        });

        administratorView.addReadListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = administratorView.getUsernameFromReadTextField();

                if(!username.equals("")) {
                    administratorView.setReadTable(readUserByUsername(username));
                }
                else {
                    String id = administratorView.getIDFromReadTextField();

                    if(!id.equals("")) {
                        try {
                            administratorView.setReadTable(readUserByID(Integer.parseInt(id)));
                        }catch(Exception exp) {
                            administratorView.showMessage("Cannot find this user");
                        }
                    }
                    else {
                        administratorView.showMessage("Please enter a valid ID or username");
                    }
                }
            }
        });

        administratorView.addDeleteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = administratorView.getUsernameFromDeleteTextField();

                if(!username.equals("")) {
                    deleteUserByUsername(username);
                }
                else {
                    String id = administratorView.getIDFromDeleteTextField();

                    if (!id.equals("")) {
                        deleteUserByID(Integer.parseInt(id));
                    }
                    else {
                        administratorView.showMessage("Please enter a valid ID or username");
                    }
                }
            }
        });

        administratorView.addUpdateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = administratorView.getNameFromUpdateTable(0);
                String username = administratorView.getUsernameFromUpdateTable(0);
                String password = administratorView.getPasswordFromUpdateTable(0);
                String role = administratorView.getRoleFromUpdateTable(0);

                int id = administratorView.getIDFromTextFieldUpdate();

                dbContextUser.updateUser(id, name, username, password, role);
            }
        });

        administratorView.addViewAllListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allView = new AllView();
                allView.setVisible(true);

                List<User> list = dbContextUser.findAllUsers();

                System.out.println(list);

                int nr = 1;
                for(User u : list) {
                    allView.setUserInTable(nr, u);
                    nr++;
                }

                allView.designTables();

                allView.addFilterListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<User> roleList = dbContextUser.findUsersByRole(allView.getRoleFilter());

                        allView.resetTable();

                        int nr = 1;
                        for(User user : roleList) {
                            allView.setUserInTable(nr, user);
                            nr++;
                        }

                        allView.designTables();
                    }
                });
            }
        });
    }

    public User readUserByID(int id) {
        String query = dbContextUser.createFindQueryByID(id);
        User user = dbContextUser.findUser(query);

        System.out.println(user);

        return user;
    }

    public User readUserByUsername(String username) {
        String query = dbContextUser.createFindQueryByUsername(username);
        User user = dbContextUser.findUser(query);

        System.out.println(user);

        return user;
    }

    public void deleteUserByID(int id) {
        String query = dbContextUser.createDeleteQueryByID(id);
        dbContextUser.deleteUser(query);
    }

    public void deleteUserByUsername(String username) {
        String query = dbContextUser.createDeleteQueryByUsername(username);
        dbContextUser.deleteUser(query);
    }
}
