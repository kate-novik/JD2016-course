package by.it.novik.jd03_02.crud;

import by.it.novik.jd03_02.beans.Account;
import by.it.novik.jd03_02.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kate Novik.
 */
public class ActionsWithAccount implements ActionsCRUD <Account,Integer> {

    @Override
    public Account create(Account object) throws SQLException {
        String createObject = String.format ("INSERT INTO account (Balans, State, FK_Users) VALUES ('%s','%s','%d');",
                object.getBalans(),object.getState(),object.getFk_Users());
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                if (statement.executeUpdate(createObject) == 1) //Вставка записи в таблицу
                {
                    ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                    if (resultSet.next()) {
                        object.setIdAccount(resultSet.getInt(1));
                    }
                    return object;
                }
            }
        }
        return null;
    }

    @Override
    public Account read(Integer id) throws SQLException {
        Account resultUser = null;
        String readObject = String.format ("Select * From account Where account.ID='%d';", id);
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                ResultSet resultSet = statement.executeQuery(readObject);
                if (resultSet.next()) { //Создание user в соответствии с полученными данными с таблицы
                    resultUser = new Account(
                            resultSet.getInt("ID"),
                            resultSet.getDouble("Balans"),
                            resultSet.getString("State"),
                            resultSet.getInt("FK_Users"));
                }
            }
        }
        catch (SQLException e) {
            throw e;
        }

        return resultUser;
    }

    @Override
    public Account update(Account object) throws SQLException {
        String updateObject = String.format ("UPDATE account SET Balans='%s', State='%s', FK_Users='%d' " +
                "Where account.ID='%d';", object.getBalans(),object.getState(),object.getFk_Users(),object.getIdAccount());
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
    public boolean delete(Account object) throws SQLException {
        String deleteObject = String.format ("DELETE From account Where account.ID='%d';", object.getIdAccount());
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
