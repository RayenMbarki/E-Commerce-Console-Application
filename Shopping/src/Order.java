import java.time.LocalDate;
import java.util.*;

public class Order {
    private Product p;
    private ShoppingCart cart;
    private int quantity;
    private String userId, orderId;
    boolean process = false;
    private static ArrayList<String> id = new ArrayList<>();
    private static Map<String, LocalDate> transactions = new HashMap<>();

    // Constructor to create an order for a product
    public Order(Product p, int quantity, String userId, ShoppingCart cart) {
        this.cart = cart;
        this.p = p;
        this.quantity = quantity;
        this.userId = userId;
        orderId = UUID.randomUUID().toString(); // Generating a unique order ID
        System.out.println("You have selected product [" + p.getName() + "] with reference " + p.getRef() + " to order");
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Getter for user ID
    public String getUserId() {
        return userId;
    }

    // Getter for order ID
    public String getOrderId() {
        return orderId;
    }

    // Method to display the order details and confirm the order
    public void orderDisplay(List<Product> liste) {
        System.out.println("Are you sure to order " + quantity + " items of " + p.getName() + "?");
        System.out.print("Confirm the order: 1 --> [YES] ||| 2 --> [NO]? ");
        Scanner s = new Scanner(System.in);
        int answer = s.nextInt();
        InventoryManager check = new InventoryManager();
        check.checkProductStock(p, quantity, liste, cart);

        switch (answer) {
            case 1: {
                if (quantity <= p.getAvailable_quantity()) {
                    // Updating available quantity, updating cart, and confirming the order
                    for (Product pr : liste) {
                        if (pr.getRef() == p.getRef()) {
                            pr.setAvailable_quantity(p.getAvailable_quantity() - quantity);
                        }
                    }
                    for (int i = 0; i < quantity; i++) {
                        cart.update_item(p, true);
                    }
                    process = true;
                    System.out.println("Items are ready to be ordered");
                    transactions.put(orderId, LocalDate.now()); // Storing the order transaction
                    id.add(orderId);
                } else {
                    System.out.println("You don't have that quantity in your cart");
                }
                break;
            }
            case 2:
                System.out.println("You declined the order. Operation done successfully. See you soon");
                break;
            default:
                System.out.println("You quit the order interface");
        }

        if (process) {
            System.out.println("[ " + quantity + " ] of [ " + p.getName() + "] has been ordered ");
            System.out.println("Your order ID: [ " + orderId + " ] ");
        }
        System.out.println("\n\n\n");
    }

    // Method to get order details
    public void getOrderDetails() {
        System.out.println("Order process has finished");
        if (process) {
            InventoryManager coupon = new InventoryManager();
            double discountedPrice = coupon.priceDiscount(p, quantity);
            System.out.println("Order ID: " + orderId + " ----  " + "Product: " + p.getName() + "  -----  "
                    + "Quantity ordered: " + quantity + "  -----  " + "Total order price: < " + discountedPrice
                    + "  with " + (p.getPrice() * quantity - discountedPrice) + " discount" + " >  ORDER DATE: "
                    + LocalDate.now());
        } else {
            System.out.println("You have not ordered anything");
        }
        System.out.println("\n\n\n");
    }

    // Method to get transaction history
    public void getTransactions() {
        System.out.println("Here is your order history");
        for (String id : id) {
            System.out.println("Order ID: " + id + ", Date: " + transactions.get(id));
        }
        System.out.println("\n\n\n");
    }
}
