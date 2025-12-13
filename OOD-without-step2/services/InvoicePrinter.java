import models.Reservation;

public class InvoicePrinter {
    public void print(Reservation reservation, double finalPrice) {
        System.out.println("----- INVOICE -----");
        System.out.println("Customer: " + reservation.customer.name);
        System.out.println("Room: " + reservation.room.number + " (" + reservation.room.type + ")");
        System.out.println("Total: " + finalPrice);
        System.out.println("-------------------");
    }
}