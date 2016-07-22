package by.it.novik.jd03_03.connection;

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

    private ConnectorDB() {
    }

    /**
     * Регистрация драйвера в статическом блоке
     */
    static {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
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
                    ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.novik.jd03_01.resources.connection");
                    String coding = "?useUnicode=".concat(resourceBundle.getString("db.useUnicode")).
                            concat("&characterEncoding=").concat(resourceBundle.getString("db.encoding"));
                    String url = resourceBundle.getString("db.url").concat(coding);
                    String user = resourceBundle.getString("db.user");
                    String pass = resourceBundle.getString("db.password");
                    connection = DriverManager.getConnection(url, user, pass);
                }
            }
        }
        return connection;
    }
}
