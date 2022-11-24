package polije.ppl.tailor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtil {
    private static Connection conn;

    static {
        String dbhost = ConfigUtil.get("db.host"),
            dbport = ConfigUtil.get("db.port"),
            dbuser = ConfigUtil.get("db.username"),
            dbpass = ConfigUtil.get("db.password"),
            dbdata = ConfigUtil.get("db.database");

        String jdbcUrl = "jdbc:mysql://" + dbhost + ":" + dbport + "/" + dbdata;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            conn = DriverManager.getConnection(jdbcUrl, dbuser, dbpass);
        } catch (SQLException e) { throw new Error(e.getMessage()); }
    }

    public static Connection getConnection() {
        return conn;
    }
}
