package by.it.novik.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Kate Novik.
 */
public class OutputUsersFromDB {

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
            //Создание запроса к БД
            ResultSet resultSet = statement.executeQuery
                    ("select * from users,role r where FK_Role=r.ID;");
            while (resultSet.next()) {
                //Получение полей в строке из БД
                String fio = resultSet.getString(2).concat(" "+ resultSet.getString(3)).concat(" "+ resultSet.getString(4)).concat(", ");
                String passport = resultSet.getString(5).concat(", ");
                String address = resultSet.getString(6).concat(", ");
                String phone = resultSet.getString(7).concat(", ");
                String login = resultSet.getString(8).concat(", ");
                String pass = resultSet.getString(9).concat(", ");
                String email = resultSet.getString(10);
                String role = resultSet.getString(13).concat(", ");
                String out = role.concat(fio).concat(passport).concat(address).concat(phone).concat(login).concat(pass).concat(email);
                //Вывод строки из БД
                System.out.println(out);
            }
        } catch (SQLException e) {
            System.out.println("Error connection" + e);
        }
    }
}
