package by.it.novik.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandLogout implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //Проверка на нажатие кнопки Logout
        if (request.getParameter("ButtonLogout") != null) {
            //HttpSession session = request.getSession(true);
            HttpSession session = request.getSession(false);
            if (session !=null){
            //Уничтожение сессии
            session.invalidate();}
            return Action.LOGOUT.okPage;
        }
        return Action.LOGOUT.inPage;
    }
}
