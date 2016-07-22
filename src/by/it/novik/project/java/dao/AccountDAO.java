package by.it.novik.project.java.dao;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class AccountDAO extends AbstractDAO implements IDAO<Account,Integer> {
//    public static void main(String[] args) {
//        DAO dao = DAO.getDAO();
//        Account account = dao.getAccountDAO().read(15);
//        Double balance = account.getBalans();
//        //Меняем поле счета на заблокированное
//        System.out.println(balance);
//        Double source_amount = balance - 300;
//        account.setBalans(source_amount);
//        System.out.println(account);
//        System.out.println(dao.getAccountDAO().update(account));
//
//    }

    @Override
    public boolean create(Account object) {
        String createObject = String.format ("INSERT INTO account (Balans, State, FK_Users) VALUES ('%s','%s','%d');",
                object.getBalans(),object.getState(),object.getFk_Users());
            //Синхронзация по классу
            synchronized (AccountDAO.class) {
                        object.setIdAccount(executeUpdate(createObject));
                }
        return (object.getIdAccount() > 0);
    }

    @Override
    public Account read(Integer id) {
        Account resultAccount = null;
        List<Account> listAccount = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (listAccount.size() > 0) {
            resultAccount = listAccount.get(0);
        }

        return resultAccount;
    }

    @Override
    public boolean update(Account object) {
        int result;
        String updateObject = String.format ("UPDATE account SET Balans='%s', State='%s', FK_Users='%d' " +
                "Where account.ID='%d';", object.getBalans(),object.getState(),object.getFk_Users(),object.getIdAccount());
        //Синхронзация по классу
        synchronized (AccountDAO.class) {
            result = executeUpdate(updateObject);
        }
        return (result > 0);
    }

    @Override
    public boolean delete(Account object) {
        int result;
        String deleteObject = String.format ("DELETE From account Where account.ID='%d';", object.getIdAccount());
        //Синхронзация по классу
        synchronized (AccountDAO.class) {
            result = executeUpdate(deleteObject);
        }
        return (result > 0);
    }

    @Override
    public List<Account> getAll(String where) {
        Account resultAccount;
        List<Account> accountList = new ArrayList<>();
        String readObject = "Select * From account " + where + ";";
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по классу
            synchronized (AccountDAO.class) {
                ResultSet resultSet = statement.executeQuery(readObject);
                while (resultSet.next()) { //Создание account в соответствии с полученными данными с таблицы
                    resultAccount = new Account(
                            resultSet.getInt("ID"),
                            resultSet.getDouble("Balans"),
                            resultSet.getString("State"),
                            resultSet.getInt("FK_Users"));
                    accountList.add(resultAccount);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Error connection or sql operation!" + e);
        }
        return accountList;
    }
}
