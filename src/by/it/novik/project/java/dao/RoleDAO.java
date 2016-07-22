package by.it.novik.project.java.dao;

import by.it.novik.project.java.beans.Role;
import by.it.novik.project.java.connection.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class RoleDAO extends AbstractDAO implements IDAO<Role,Integer> {

    @Override
    public boolean create(Role object) {
        String createObject = String.format ("INSERT INTO role (Role) VALUES ('%s');", object.getRole());
        //Синхронзация по классу
        synchronized (RoleDAO.class) {
            object.setIdRole(executeUpdate(createObject));
        }
        return (object.getIdRole() > 0);
    }

    @Override
    public Role read(Integer id) {
        Role resultRole = null;
        List<Role> listRole = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (listRole.size() > 0) {
            resultRole = listRole.get(0);
        }
        return resultRole;
    }

    @Override
    public boolean update(Role object) {
        int result;
        String updateObject = String.format ("UPDATE role SET Role='%s' Where role.ID='%d';", object.getRole(), object.getIdRole());
        //Синхронзация по классу
        synchronized (RoleDAO.class) {
            result = executeUpdate(updateObject);
        }
        return (result > 0);
    }

    @Override
    public boolean delete(Role object) {
        int result;
        String deleteObject = String.format ("DELETE From role Where role.ID='%d';", object.getIdRole());
        //Синхронзация по классу
        synchronized (RoleDAO.class) {
            result = executeUpdate(deleteObject);
        }
        return (result > 0);
    }

    @Override
    public List<Role> getAll(String where) {
        Role resultRole;
        List<Role> roleList = new ArrayList<>();
        String readObject = "Select * From role " + where + ";";
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            //Синхронзация по классу
            synchronized (RoleDAO.class) {
                ResultSet resultSet = statement.executeQuery(readObject);
                while (resultSet.next()) { //Создание role в соответствии с полученными данными с таблицы
                    resultRole = new Role(
                            resultSet.getInt("ID"),
                            resultSet.getString("Role"));
                    roleList.add(resultRole);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Error connection or sql operation!" + e);
        }
        return roleList;
    }

}
