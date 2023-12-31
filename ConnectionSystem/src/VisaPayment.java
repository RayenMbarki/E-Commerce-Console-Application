public class VisaPayment implements UserOrderPayment {
    private UserOrderPayment paymentStrategy;

    public VisaPayment(UserOrderPayment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public void pay_your_order(double amount) {
        if (paymentStrategy != null) {
            System.out.println("Paid " + amount + " using [ Visa ].");
        } else {
            System.out.println(" PLEASE SELECT VALID PAYMENT STRATEGY !!");
        }
        System.out.println("\n\n\n");
    }
}