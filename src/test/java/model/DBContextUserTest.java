package model;

import model.Enums.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DBContextUserTest {
    @Test
    public void testInsertAndFindUser() {
        User user = new User(19, "John Doe", "johndoe", "password", Role.ADMINISTRATOR);

        DBContextUser dbContextUser = new DBContextUser();
        dbContextUser.insert(user);

        User retrievedUser = dbContextUser.findUser(dbContextUser.createFindQueryByID(19));

        Assertions.assertEquals(user, retrievedUser);

        dbContextUser.deleteUser(dbContextUser.createDeleteQueryByID(19));
    }

    @Test
    public void testDeleteUser() {
        User user = new User(22, "Jane Doe", "janedoe", "password", Role.MANAGER);

        DBContextUser dbContextUser = new DBContextUser();
        dbContextUser.insert(user);

        String deleteQuery = dbContextUser.createDeleteQueryByUsername("janedoe");
        dbContextUser.deleteUser(deleteQuery);

        User retrievedUser = dbContextUser.findUser(dbContextUser.createFindQueryByUsername("janedoe"));

        Assertions.assertNull(retrievedUser);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(22, "Jane Doe", "janedoe", "password", Role.MANAGER);

        DBContextUser dbContextUser = new DBContextUser();
        dbContextUser.insert(user);

        dbContextUser.updateUser(22, "John Doe", "johndoe", "newPassword", Role.EMPLOYEE.toString());

        User userAfterUpdate = new User(22, "John Doe", "johndoe", "newPassword", Role.EMPLOYEE);

        Assertions.assertEquals(userAfterUpdate, dbContextUser.findUser(dbContextUser.createFindQueryByID(22)));

        String deleteQuery = dbContextUser.createDeleteQueryByUsername("johndoe");
        dbContextUser.deleteUser(deleteQuery);
    }

    @Test
    public void testInsertUser(){
        User user = new User(0, "Mihnea Burlacu", "mihneaburlacu", "mihnea30", Role.ADMINISTRATOR);

        DBContextUser dbContextUser = new DBContextUser();
        User retrievedUser = dbContextUser.findUser(dbContextUser.createFindQueryByID(0));

        Assertions.assertEquals(user, retrievedUser);
    }

    @Test
    public void testFindUserByRole()  {
        User user = new User(0, "Mihnea Burlacu", "mihneaburlacu", "mihnea30", Role.ADMINISTRATOR);
        List<User> wantedList = new ArrayList<>();
        wantedList.add(user);

        DBContextUser dbContextUser = new DBContextUser();
        List listUsers = dbContextUser.findUsersByRole(Role.ADMINISTRATOR.toString());

        Assertions.assertEquals(listUsers.get(0), wantedList.get(0));
    }

}