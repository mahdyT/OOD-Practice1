import models.Customer;

public class EmailNotification implements NotificationStrategy {
    @Override
    public void send(Customer customer, String message) {
        System.out.println("Sending email to " + customer.email + ": " + message);
    }
}