package by.it.novik.jd03_02.tests;

import by.it.novik.jd03_02.beans.Account;
import by.it.novik.jd03_02.crud.ActionsCRUD;
import by.it.novik.jd03_02.crud.ActionsWithAccount;
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
public class ActionsWithAccountTest {

    private static ActionsCRUD<Account,Integer> actionsCRUD;
    private static Account account;
    private static List<Account> listAccounts;
    @BeforeClass
    public static void init () {
        actionsCRUD = new ActionsWithAccount();
        account = new Account (0, 170, "Working", 1);
        listAccounts = new ArrayList<>();
    }
    @AfterClass
    public static void deleteUsers() throws SQLException {
        System.out.println(listAccounts.size());
        for (Account account1 : listAccounts) {
            actionsCRUD.delete(account1);
        }
    }

    @Test
    public void create() throws Exception {
        Account accountResult = new Account (account);
        accountResult = actionsCRUD.create(accountResult);
        listAccounts.add(accountResult);
        assertNotNull(accountResult);
    }

    @Test
    public void read() throws Exception {
        Account accountResult = new Account (account);
        accountResult = actionsCRUD.create(accountResult);
        accountResult = actionsCRUD.read(accountResult.getIdAccount());
        listAccounts.add(accountResult);
        assertNotNull(accountResult);
    }

    @Test
    public void update() throws Exception {
        Account accountResult = new Account (account);
        accountResult = actionsCRUD.create(accountResult);
        accountResult = actionsCRUD.update(accountResult);
        listAccounts.add(accountResult);
        assertNotNull(accountResult);
    }

    @Test
    public void delete() throws Exception {
        Account accountResult = new Account (account);
        accountResult = actionsCRUD.create(accountResult);
        boolean flag = actionsCRUD.delete(accountResult);
        assertTrue(flag);
    }

}