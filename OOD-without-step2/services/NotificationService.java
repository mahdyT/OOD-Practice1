import constants.Notifier;
import models.Customer;

public class NotificationService {
    public void notify(Customer customer, String message, Notifier notifierType) {
        switch (notifierType) {
            case EMAIL:
                EmailSender emailSender = new EmailSender();
                emailSender.sendEmail(customer.email, message);
                break;
            case SMS:
                System.out.println("Sending SMS to " + customer.mobile + ": " + message);
                break;
            default:
                System.out.println("There is no Message Provider");
        }
    }
}