package by.it.novik.jd03_02.reset;

import by.it.novik.jd03_02.beans.Account;
import by.it.novik.jd03_02.beans.Payment;
import by.it.novik.jd03_02.beans.Role;
import by.it.novik.jd03_02.beans.User;
import by.it.novik.jd03_02.connection.ConnectorDB;
import by.it.novik.jd03_02.crud.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Kate Novik.
 */
public class ResetDataBase {
    //Списки записей в каждой таблице БД
    private static List<User> users = new ArrayList<>();
    private static List<Role> roles = new ArrayList<>();
    private static List<Account> accounts = new ArrayList<>();
    private static List<Payment> payments = new ArrayList<>();

    public static void main(String[] args) {
        //Create connection to DB
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            dropTablesFromDatabase(statement);
            createTablesInDatabase(statement);
            addObjectsInList();
            insertListsInDataBase();
        } catch (SQLException e) {
            System.out.println("Error connection/sql query" + e);
            e.printStackTrace();
        }
    }

    /**
     * Delete Tables from DB
     * @param statement Object Statement
     * @throws SQLException
     */
    private static void dropTablesFromDatabase (Statement statement) throws SQLException {
        //Удаление таблиц из БД
        statement.execute("DROP TABLE IF EXISTS payment;");
        statement.execute("DROP TABLE IF EXISTS account;");
        statement.execute("DROP TABLE IF EXISTS users;");
        statement.execute("DROP TABLE IF EXISTS role;");
    }

    /**
     * Create Tables in DB
     * @param statement Object Statement
     * @throws SQLException
     */
    private static void createTablesInDatabase (Statement statement) throws SQLException {
        //Создание таблиц в БД
        statement.execute("CREATE TABLE role ( ID INT(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key' , " +
                "Role VARCHAR(50) NOT NULL , PRIMARY KEY (ID)) ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");
        statement.execute("CREATE  TABLE users ( ID INT(11) NOT NULL AUTO_INCREMENT , First_Name VARCHAR(20) NOT NULL, " +
                "Middle_Name VARCHAR(20) NOT NULL , Last_Name VARCHAR(20) NOT NULL , Passport VARCHAR(100) NOT NULL, " +
                "Address VARCHAR(100) NOT NULL , Phone VARCHAR(13) NOT NULL, Login VARCHAR(50) NOT NULL , " +
                "Password VARCHAR(50) NOT NULL , Email VARCHAR(100) NOT NULL , FK_Role INT(11) NOT NULL , PRIMARY KEY (ID), " +
                "Foreign Key (FK_Role) REFERENCES role(ID)) ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");
        statement.execute("CREATE  TABLE account (ID INT(11) NOT NULL AUTO_INCREMENT, Balans DECIMAL(50) NOT NULL, " +
                "State ENUM('Working','Lock') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL, " +
                "FK_Users INT(11) NOT NULL, PRIMARY KEY (ID), Foreign Key (FK_Users) REFERENCES users(ID)) " +
                "ENGINE = InnoDB CHARACTER set UTF8 COLLATE UTF8_general_ci;");
        statement.execute("CREATE TABLE payment ( ID INT(11) NOT NULL AUTO_INCREMENT, FK_Account_Source INT(11) NOT NULL, " +
                "FK_Account_Destination INT(11) NOT NULL , Description VARCHAR(200) NOT NULL , Amount DECIMAL(50) NOT NULL , " +
                "Paydate Date NOT NULL , PRIMARY KEY (ID), Foreign Key (FK_Account_Source) REFERENCES account(ID), " +
                "Foreign Key (FK_Account_Destination) REFERENCES account(ID)) ENGINE = InnoDB " +
                "CHARACTER set UTF8 COLLATE UTF8_general_ci;");
    }

    /**
     * Add objects in list of objects some table of DB
     */
    private static void addObjectsInList () {
        //Create objects Users
        User userFirst = new User (1, "Иван", "Иванович", "Иванов", "MC234567, 15.08.2010", "г. Жодино, ул. Калиновского 5-8",
                "+375296785643", "ivan", "123", "ivanov_iv@gmail.com", 2);
        User userSecond = new User (2, "Петр", "Петрович", "Петров", "MC 456789, 12.06.1999", "г. Минск, ул. Энгельса 6-8",
                "+375447774323", "petr", "456", "petrov_p@gmail.com", 1);
        users.add(userFirst);
        users.add(userSecond);
        //Create object Role
        Role roleFirst = new Role (1,"Admin");
        Role roleSecond = new Role (2,"User");
        roles.add(roleFirst);
        roles.add(roleSecond);
        //Create object Account
        Account accountFirst = new Account(1, 250, "Working", 1);
        Account accountSecond = new Account(2, 547, "Working", 1);
        Account accountThird = new Account(3, 3456, "Working", 1);
        accounts.add(accountFirst);
        accounts.add(accountSecond);
        accounts.add(accountThird);
        //Create object payment
        Payment paymentFirst = new Payment (1, 1, "Перевод средств",2, Date.valueOf("2016-07-13"), 50);
        Payment paymentSecond = new Payment (2, 3, "Перевод средств",1, Date.valueOf("2016-07-01"), 100);
        Payment paymentThird = new Payment (3, 2, "Перевод средств",1, Date.valueOf("2016-06-06"), 10);
        payments.add(paymentFirst);
        payments.add(paymentSecond);
        payments.add(paymentThird);
    }

    /**
     * Insert objects in tables of DB
     * @throws SQLException
     */
    private static void insertListsInDataBase () throws SQLException {
        //Create object ActionsWithRole for working with table role
        ActionsCRUD<Role,Integer> actionsWithRole = new ActionsWithRole();
        for (Role role : roles) {
            actionsWithRole.create(role);
        }
        //Create object ActionsWithUsers for working with table users
        ActionsCRUD<User,Integer> actionsWithUsers = new ActionsWithUsers();
        for (User user : users) {
            actionsWithUsers.create(user);
        }
        //Create object ActionsWithAccount for working with table account
        ActionsCRUD<Account,Integer> actionsWithAccount = new ActionsWithAccount();
        for (Account account : accounts) {
            actionsWithAccount.create(account);
        }
        //Create object ActionsWithPayment for working with table payment
        ActionsCRUD<Payment,Integer> actionsWithPayment = new ActionsWithPayment();
        for (Payment payment : payments) {
            actionsWithPayment.create(payment);
        }
    }
}
