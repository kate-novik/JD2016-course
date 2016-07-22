package by.it.novik.project.java;

import by.it.novik.project.java.beans.User;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandLogin implements ActionCommand {
//    public static void main(String[] args) {
//        System.out.println(SecurityPassword.getHash("456"));
//    }


    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.LOGIN.inPage;
        if (request.getParameter("Password") == null) {
            return page;
        } else {

            String password = request.getParameter("Password");   //пароль
            String login = request.getParameter("Login");   //логин

            if (Validation.validDataFromForm(password, "password") && Validation.validDataFromForm(login, "login")) {
                //Получаем объект DAO
                DAO dao = DAO.getDAO();
                //Захэшируем пароль для сверки с паролем в БД
                String hashPassword = SecurityPassword.getHash(password);
                //Получаем user по введенному логину и паролю
                List<User> users = dao.getUserDAO().getAll(String.format("where Login='%s' and Password='%s'", login, hashPassword));
                User user = null;
                //Проверка на наличие user в базе данных
                if (users.size() > 0) {
                    user = users.get(0);
                }
                if (user == null) { //Вывод сообщение при отсутствии юзера в БД
                    request.setAttribute(Action.msgMessage, "Wrong data! Repeat, please, input or make registration.");
                    request.setAttribute("type","danger");
                    page = Action.LOGIN.inPage;
                } else {
                    //Создадим сессию при ее отсутствии
                    HttpSession session = request.getSession(true);
                    //Передадим в сессию объект user
                    session.setAttribute("user", user);
                    session.setAttribute("login",user.getNickname());
                    session.setAttribute("password",user.getPassword());
                    request.setAttribute(Action.msgMessage, "Welcome, " + user.getNickname());
                    request.setAttribute("type","success");
                    page = Action.LOGIN.okPage;
                }
            } else {
                request.setAttribute(Action.msgMessage, "Not valid data! Repeat, please, input.");
                request.setAttribute("type","danger");
                page = Action.LOGIN.inPage;
            }
            return page;
        }
    }
}