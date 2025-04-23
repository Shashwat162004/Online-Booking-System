
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class BookingManager {
    private List<Booking> bookings;
    private final String FILE_NAME = "bookings.txt";

    public BookingManager() {
        bookings = new ArrayList<>();
        loadBookings();
    }

    public void addBooking(String name, String service, LocalDate date) {
        Booking booking = new Booking(name, service, date);
        bookings.add(booking);
        saveBookings();
        System.out.println("Booking added: " + booking);
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            bookings.forEach(System.out::println);
        }
    }

    public void deleteBooking(int id) {
        boolean removed = bookings.removeIf(b -> b.getId() == id);
        if (removed) {
            saveBookings();
            System.out.println("Booking with ID " + id + " deleted.");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    private void saveBookings() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Error saving bookings: " + e.getMessage());
        }
    }

    private void loadBookings() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            bookings = (List<Booking>) in.readObject();
        } catch (Exception e) {
            bookings = new ArrayList<>();
        }
    }
}
