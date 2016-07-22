package by.it.novik.project.java;

import by.it.novik.project.java.beans.Payment;
import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class CommandGetPayments implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.PAYMENTS.inPage;
        //Получаем из сессии объект user
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //Получаем объект DAO
        DAO dao = DAO.getDAO();
        //String id_account = request.getParameter("id_account");
        //Integer id_account = (Integer) request.getSession(true).getAttribute("id_account");
        String id = request.getParameter("id_account");

        if (id != null){
            Integer id_account = Integer.parseInt(id);
            List<Payment> listPayments = dao.getPaymentDAO().getAll(
                   "Where FK_Account_Source = " + id_account);
            //Integer.parseInt(id_account)
            if (!listPayments.isEmpty()) {
                request.setAttribute(Action.msgMessage, "List of payments for account #" + id_account);
                request.setAttribute("type","success");
                request.setAttribute("listPayments", listPayments);
                return page;
            }
            else {
                request.setAttribute(Action.msgMessage, "Payments don't exist.");
                request.setAttribute("type","info");
                return page;
            }

        }
        List<Payment> listPayments = dao.getPaymentDAO().getAll(user.getIdUser());
        if (!listPayments.isEmpty()) {
            request.setAttribute(Action.msgMessage, "List of payments for user " + user.getNickname());
            request.setAttribute("type","success");
            request.setAttribute("listPayments", listPayments);
        }
        else {
            request.setAttribute(Action.msgMessage, "Payments don't exist.");
            request.setAttribute("type","info");
        }

        return page;
    }
}
