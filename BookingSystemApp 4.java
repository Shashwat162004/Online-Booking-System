
import java.time.LocalDate;
import java.util.Scanner;

public class BookingSystemApp {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Online Booking System ---");
            System.out.println("1. View Bookings");
            System.out.println("2. Add Booking");
            System.out.println("3. Delete Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manager.viewBookings();
                case 2 -> {
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter service type: ");
                    String service = sc.nextLine();
                    System.out.print("Enter date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    manager.addBooking(name, service, date);
                }
                case 3 -> {
                    System.out.print("Enter booking ID to delete: ");
                    int id = sc.nextInt();
                    manager.deleteBooking(id);
                }
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}
