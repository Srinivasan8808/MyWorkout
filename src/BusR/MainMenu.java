package BusR;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {  // Entry point for Eclipse
        Scanner sc = new Scanner(System.in);

        while (true) {
            main_menu(); // Show main menu
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Login selected.");
                    sub_menu();
                    break;
                case 2:
                    System.out.println("Signup selected.");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return; // Exit program
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static void main_menu() {
        System.out.println("---- Welcome to Reservation ----");
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.println("3. Exit");
    }

    public static void sub_menu() {
        System.out.println("======================================");
        System.out.println("           --- Enjoy yourself ---     ");
        System.out.println("1. Bus Details");
        System.out.println("2. Reserve Tickets");
        System.out.println("3. Cancel Tickets");
        System.out.println("4. Exit to Main Menu");
    }
}
