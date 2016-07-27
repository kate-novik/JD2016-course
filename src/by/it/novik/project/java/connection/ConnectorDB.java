package by.it.novik.project.java.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Kate Novik.
 */
public class ConnectorDB {
    //Создаем поле сингелтона
    private static volatile Connection connection;
    //Поля для получения данных для подключения к базе данных
    private static String URL_DB;
    private static String USER_DB;
    private static String PASSWORD_DB;

    private ConnectorDB() {
    }

    public static void setUrlDb(String urlDb) {
        URL_DB = urlDb;
    }

    public static void setUserDb(String userDb) {
        USER_DB = userDb;
    }

    public static void setPasswordDb(String passwordDb) {
        PASSWORD_DB = passwordDb;
    }

    /**
     * Регистрация драйвера в статическом блоке
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение соединения с базой данных
     * @return Объект Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectorDB.class) {
                if (connection == null || connection.isClosed()) {
                    //Используем файл ресурсов для создания подключения
                    connection = DriverManager.getConnection(URL_DB,USER_DB,PASSWORD_DB);
                }
            }
        }
        return connection;
    }
}
