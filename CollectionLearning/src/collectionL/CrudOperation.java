package collectionL;

import java.sql.*;
import java.util.*;

public class CrudOperation {
    private static final String URL = "jdbc:mysql://localhost:3306/movie_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sql = "SELECT * FROM movie_ticket"; // fetch all rows

        try {
            // 1. Connect to database
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create Statement
            Statement stmt = con.createStatement();

            // 3. Execute query
            ResultSet rs = stmt.executeQuery(sql);

            // 4. Loop through ResultSet and print each row
            System.out.println("ID | Movie Name | Customer Name | Seat Number | Price");
            System.out.println("--------------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String movieName = rs.getString("movie_name");
                String customerName = rs.getString("customer_name");
                int seatNumber = rs.getInt("seat_number");
                double price = rs.getDouble("price");

                System.out.printf("%d | %s | %s | %d | %.2f%n",
                        id, movieName, customerName, seatNumber, price);
            }

            // 5. Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
