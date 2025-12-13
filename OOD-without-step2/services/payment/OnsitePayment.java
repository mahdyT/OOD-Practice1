public class OnsitePayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid On-site: " + amount);
    }
}