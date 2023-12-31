public class CurrentBalancePayment implements UserOrderPayment {
    private User user;

    public CurrentBalancePayment(User user) {
        this.user = user;
    }

    @Override
    public void pay_your_order(double amount) {
        if (user.getMoney_card() >= amount) {
            user.setMoney_card((user.getMoney_card() - amount));
            System.out.println("You Have Paid " + amount + " using your [ current balance ] in your app account ! ");
            System.out.println("Operation [ DONE ]");
        } else {
            System.out.println("Insufficient balance.");
        }
        System.out.println("\n\n\n");
    }
}