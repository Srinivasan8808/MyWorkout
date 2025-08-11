package BusR;

import java.util.Scanner;
import java.sql.*;

class Canceled extends ConnectionDb {

    public static void cancel() {
        Scanner sc = new Scanner(System.in); // Do NOT close if program needs more input later

        System.out.print("Enter Booking ID to cancel: ");
        int bookingIdToCancel = sc.nextInt();

        Connection con = null;

        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, user, password);
            con.setAutoCommit(false); // Start transaction

            // 1️⃣ Check if booking exists
            String checkBookingSql = "SELECT * FROM BOOKING WHERE BOOKING_ID = ?";
            try (PreparedStatement checkBookingStatement = con.prepareStatement(checkBookingSql)) {
                checkBookingStatement.setInt(1, bookingIdToCancel);
                try (ResultSet rs = checkBookingStatement.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Booking with ID " + bookingIdToCancel + " not found.");
                        return; // Exit without committing
                    }

                    int canceledSeats = rs.getInt("NUMBER_SEAT");
                    int busId = rs.getInt("B_ID");

                    // 2️⃣ Update bus seat count
                    String updateBusSql = "UPDATE BUS SET SEAT_COUNT = SEAT_COUNT + ? WHERE B_ID = ?";
                    try (PreparedStatement updateBusStatement = con.prepareStatement(updateBusSql)) {
                        updateBusStatement.setInt(1, canceledSeats);
                        updateBusStatement.setInt(2, busId);
                        updateBusStatement.executeUpdate();
                    }

                    // 3️⃣ Delete booking record
                    String deleteBookingSql = "DELETE FROM BOOKING WHERE BOOKING_ID = ?";
                    try (PreparedStatement deleteBookingStatement = con.prepareStatement(deleteBookingSql)) {
                        deleteBookingStatement.setInt(1, bookingIdToCancel);
                        deleteBookingStatement.executeUpdate();
                    }

                    con.commit(); // ✅ Commit after both updates
                    System.out.println("Booking successfully canceled!");
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    con.rollback(); // Rollback if failure
                    System.out.println("Transaction rolled back due to error.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
