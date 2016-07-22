package by.it.novik.project.java.dao;

import by.it.novik.project.java.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kate Novik.
 */
public abstract class AbstractDAO {

    /**
     * Custom command for operations Create, Update, Delete
     * @param sql Запрос sql на create, update, delete
     * @return Результат операции create/update/delete
     * @throws SQLException
     */
    protected int executeUpdate(String sql) {
        int resultQuery = -1;
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            resultQuery = statement.executeUpdate(sql);
            //Проверка sql запроса на вставку
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    resultQuery = resultSet.getInt(1);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Error connection or sql operation!" + e);
        }
        return resultQuery;
    }
}
