package database;

import java.sql.Connection;

/**
 * User: Mariola
 * Date: 14.12.13
 */
public class ConnectionFactory {
    private static ConnectionFactory ourInstance = new ConnectionFactory();

    private Connection connection;

    public static ConnectionFactory getInstance() {
        return ourInstance;
    }

    private ConnectionFactory() {

    }

    private void setConnection() {
        final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=aplikacja_medyczna";
        final String LOGIN = "root";
        final String PASSWORD = "root";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
