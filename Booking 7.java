
import java.io.Serializable;
import java.time.LocalDate;

public class Booking implements Serializable {
    private static int idCounter = 1;
    private int id;
    @SuppressWarnings("FieldMayBeFinal")
    private String customerName;
    private String serviceType;
    private LocalDate date;

    public Booking(String customerName, String serviceType, LocalDate date) {
        this.id = idCounter++;
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Booking ID: " + id + ", Customer: " + customerName +
                ", Service: " + serviceType + ", Date: " + date;
    }
}
