package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionObject {

    private static Connection connection = null;

    public ConnectionObject() {
        String url = "jdbc:mysql://localhost:3306/pubs";
        String user = "root";
        String pass = "root";
        try{
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public Connection getPubsConnection(){
        return connection;
    }

    public void closePubsConnection() throws SQLException {
        connection.close();
    }
}