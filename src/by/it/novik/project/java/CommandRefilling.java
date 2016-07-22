package by.it.novik.project.java;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

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
        //ID счета получаем из параметра
        Integer id = Integer.parseInt(id_account);
        request.setAttribute("id_account",id_account);
        //Если не введена сумма, то возвращаем ту жу страницу
        if (amount == null) {
            return page;
        }
            if (Validation.validDataFromForm(amount, "amount")) {
                //Получаем объект DAO
                DAO dao = DAO.getDAO();
                //Приводим сумму пополнения счета к типу Double
                Double refill = Double.parseDouble(amount);
                //Чтение счета по id
                Account account = dao.getAccountDAO().read(id);
                Double result = account.getBalans() + refill;
                account.setBalans(result);
                //Обновляем поле Balance счета
                if (dao.getAccountDAO().update(account)) {
                    request.setAttribute(Action.msgMessage,"Balans was refilled.");
                    request.setAttribute("type","success");
                    page = Action.REFILL.okPage;
                }
                else {
                    request.setAttribute(Action.msgMessage,"Balans wasn't refilled. Enter amount.");
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
