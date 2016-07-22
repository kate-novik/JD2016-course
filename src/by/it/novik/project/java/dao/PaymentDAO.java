package by.it.novik.project.java.dao;

import by.it.novik.project.java.beans.Payment;
import by.it.novik.project.java.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class PaymentDAO extends AbstractDAO implements IDAO<Payment,Integer> {
//    public static void main(String[] args) {
//        DAO dao = DAO.getDAO();
//        long d = System.currentTimeMillis();
//        Date date = new Date (d);
//        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
//
//        String currentDate = formatDate.format(date);
//        System.out.println(currentDate);
//        Payment payment = null;
//
//            payment = new Payment(0, 2, "For", 3, Date.valueOf(currentDate),
//                    30);
//
//        dao.getPaymentDAO().create(payment);
//    }

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

    public List<Payment> getAll(int id_user) {
        Payment resultPayment;
        List<Payment> paymentList = new ArrayList<>();
        String readObject = "Select payment.ID, payment.FK_Account_Source, payment.FK_Account_Destination, payment.Description, payment.Amount, payment.Paydate" +
                " From payment Inner Join account on payment.FK_Account_Source=account.ID Where account.FK_Users=" + id_user +";";
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по классу
            synchronized (PaymentDAO.class) {
                ResultSet resultSet = statement.executeQuery(readObject);
                while (resultSet.next()) { //Создание payment в соответствии с полученными данными с таблицы
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
