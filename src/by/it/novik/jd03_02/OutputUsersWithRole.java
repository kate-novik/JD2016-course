package by.it.novik.jd03_02;

import by.it.novik.jd03_01.ConnectorDB;

import java.sql.*;

/**
 * Created by Kate Novik.
 */
public class OutputUsersWithRole {

    public static void main(String[] args) {
        //Query for getting users with their roles
        String queryUsers = "Select First_Name, Middle_Name, Last_Name, Passport, Address, Phone, " +
                "Login, Password, Email, Role From users Inner Join role on users.FK_Role=role.ID;";
        //Query for getting count of roles from table roles
        String queryRoles = "Select COUNT(*) From role;";
        //Variable of count users
        int countUsers = 0;
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(queryUsers);
            while (resultSet.next()) {
                //Getting meta data for name columns
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                //Count columns in resulting table
                int columnCount=resultSetMetaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(
                            resultSetMetaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t"
                    );
                }
                System.out.println();
                countUsers++;
            }
            //Getting count of roles
            resultSet = statement.executeQuery(queryRoles);
            if (resultSet.next()) {
                System.out.println("Количество возможных ролей: " + resultSet.getInt(1));
            }
            System.out.println("Общее число пользователей: " + countUsers);

        } catch (SQLException e) {
            System.out.println("Error sql connection or operations!" + e);
        }

    }

}
