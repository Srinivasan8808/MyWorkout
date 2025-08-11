package BusR;

import java.sql.*;

public class Bus extends ConnectionDb {

    public static void displayBusDetails() {
        String sql = "SELECT B_ID, B_NAME, B_TYPE, SEAT_TYPE, SEAT_COUNT FROM BUS";

        try (
            Connection con = DriverManager.getConnection(DB_URL, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)
        ) {
            Class.forName(JDBC_DRIVER);

            while (rs.next()) {
                System.out.print("BUS_ID : " + rs.getInt("B_ID"));
                System.out.print(", BUS_NAME : " + rs.getString("B_NAME"));
                System.out.print(", BUS_TYPE : " + rs.getString("B_TYPE"));
                System.out.print(", SEAT_TYPE : " + rs.getString("SEAT_TYPE"));
                System.out.print(", SEAT_COUNT : " + rs.getInt("SEAT_COUNT"));
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
