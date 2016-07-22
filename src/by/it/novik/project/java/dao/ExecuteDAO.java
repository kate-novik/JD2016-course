package by.it.novik.project.java.dao;

import by.it.novik.project.java.beans.User;

import java.util.List;

/**
 * Created by Kate Novik.
 */
public class ExecuteDAO {

    private static <T> void showTable(List<T> list, String tableName) {
        //Output content of table
        System.out.println("Table " + tableName + ":");
        for (T row : list) {
            System.out.println(row);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        //Create DAO singleton
        DAO dao = DAO.getDAO();

        //----------Operation with table user---------------
        //Create object User
        User user = new User(0, "Анна", "Петровна", "Соболь", "MC267895, 19.05.2013", "г. Минск, ул. Гикало 1-2", "+375297785643",
                "anna", "sobol_anna@gmail.com", "234", 2);

        //Show users with roles
        showTable(dao.getAllUsersWithRolesDAO().getAll(""), "users with roles");

        //Insert user in table users
        if (dao.getUserDAO().create(user))
            System.out.println("Add user : " + user);
        //Read user from table users
        System.out.println("Reading user : " + dao.getUserDAO().read(user.getIdUser()));

        //Update user in table users
        user.setFirstName("Антонина");
        if (dao.getUserDAO().update(user)) {
            System.out.println("Edit user : " + user);
        }
        //Read user from table users
        System.out.println("Reading user : " + dao.getUserDAO().read(user.getIdUser()));

        //Delete user from table users
        if (dao.getUserDAO().delete(user)) {
            System.out.println("Delete user: " + user);
        }
        //Show users with roles
        showTable(dao.getAllUsersWithRolesDAO().getAll(""), "users with roles");




    }

}
