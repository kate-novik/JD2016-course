package by.it.novik.jd03_03.universal_dao;

import java.util.List;

/**
 * Created by Kate Novik.
 */
public class ExecuteUniversalDAO {

    private static <T> void showTable(List<T> list, String tableName) {
        //Output content of table
        System.out.println("Table " + tableName + ":");
        for (T row : list) {
            System.out.println(row);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        UniversalDAO<User> userUniversalDAO = new UniversalDAO<>(new User(), "users");
        //----------Operation with table user---------------
        //Create object User
        User user = new User(0, "Анна", "Петровна", "Соболь", "MC267895, 19.05.2013", "г. Минск, ул. Гикало 1-2", "+375297785643",
                "anna", "sobol_anna@gmail.com", "234", 2);

        //Show users with roles
        showTable(userUniversalDAO.getAll(""), "users with roles");

        //Insert user in table users
        if (userUniversalDAO.create(user))
            System.out.println("Add user : " + user);
        //Read user from table users
        System.out.println("Reading user : " + userUniversalDAO.read(user.getID()));

        //Update user in table users
        user.setFirst_Name("Антонина");
        if (userUniversalDAO.update(user)) {
            System.out.println("Edit user : " + user);
        }
        //Read user from table users
        System.out.println("Reading user : " + userUniversalDAO.read(user.getID()));

        //Delete user from table users
        if (userUniversalDAO.delete(user)) {
            System.out.println("Delete user: " + user);
        }
        //Show users with roles
        showTable(userUniversalDAO.getAll(""), "users with roles");
    }
}
