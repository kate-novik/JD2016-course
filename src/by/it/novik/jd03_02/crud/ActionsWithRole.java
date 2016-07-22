package by.it.novik.jd03_02.crud;

import by.it.novik.jd03_02.beans.Role;
import by.it.novik.jd03_02.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kate Novik.
 */
public class ActionsWithRole implements ActionsCRUD <Role,Integer> {

    @Override
    public Role create(Role object) throws SQLException {
        String createObject = String.format ("INSERT INTO role (Role) VALUES ('%s');", object.getRole());
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                if (statement.executeUpdate(createObject) == 1) //Вставка записи в таблицу
                {
                    ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                    if (resultSet.next()) {
                        object.setIdRole(resultSet.getInt(1));
                    }
                    return object;
                }
            }
        }
        return null;
    }

    @Override
    public Role read(Integer id) throws SQLException {
        Role resultUser = null;
        String readObject = String.format ("Select * From role Where role.ID='%d';", id);
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                ResultSet resultSet = statement.executeQuery(readObject);
                if (resultSet.next()) { //Создание user в соответствии с полученными данными с таблицы
                    resultUser = new Role(
                            resultSet.getInt("ID"),
                            resultSet.getString("Role"));
                }
            }
        }
        catch (SQLException e) {
            throw e;
        }

        return resultUser;
    }

    @Override
    public Role update(Role object) throws SQLException {
        String updateObject = String.format ("UPDATE role SET Role='%s' Where role.ID='%d';", object.getRole(), object.getIdRole());
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                if (statement.executeUpdate(updateObject) == 1) //Обновление данных в таблице
                {
                    return object; //Возвращаем обновленный в БД объект user
                }
            }
        }
        catch (SQLException e) {
            throw e;
        }
        return null;
    }

    @Override
    public boolean delete(Role object) throws SQLException {
        String deleteObject = String.format ("DELETE From role Where role.ID='%d';", object.getIdRole());
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                return (statement.executeUpdate(deleteObject) == 1);//Возвращаем true при успешном удалении записи
            }
        }
        catch (SQLException e) {
            throw e;
        }
    }

}
