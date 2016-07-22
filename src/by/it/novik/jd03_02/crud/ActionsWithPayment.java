package by.it.novik.jd03_02.crud;

import by.it.novik.jd03_02.beans.Payment;
import by.it.novik.jd03_02.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Kate Novik.
 */
public class ActionsWithPayment implements ActionsCRUD <Payment,Integer> {

    @Override
    public Payment create(Payment object) throws SQLException {
        String createObject = String.format ("INSERT INTO payment (FK_Account_Source, FK_Account_Destination, " +
                "Description, Amount, Paydate) VALUES ('%d','%d','%s','%s','%s');",
                object.getFk_Account_Source(),object.getFk_Account_Destination(),object.getDescription(),
                object.getAmountPayment(), object.getPayDate());
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                if (statement.executeUpdate(createObject) == 1) //Вставка записи в таблицу
                {
                    ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                    if (resultSet.next()) {
                        object.setIdPayment(resultSet.getInt(1));
                    }
                    return object;
                }
            }
        }
        return null;
    }

    @Override
    public Payment read(Integer id) throws SQLException {
        Payment resultUser = null;
        String readObject = String.format ("Select * From payment Where payment.ID='%d';", id);
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по соединению
            synchronized (connection) {
                ResultSet resultSet = statement.executeQuery(readObject);
                if (resultSet.next()) { //Создание user в соответствии с полученными данными с таблицы
                    resultUser = new Payment(
                            resultSet.getInt("ID"),
                            resultSet.getInt("FK_Account_Source"),
                            resultSet.getString("Description"),
                            resultSet.getInt("FK_Account_Destination"),
                            resultSet.getDate("Paydate"),
                            resultSet.getFloat("Amount"));
                }
            }
        }
        catch (SQLException e) {
            throw e;
        }

        return resultUser;
    }

    @Override
    public Payment update(Payment object) throws SQLException {
        String updateObject = String.format ("UPDATE payment SET FK_Account_Source='%d', FK_Account_Destination='%d', Description='%s', Amount='%s', Paydate='%s'" +
                "Where payment.ID='%d';", object.getFk_Account_Source(),object.getFk_Account_Destination(),
                object.getDescription(), object.getAmountPayment(), object.getPayDate(), object.getIdPayment());
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
    public boolean delete(Payment object) throws SQLException {
        String deleteObject = String.format ("DELETE From payment Where payment.ID='%d';", object.getIdPayment());
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
