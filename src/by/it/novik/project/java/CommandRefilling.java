package by.it.novik.project.java;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.beans.Payment;
import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.connection.ConnectorDB;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Created by Kate Novik.
 */
public class CommandRefilling implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.REFILL.inPage;
        //Получаем из сессии объект user
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //Поле суммы в форме пополнения счета
        String amount = request.getParameter("amount");
        String id_account = request.getParameter("id_account");
        String sourceAccount = request.getParameter("selectAccount");
        //ID счета, куда переводить,  получаем из параметра
        Integer id = Integer.parseInt(id_account);

        request.setAttribute("id_account",id_account);
        //Если не введена сумма, то возвращаем ту жу страницу
        if (amount == null || sourceAccount == null) {
            return page;
        }
        //ID счета, откуда переводить
        Integer id_source = Integer.parseInt(sourceAccount);
            if (Validation.validDataFromForm(amount, "amount")) {
                try {
                    ConnectorDB.getConnection().setAutoCommit(false);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //Получаем объект DAO
                DAO dao = DAO.getDAO();
                //Приводим сумму пополнения счета к типу Double
                Double refill = Double.parseDouble(amount);
                //Чтение счета-источника платежа по id
                Account accountS = dao.getAccountDAO().read(id_source);
                Double balance = accountS.getBalans();
                //Проверка баланса счета-источника
                if (balance >= refill) {
                    balance = balance - refill;
                    accountS.setBalans(balance);
                    //Чтение счета, куда переводить, по id
                    Account account = dao.getAccountDAO().read(id);
                    Double result = account.getBalans() + refill;
                    account.setBalans(result);
                    //Создание текущей даты и ее форматирование
                    Date date = new Date(System.currentTimeMillis());
                    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                    String currentDate = formatDate.format(date);
                    //Создаем платежку
                    Payment payment;

                    payment = new Payment(0, id_source, "Refill account", id, Date.valueOf(currentDate),
                            refill);
                    try {

                        if (!dao.getAccountDAO().update(accountS)) {
                            throw new SQLException();
                        }
                        if (!dao.getPaymentDAO().create(payment)) {
                            throw new SQLException();
                        }
                        if (!dao.getAccountDAO().update(account)) {
                            throw new SQLException();
                        }
                        request.setAttribute(Action.msgMessage, "Balans was refilled.");
                        request.setAttribute("type", "success");
                        page = Action.REFILL.okPage;
                        ConnectorDB.getConnection().commit();
                    } catch (SQLException e)
                     {
                         try {
                             ConnectorDB.getConnection().rollback();
                             request.setAttribute(Action.msgMessage, "Balans wasn't refilled. Enter amount.");
                             request.setAttribute("type", "danger");
                             page = Action.REFILL.inPage;
                         } catch (SQLException e1) {
                             e1.printStackTrace();
                         }

                    } finally {
                        try {
                            ConnectorDB.getConnection().setAutoCommit(true);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                }
                else {
                    request.setAttribute(Action.msgMessage,"Few funds in the source account.");
                    request.setAttribute("type","danger");
                    page = Action.REFILL.inPage;
                }

        } else {
                request.setAttribute(Action.msgMessage,"Not valid data! Repeat, please, input.");
                request.setAttribute("type","danger");
                page = Action.REFILL.inPage;
            }


        return page;
    }
}
