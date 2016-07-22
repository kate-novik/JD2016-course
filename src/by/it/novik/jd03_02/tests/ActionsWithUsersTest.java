package by.it.novik.jd03_02.tests;

import by.it.novik.jd03_02.beans.User;
import by.it.novik.jd03_02.crud.ActionsCRUD;
import by.it.novik.jd03_02.crud.ActionsWithUsers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kate Novik.
 */
public class ActionsWithUsersTest {

    private static ActionsCRUD<User,Integer> actionsCRUD;
    private static User user;
    private static List<User> listUsers;
    @BeforeClass
    public static void init () {
        actionsCRUD = new ActionsWithUsers();
        user = new User (0, "Анна","Петровна","Соболь","MC267895, 19.05.2013", "г. Минск, ул. Гикало 1-2", "+375297785643",
                "anna", "sobol_anna@gmail.com", "234", 2);
        listUsers = new ArrayList<>();
    }
    @AfterClass
    public static void deleteUsers() throws SQLException {
        System.out.println(listUsers.size());
        for (User user1 : listUsers) {
            actionsCRUD.delete(user1);
        }
    }

    @Test
    public void create() throws Exception {
        User userResult = new User (user);
        userResult = actionsCRUD.create(userResult);
        listUsers.add(userResult);
        assertNotNull(userResult);
    }

    @Test
    public void read() throws Exception {
        User userResult = new User (user);
        userResult = actionsCRUD.create(userResult);
        userResult = actionsCRUD.read(userResult.getIdUser());
        listUsers.add(userResult);
        assertNotNull(userResult);
    }

    @Test
    public void update() throws Exception {
        User userResult = new User (user);
        userResult = actionsCRUD.create(userResult);
        userResult = actionsCRUD.update(userResult);
        listUsers.add(userResult);
        assertNotNull(userResult);
    }

    @Test
    public void delete() throws Exception {
        User userResult = new User (user);
        userResult = actionsCRUD.create(userResult);
        boolean flag = actionsCRUD.delete(userResult);
        assertTrue(flag);
    }

}