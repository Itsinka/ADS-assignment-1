package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL{
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/BooksDB";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "123456789");
            //System.out.println("Connected!");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}