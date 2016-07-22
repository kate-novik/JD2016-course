package by.it.novik.project.java;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kate Novik.
 */
public class CommandCreateAccount implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.NEW_ACCOUNT.inPage;
        //Получаем из сессии объект user
        User user= (User) request.getSession(true).getAttribute("user");
        if (user==null) {
            return Action.LOGIN.inPage;
        }
        //Получаем объект DAO
        DAO dao = DAO.getDAO();
        Account account = new Account(0,0,"Working",user.getIdUser());
        if (dao.getAccountDAO().create(account)) {
            request.setAttribute(Action.msgMessage, "Account # " + account.getIdAccount() +" was created.");
            request.setAttribute("type","success");
            page = Action.NEW_ACCOUNT.okPage;
        }
        else {
            request.setAttribute(Action.msgMessage, "Account wasn't created.");
            request.setAttribute("type","danger");
            page = Action.NEW_ACCOUNT.okPage;
        }
        return page;
    }
}
