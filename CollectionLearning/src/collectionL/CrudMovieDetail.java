package collectionL;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CrudMovieDetail {
    private static final String URL = "jdbc:mysql://localhost:3306/movie_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sql = "SELECT * FROM movie_detail";

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("Movie ID | Movie Name | Year Of Release | Lead Actor | Box Office Collection");
            System.out.println("--------------------------------------------------------------------------");

            while (rs.next()) {
                int movie_id = rs.getInt("movie_id");
                String movieName = rs.getString("movie_name");

                Date yearOfRelease = rs.getDate("yearOfRelease");
                String yearOnly = (yearOfRelease != null)
                        ? String.valueOf(yearOfRelease.toLocalDate().getYear())
                        : "N/A";

                String leadActor = rs.getString("leadActor");
                int boxOffice = rs.getInt("boxOffice");

                System.out.printf("%d | %s | %s | %s | %d%n",
                        movie_id, movieName, yearOnly, leadActor, boxOffice);
            }

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
