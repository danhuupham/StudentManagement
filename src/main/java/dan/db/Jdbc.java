package dan.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
    private static final String host = "localhost";
    private static final String port = "52063";
    private static final String databaseName = "StudentManagement";
    private static final String user = "sa";
    private static final String password = "5749";

    private static final String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s;integratedSecurity=false;trustServerCertificate=true;", host, port, databaseName, user, password);

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            return DriverManager.getConnection(url);
        } catch (Exception ignored) {
        }
        return null;
    }
}
