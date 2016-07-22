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
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/novik"
                    +"?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    private ConnectorDB() {
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
//                    ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.novik.project.java.resources.connection");
//                    String coding = "?useUnicode=".concat(resourceBundle.getString("db.useUnicode")).
//                            concat("&characterEncoding=").concat(resourceBundle.getString("db.encoding"));
//                    String url = resourceBundle.getString("db.url").concat(coding);
//                    String user = resourceBundle.getString("db.user");
//                    String pass = resourceBundle.getString("db.password");
//                    connection = DriverManager.getConnection(url, user, pass);
                    connection = DriverManager.getConnection(URL_DB,USER_DB,PASSWORD_DB);
                }
            }
        }
        return connection;
    }
}
