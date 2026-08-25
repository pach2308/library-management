package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
            DatabaseConfig dbc = new DatabaseConfig();
            String url = dbc.getUrl();
            String username = dbc.getUserName();
            String password = dbc.getPassWord();
            return DriverManager.getConnection(url, username, password);
    }
    public static void closeConnection(Connection c){
        if(c!=null){
            try{
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
