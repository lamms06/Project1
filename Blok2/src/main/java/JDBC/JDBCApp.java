package JDBC;

import java.sql.*;

public class JDBCApp {

    public static void main(String[] args) throws ClassNotFoundException {


        try {
            //2
            ConnectionObject connectionObject = new ConnectionObject();
            //3
            Statement statement = connectionObject.getPubsConnection().createStatement();
            // 4
            ResultSet resultSet = statement.executeQuery("SELECT * FROM authors");

            // 5
            while (resultSet.next()) {
                String firstname = resultSet.getString("AU_FNAME");
                String lastname = resultSet.getString("AU_LNAME");
                String city = resultSet.getString("city");

                //Author a = Author.builder().firstname(firstname).lastname(lastname).city(city).build();
                //System.out.println(a.toString());
            }

            // 6
            connectionObject.closePubsConnection();

        } catch (SQLException e) {
            //log.error("Er trad een SQL-fout op", e);
        }

    }
}


