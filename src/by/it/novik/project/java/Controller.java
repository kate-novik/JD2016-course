package by.it.novik.project.java;

import by.it.novik.project.java.beans.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/do")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        ActionFactory client = new ActionFactory(); // определение команды, пришедшей из JSP
        ActionCommand command = client.defineCommand(request);

        //вызов реализованного метода execute() и передача параметров
        //классу-обработчику конкретной команды. Обработчик должен вернуть адрес view
        String viewPage = command.execute(request);

        response.setHeader("Cache-Control", "no-store");
        HttpSession httpSession = request.getSession(false);
        if (httpSession!=null) {
            User user = (User) httpSession.getAttribute("user");
            String login = (String) httpSession.getAttribute("login");
            String password = (String) httpSession.getAttribute("password");
            //Создадим куки на логин и зашифрованный пароль
            Cookie cookieFirst = new Cookie("login", login);
            Cookie cookieSecond = new Cookie("password", password);
            cookieFirst.setMaxAge(30);
            cookieSecond.setMaxAge(30);
            response.addCookie(cookieFirst);
            response.addCookie(cookieSecond);
        }
        //метод отправляет пользователю страницу ответа
        if (viewPage != null) {
            ServletContext servletContext=getServletContext();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(viewPage);
            // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        } else {
            // установка страницы c cообщением об ошибке
            viewPage = Action.ERROR.inPage;
            response.sendRedirect(request.getContextPath() + viewPage);
        }
    }
}