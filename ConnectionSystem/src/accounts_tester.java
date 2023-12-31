import java.util.Scanner;

public class accounts_tester {
    public static void main(String[] args) {
        User Rayen = new User("rayen_26", "Ray0#_pre");
        if (Rayen.getRole().equals("USER"))
            System.out.println("                                                                                        YOU ARE NOW ON USER INTERFACE ");
        else System.out.println("                                              YOU ARE NOW ON ADMIN INETRFACE :");
        System.out.print("    Select an option depending on type of your created account   :   ");
        System.out.println("        YOUR ARE NOW ON << LOGIN / LOGOUT >> SYSTEM   ");
        System.out.println("  click [ login ]  - [ logout ]  : ");
        Scanner s = new Scanner(System.in);
        String access = s.nextLine();
        switch (access) {
            case "login":
                Rayen.login();
                break;
            case "logout":
                Rayen.logout();
                break;
            default:
                break;
        }

        if (Rayen.log_check) {
            Rayen.transferMoneyToAccount(10000);
        /*Rayen.searchProductByName();
        Rayen.filterByPrice();
        Rayen.filterByCategorie();*/

            int paymentMethod = Rayen.pay();

            switch (paymentMethod) {
                case 1: {
                    UserOrderPayment currentBalance = new CurrentBalancePayment(Rayen);
                    currentBalance.pay_your_order(1500);
                    break;
                }
                case 2: {
                    UserOrderPayment paypalPayment = new PaypalPayment();
                    paypalPayment.pay_your_order(1500);
                    break;
                }
                case 3: {
                    ;
                    UserOrderPayment visaPayment = new VisaPayment(new PaypalPayment());
                    visaPayment.pay_your_order(1500);
                    break;
                }
                default:
                    System.out.println("PAYMENT DONE");
                    break;
            }


        }

    }
}