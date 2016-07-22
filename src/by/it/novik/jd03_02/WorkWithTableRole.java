package by.it.novik.jd03_02;

import by.it.novik.jd03_02.connection.ConnectorDB;

import java.sql.*;

/**
 * Created by Kate Novik.
 */
public class WorkWithTableRole {

    public static void main(String[] args) throws SQLException {
        String readRole = "Select ID From role Where role.Role = ?;";
        int idAdmin = 0;
        int idUser = 0;
        try (Connection connection = ConnectorDB.getConnection()) {
            //Синхронзация по соединению
            synchronized (connection) {
                PreparedStatement statement = connection.prepareStatement(readRole);
                statement.setString(1,"Admin");
                ResultSet resultSet1 = statement.executeQuery();
                if (resultSet1.next()) {
                    idAdmin = resultSet1.getInt("ID");
                }
                statement.setString(1,"User");
                ResultSet resultSet2 = statement.executeQuery();
                if (resultSet2.next()) {
                    idUser = resultSet2.getInt("ID");
                }
            }
        }
        catch (SQLException e) {
            throw e;
        }
        System.out.println("ID Admin = " + idAdmin + "\nID User = " + idUser);
    }
}
