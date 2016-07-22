package by.it.novik.jd03_02.crud;

import by.it.novik.jd03_02.beans.User;

import java.sql.SQLException;

/**
 * Created by Kate Novik.
 */
public class ExecuteCRUD {

    public static void main(String[] args) {
        //Create object ActionsWithUsers for working with table users
        ActionsCRUD <User,Integer> actionsCRUD = new ActionsWithUsers();
        //Create object User
        User user = new User (0, "Анна","Петровна","Соболь","MC267895, 19.05.2013", "г. Минск, ул. Гикало 1-2", "+375297785643",
                "anna", "sobol_anna@gmail.com", "234", 2);
        //Operation Create User
        try {
            //Insert user in table users
            user = actionsCRUD.create(user);
            //Read user from table users
            System.out.println(actionsCRUD.read(user.getIdUser()));

            //Update user in table users
            user.setFirstName("Антонина");
            user = actionsCRUD.update(user);
            //Read user from table users
            System.out.println(actionsCRUD.read(user.getIdUser()));

            //Delete user from table users
            if (actionsCRUD.delete(user)) {
                System.out.println("User удален! ID = " + user.getIdUser());
            }

        } catch (SQLException e) {
            System.out.println("Error sql operation" + e);
            e.printStackTrace();
        }

    }
}
