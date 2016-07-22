package by.it.novik.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Kate Novik.
 */
public class DropDataFromDB {

    public static void main (String[] args) {
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
            //Удаление таблиц из БД
            statement.execute("drop table payment;");
            statement.execute("drop table account;");
            statement.execute("drop table users;");
            statement.execute("drop table role;");
            System.out.println("Таблицы удалены!");
        } catch (SQLException e) {
            System.out.println("Error connection" + e);
        }
    }
}
