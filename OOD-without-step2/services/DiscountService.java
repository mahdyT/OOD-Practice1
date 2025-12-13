import models.Customer;
import models.Reservation;

public class DiscountService {
    public double applyDiscount(double basePrice, Customer customer) {
        if ("Paris".equals(customer.city)) {
            System.out.println("Apply city discount for Paris!");
            return basePrice * 0.9;
        }
        return basePrice;
    }
}