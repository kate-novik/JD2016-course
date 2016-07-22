package by.it.novik.jd03_02.crud;

import by.it.novik.jd03_02.connection.ConnectorDB;
import by.it.novik.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kate Novik.
 */
public class ActionsWithUsers implements ActionsCRUD <User,Integer> {

    @Override
    public User create(User object) throws SQLException {
        String createObject = String.format ("INSERT INTO users (First_Name, Middle_Name, Last_Name, Passport, Address, Phone, " +
                        "Login, Password, Email, FK_Role) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%d');",
                object.getFirstName(), object.getMiddleName(), object.getLastName(), object.getPassport(), object.getAddress(),
                object.getPhone(), object.getNickname(), object.getPassword(),
                object.getEmail(), object.getFK_Role());
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                if (statement.executeUpdate(createObject) == 1) //Вставка записи в таблицу
                {
                    ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                    if (resultSet.next()) {
                        object.setIdUser(resultSet.getInt(1));
                    }
                    return object;
                }
            }
        }
        return null;
    }

    @Override
    public User read(Integer id) throws SQLException {
        User resultUser = null;
            String readObject = String.format ("Select * From users Where users.ID='%d';", id);
            try (Connection connection = ConnectorDB.getConnection();
                 Statement statement = connection.createStatement()) {
                //Синхронзация по соединению
                synchronized (connection) {
                    ResultSet resultSet = statement.executeQuery(readObject);
                    if (resultSet.next()) { //Создание user в соответствии с полученными данными с таблицы
                        resultUser = new User(
                                resultSet.getInt("ID"),
                                resultSet.getString("First_Name"),
                                resultSet.getString("Middle_Name"),
                                resultSet.getString("Last_Name"),
                                resultSet.getString("Passport"),
                                resultSet.getString("Address"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Login"),
                                resultSet.getString("Password"),
                                resultSet.getString("Email"),
                                resultSet.getInt("FK_Role"));
                    }
                }
            }
            catch (SQLException e) {
                throw e;
            }

        return resultUser;
    }

    @Override
    public User update(User object) throws SQLException {
        String updateObject = String.format ("UPDATE users SET First_Name='%s', Middle_Name='%s', Last_Name='%s', " +
                        "Passport='%s', Address='%s', Phone='%s', Login='%s', Password='%s', Email='%s', FK_Role='%d' Where users.ID='%d';",
                object.getFirstName(), object.getMiddleName(), object.getLastName(), object.getPassport(), object.getAddress(),
                object.getPhone(), object.getNickname(), object.getPassword(), object.getEmail(), object.getFK_Role(), object.getIdUser());
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
    public boolean delete(User object) throws SQLException {
        String deleteObject = String.format ("DELETE From users Where users.ID='%d';", object.getIdUser());
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
