package by.it.novik.project.java;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class CommandGetAccounts implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.ACCOUNTS.inPage;
        //Получаем из сессии объект user
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //Получаем объект DAO
        DAO dao = DAO.getDAO();
        List<Account> listAccounts = dao.getAccountDAO().getAll("Where FK_Users = "+ user.getIdUser());
        if (!listAccounts.isEmpty()) {
            request.setAttribute(Action.msgMessage, "List of accounts for user " + user.getNickname());
            request.setAttribute("listAccounts", listAccounts);
            request.setAttribute("type","success");
            page = Action.ACCOUNTS.okPage;
        }
        else {
            request.setAttribute(Action.msgMessage, "Accounts don't exist.");
            request.setAttribute("type","info");
            page = Action.ACCOUNTS.inPage;
        }

        return page;
    }
}
