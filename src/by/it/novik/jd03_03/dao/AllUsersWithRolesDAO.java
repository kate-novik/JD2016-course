package by.it.novik.jd03_03.dao;

import by.it.novik.jd03_03.beans.AllUsersWithRoles;
import by.it.novik.jd03_03.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class AllUsersWithRolesDAO extends AbstractDAO implements IDAO<AllUsersWithRoles,Integer> {

    @Override
    public boolean create(AllUsersWithRoles object) {
       // throw new NoSuchMethodException("This operation doesn't exist.");
        return false;
    }

    @Override
    public AllUsersWithRoles read(Integer integer) {
        return null;
    }

    @Override
    public boolean update(AllUsersWithRoles object) {
        return false;
    }

    @Override
    public boolean delete(AllUsersWithRoles object) {
        return false;
    }

    @Override
    public List<AllUsersWithRoles> getAll(String where) {
        AllUsersWithRoles allUsersWithRoles;
        List<AllUsersWithRoles> list = new ArrayList<>();
        String readObject = "Select users.ID, First_Name, Middle_Name, Last_Name, Passport, Address, Phone, " +
                "Login, Password, Email, Role From users Inner Join role on users.FK_Role=role.ID " + where +";";
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по классу
            synchronized (AllUsersWithRoles.class) {
                ResultSet resultSet = statement.executeQuery(readObject);
                while (resultSet.next()) { //Создание объекта AllUsersWithRoles в соответствии с полученными данными с таблицы
                    allUsersWithRoles = new AllUsersWithRoles(
                            resultSet.getInt("ID"),
                            resultSet.getString("First_Name"),
                            resultSet.getString("Middle_Name"),
                            resultSet.getString("Last_Name"),
                            resultSet.getString("Passport"),
                            resultSet.getString("Address"),
                            resultSet.getString("Phone"),
                            resultSet.getString("Login"),
                            resultSet.getString("Password"),
                            resultSet.getString("Email"),
                            resultSet.getString("Role"));
                    list.add(allUsersWithRoles);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Error connection or sql operation!" + e);
        }
        return list;
    }

}
