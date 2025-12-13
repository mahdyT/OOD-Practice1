package services;

import services.payment.PaymentStrategy;
import services.notification.NotificationStrategy;

public class ReservationService {
    private final DiscountService discountService;
    private final InvoicePrinter invoicePrinter;
    private final PaymentStrategy paymentStrategy;
    private final NotificationStrategy notificationStrategy;
    
    public ReservationService(DiscountService discountService, InvoicePrinter invoicePrinter, NotificationService notificationService) {
        this.discountService = discountService;
        this.invoicePrinter = invoicePrinter;
        this.notificationService = notificationService;
    }

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier){
        System.out.println("Processing reservation for " + res.customer.name);

        double basePrice = res.totalPrice();

        double finalPrice = discountService.applyDiscount(basePrice, res.customer);

        paymentStrategy.pay(finalPrice);

        invoicePrinter.print(res, finalPrice);

        notificationStrategy.send(res.customer, "Your reservation confirmed!");
        
        }
}