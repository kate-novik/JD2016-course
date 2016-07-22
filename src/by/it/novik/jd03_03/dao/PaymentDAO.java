package by.it.novik.jd03_03.dao;

import by.it.novik.jd03_03.beans.Payment;
import by.it.novik.jd03_03.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class PaymentDAO extends AbstractDAO implements IDAO<Payment,Integer> {

    @Override
    public boolean create(Payment object) {
        String createObject = String.format ("INSERT INTO payment (FK_Account_Source, FK_Account_Destination, " +
                "Description, Amount, Paydate) VALUES ('%d','%d','%s','%s','%s');",
                object.getFk_Account_Source(),object.getFk_Account_Destination(),object.getDescription(),
                object.getAmountPayment(), object.getPayDate());
        //Синхронзация по классу
        synchronized (PaymentDAO.class) {
            object.setIdPayment(executeUpdate(createObject));
        }
        return (object.getIdPayment() > 0);
    }

    @Override
    public Payment read(Integer id) {
        Payment resultPayment = null;
        List<Payment> listPayment = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (listPayment.size() > 0) {
            resultPayment = listPayment.get(0);
        }
        return resultPayment;
    }

    @Override
    public boolean update(Payment object) {
        int result;
        String updateObject = String.format ("UPDATE payment SET FK_Account_Source='%d', FK_Account_Destination='%d', Description='%s', Amount='%s', Paydate='%s'" +
                "Where payment.ID='%d';", object.getFk_Account_Source(),object.getFk_Account_Destination(),
                object.getDescription(), object.getAmountPayment(), object.getPayDate(), object.getIdPayment());
        //Синхронзация по классу
        synchronized (PaymentDAO.class) {
            result = executeUpdate(updateObject);
        }
        return (result > 0);
    }

    @Override
    public boolean delete(Payment object) {
        int result;
        String deleteObject = String.format ("DELETE From payment Where payment.ID='%d';", object.getIdPayment());
        //Синхронзация по классу
        synchronized (RoleDAO.class) {
            result = executeUpdate(deleteObject);
        }
        return (result > 0);
    }

    @Override
    public List<Payment> getAll(String where) {
        Payment resultPayment;
        List<Payment> paymentList = new ArrayList<>();
        String readObject = "Select * From payment " + where + ";";
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по классу
            synchronized (PaymentDAO.class) {
                ResultSet resultSet = statement.executeQuery(readObject);
                while (resultSet.next()) { //Создание role в соответствии с полученными данными с таблицы
                    resultPayment = new Payment(
                            resultSet.getInt("ID"),
                            resultSet.getInt("FK_Account_Source"),
                            resultSet.getString("Description"),
                            resultSet.getInt("FK_Account_Destination"),
                            resultSet.getDate("Paydate"),
                            resultSet.getFloat("Amount"));
                    paymentList.add(resultPayment);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Error connection or sql operation!" + e);
        }
        return paymentList;
    }
}
