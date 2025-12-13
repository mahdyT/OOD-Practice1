public interface NotificationStrategy {
    void send(Customer customer, String message);
}