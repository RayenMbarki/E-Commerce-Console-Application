public class PaypalPayment implements UserOrderPayment {
    @Override
    public void pay_your_order(double amount) {
        System.out.println("Paid " + amount + " using Paypal.");
        System.out.println("\n\n\n");
    }
}