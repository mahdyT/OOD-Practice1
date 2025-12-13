import models.Customer;

public class SmsNotification implements NotificationStrategy {
    @Override
    public void send(Customer customer, String message) {
        System.out.println("Sending SMS to " + customer.mobile + ": " + message);
    }
}