import services.notification.NotificationStrategy;
import models.Customer;

public class NotificationService {
    private final NotificationStrategy strategy;

    public NotificationService(NotificationStrategy strategy) {
        this.strategy = strategy;
    }
    public void notify(Customer customer, String message) {
        strategy.send(customer, message);
    }
}