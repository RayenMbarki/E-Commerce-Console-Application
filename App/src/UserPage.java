import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserPage {
    private ShoppingCart cart;
    private InventoryManager cartManager;
    private Order orderProduct;
    private User user;
    private List<Product> catalogue_from_admin;
    private boolean in_use=true;
    public UserPage(List<Product> liste) {
        this.user=user;
        cart=new ShoppingCart(liste);
        cartManager=new InventoryManager();
        catalogue_from_admin=liste;
    }



    public void run_app() {
        Scanner s=new Scanner(System.in);
        System.out.print("  -----   enter you account username ------ : ");
        String name=s.nextLine();
        System.out.print("  -----      create you password     ------ : ");
        String pass=s.nextLine();
        user=new User(name,pass);
        user.login();
        if(user.log_check) {
        System.out.println("   DO YOU WANT TO ADD MONEY TO YOUR ACCOUNT : 1. YES  |||  2.NO  ");
         s=new Scanner(System.in);
        int  a=s.nextInt();
        s.nextLine();
        if (a==1) {
            System.out.print("   HOW MUCH : (dollars) ");
            double amount=s.nextDouble();
            user.transferMoneyToAccount(amount);
        }
        while(in_use) {
            System.out.println("   SELECT WHAT YOU WANT TO EXPLORE ON THIS APP  ");
            System.out.println(" [ 1 ] : SEARCH AND ADD PRODUCTS TO YOUR CART");
            System.out.println(" [ 2 ] : REMOVE PRODUCTS TO YOUR CART");
            System.out.println(" [ 3 ] : [ ORDER + PAY + PUT A REVIEW ] A PRODUCT FROM YOUR CART ");
            System.out.println(" [ 4 ] : [  LOGOUT  ] ");
            System.out.println(" [ 5 ] : SEE YOUR SHOPPING CART ");
            int move = s.nextInt();
            s.nextLine();
            switch (move) {
                case 1: {
                    System.out.println("[1]: Search by name");
                    System.out.println("[2]: Search by price");
                    System.out.println("[3]: Search by category");
                    System.out.print("Enter your choice: ");
                    int choice = s.nextInt();
                    s.nextLine();
                    switch (choice) {
                        case 1:
                            user.searchProductByName(catalogue_from_admin);
                            break;
                        case 2:
                            user.filterByPrice(catalogue_from_admin);
                            break;
                        case 3:
                            user.filterByCategorie(catalogue_from_admin);
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                    boolean found=false;
                    boolean repeat=true;
                    while(repeat) {
                        System.out.println("ENTER THE EXACT NAME OF PRODUCT TO ADD TO YOUR CART AFTER THE SEARCH RESULT ");
                        String product=s.nextLine();
                        for (Product p : catalogue_from_admin) {
                            if (p.getName().equals(product)) {
                                found = true;
                                System.out.print("select quantity of  [ " + p.getName() + " ]  to add to your cart : ");
                                int x = s.nextInt();
                                s.nextLine();
                                cart.add_item(p, x);
                                break;
                            }
                        }
                        if (!found) System.out.println("PRODUCT WITH NAME " + product + "DOESN'T EXIST ON THE APP");
                        System.out.println(" DO YOU WANT TO ENTER ANOTHER NAME , [ Y ]  or [ N ]");
                        String ch=s.nextLine();

                        if (ch.equals("N")) break;
                    }

                    break; }
                case 2: {
                    System.out.println("enter product name you want to remove");
                    String ch = s.nextLine();
                    for (Iterator<Map.Entry<Product, Integer>> iterator = cart.getShoppingCart().entrySet().iterator(); iterator.hasNext();) {
                        Map.Entry<Product, Integer> entry = iterator.next();
                        Product product = entry.getKey();
                        if (product.getName().equals(ch)) {
                            cart.remove_item(product);
                        }
                    }
                    break; }
                case 3: {
                    System.out.println("enter product name you want to order from your cart");
                     String ch = s.nextLine();
                    for (Iterator<Map.Entry<Product, Integer>> iterator = cart.getShoppingCart().entrySet().iterator(); iterator.hasNext();) {
                        Map.Entry<Product, Integer> entry = iterator.next();
                        Product product = entry.getKey();
                        if (product.getName().equals(ch)) {
                            orderProduct=new Order(product, entry.getValue(), user.getUserid(),cart);
                            double amount=product.getPrice() * entry.getValue();
                            InventoryManager i=new InventoryManager();
                            i.checkProductStock(product,entry.getValue(),catalogue_from_admin,cart);
                            orderProduct.orderDisplay(catalogue_from_admin);
                            orderProduct.getOrderDetails();
                            orderProduct.getTransactions();

                            int payment=user.pay();
                            switch (payment) {
                                case 1: {
                                    UserOrderPayment currentBalance = new CurrentBalancePayment(user);
                                    currentBalance.pay_your_order(amount);
                                    break;
                                }
                                case 2: {
                                    UserOrderPayment paypalPayment = new PaypalPayment();
                                    paypalPayment.pay_your_order(amount);
                                    break;
                                }
                                case 3: {
                                    ;
                                    UserOrderPayment visaPayment = new VisaPayment(new PaypalPayment());
                                    visaPayment.pay_your_order(amount);
                                    break;
                                }
                                default:
                                    System.out.println("PAYMENT DONE");
                                    break;
                            }
                            user.rateProduct(product);

                            break;
                        }
                    }

                    break; }
                case 4: {
                    System.out.println(      "SEE YOU LATER DEAR CUSTOMER ");
                    System.out.println("   LOGGING OUT IN PROCESS ");

                    user.logout();
                    in_use=false;

                    break; }

                case 5: {
                    cart.displayShoppingCart();
                    break; }

                default:{
                    System.out.println(" SOMETHING GONE WRONG , SELECT THE CORRECT CHOICE ");break;}

            }

        }
    } }
}
