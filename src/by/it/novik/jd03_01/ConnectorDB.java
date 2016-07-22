package by.it.novik.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Kate Novik.
 */
public class ConnectorDB {

    /**
     * Получение соединения с базой данных
     * @return Объект Connection
     * @throws SQLException
     */
    public static Connection getConnection () throws SQLException {
        //Используем файл ресурсов для создания подключения
        ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.novik.jd03_01.resources.connection");
        String coding = "?useUnicode=".concat(resourceBundle.getString("db.useUnicode")).concat("&characterEncoding=").concat(resourceBundle.getString("db.encoding"));
        String url = resourceBundle.getString("db.url").concat(coding);
        String user = resourceBundle.getString("db.user");
        String pass = resourceBundle.getString("db.password");
        return DriverManager.getConnection(url,user,pass);
    }
}
