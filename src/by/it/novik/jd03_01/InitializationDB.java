package by.it.novik.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Kate Novik.
 */
public class InitializationDB {

    public static void main(String[] args) {
        try {
            //Регистрация драйвера на подключение к БД
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Error register driver!" + e);
        }
        try (Connection connection = ConnectorDB.getConnection(); Statement statement = connection.createStatement()) {
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
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
            //Вставка значений в БД
            statement.executeUpdate("INSERT INTO role (ID, Role) VALUES ('1', 'Admin'), ('2', 'User');");
            statement.executeUpdate("INSERT INTO users (ID, First_Name, Middle_Name, Last_Name, Passport, Address, " +
                    "Phone, Login, Password, Email, FK_Role) VALUES ('1', 'Иван', 'Иванович', 'Иванов', " +
                    "'MC234567, 15.08.2010', 'г. Жодино, ул. Калиновского 5-8', '+375296785643', 'ivan', '123', 'ivanov_iv@gmail.com', '2');");
            statement.executeUpdate("INSERT INTO users (ID, First_Name, Middle_Name, Last_Name, Passport, Address, " +
                    "Phone, Login, Password, Email, FK_Role) VALUES ('2', 'Петр', 'Петрович', 'Петров', " +
                    "'MC 456789, 12.06.1999', 'г. Минск, ул. Энгельса 6-8', '+375447774323', 'petr', '456', 'petrov_p@gmail.com', '1');");
            statement.executeUpdate("INSERT INTO account (ID, Balans, State, FK_Users) VALUES ('1', '250', 'Working', '1');");
            statement.executeUpdate("INSERT INTO account (ID, Balans, State, FK_Users) VALUES ('2', '547', 'Working', '1');");
            statement.executeUpdate("INSERT INTO account (ID, Balans, State, FK_Users) VALUES ('3', '3456', 'Working', '1');");
            statement.executeUpdate("INSERT INTO payment (ID, FK_Account_Source, FK_Account_Destination, Description, " +
                    "Amount, Paydate) VALUES ('1', '1', '2', 'Перевод средств', '50', '2016-07-13');");
            statement.executeUpdate("INSERT INTO payment (ID, FK_Account_Source, FK_Account_Destination, Description, " +
                    "Amount, Paydate) VALUES ('2', '3', '1', 'Перевод средств', '100', '2016-07-01');");
            statement.executeUpdate("INSERT INTO payment (ID, FK_Account_Source, FK_Account_Destination, Description, " +
                    "Amount, Paydate) VALUES ('3', '2', '1', 'Перевод средств', '10', '2016-06-06');");
            System.out.println("База данных проинициализирована!");
        } catch (SQLException e) {
            System.out.println("Error connection" + e);
        }
    }
}
