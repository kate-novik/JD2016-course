package by.it.novik.jd03_02.tests;

import by.it.novik.jd03_02.beans.Role;
import by.it.novik.jd03_02.crud.ActionsCRUD;
import by.it.novik.jd03_02.crud.ActionsWithRole;
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
public class ActionsWithRoleTest {

    private static ActionsCRUD<Role,Integer> actionsCRUD;
    private static Role role;
    private static List<Role> listRoles;
    @BeforeClass
    public static void init () {
        actionsCRUD = new ActionsWithRole();
        role = new Role (0, "Admin");
        listRoles = new ArrayList<>();
    }
    @AfterClass
    public static void deleteUsers() throws SQLException {
        System.out.println(listRoles.size());
        for (Role role1 : listRoles) {
            actionsCRUD.delete(role1);
        }
    }

    @Test
    public void create() throws Exception {
        Role roleResult = new Role (role);
        roleResult = actionsCRUD.create(roleResult);
        listRoles.add(roleResult);
        assertNotNull(roleResult);
    }

    @Test
    public void read() throws Exception {
        Role roleResult = new Role (role);
        roleResult = actionsCRUD.create(roleResult);
        roleResult = actionsCRUD.read(roleResult.getIdRole());
        listRoles.add(roleResult);
        assertNotNull(roleResult);
    }

    @Test
    public void update() throws Exception {
        Role roleResult = new Role (role);
        roleResult = actionsCRUD.create(roleResult);
        roleResult = actionsCRUD.update(roleResult);
        listRoles.add(roleResult);
        assertNotNull(roleResult);
    }

    @Test
    public void delete() throws Exception {
        Role roleResult = new Role (role);
        roleResult = actionsCRUD.create(roleResult);
        boolean flag = actionsCRUD.delete(roleResult);
        assertTrue(flag);
    }

}