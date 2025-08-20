package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabaseExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/"; // No DB name here
        String user = "root";
        String password = "root";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql = "CREATE DATABASE school_db";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

