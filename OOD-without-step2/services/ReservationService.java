package services;

import constants.Notifier;
import constants.PaymentMethods;

public class ReservationService {
    private final DiscountService discountService;
    private final InvoicePrinter invoicePrinter;
    private final NotificationService notificationService;
    private PaymentProcessor paymentProcessor = new PaymentProcessor();

    public ReservationService(DiscountService discountService, InvoicePrinter invoicePrinter, NotificationService notificationService) {
        this.discountService = discountService;
        this.invoicePrinter = invoicePrinter;
        this.notificationService = notificationService;
    }

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier){
        System.out.println("Processing reservation for " + res.customer.name);

        // محاسبه قیمت پایه
        double basePrice = res.totalPrice();

        // اعمال تخفیف
        double finalPrice = discountService.applyDiscount(basePrice, res.customer);

        switch (paymentType){
            case CARD:
                paymentProcessor.payByCard(res.totalPrice());
                break;
            case PAYPAL:
                paymentProcessor.payByPayPal(res.totalPrice());
                break;
            case CASH:
                paymentProcessor.payByCash(res.totalPrice());
                break;
            case ONSITE:
                paymentProcessor.payByOnsite(res.totalPrice());
                break;
        }

        invoicePrinter.print(res, finalPrice);

        notificationService.notify(res.customer, "Your reservation confirmed!", notifierType);

        if (res.room instanceof LuxuryRoom) {
            ((LuxuryRoom) res.room).addFreeDinner();
    }
}