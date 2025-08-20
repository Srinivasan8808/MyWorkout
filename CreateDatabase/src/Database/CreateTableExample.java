package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school_db"; // Now DB name is here
        String user = "root";
        String password = "root";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE students (" +
                         "id INT PRIMARY KEY AUTO_INCREMENT, " +
                         "name VARCHAR(50) NOT NULL, " +
                         "grade INT NOT NULL" +
                         ")";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

