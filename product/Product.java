import java.util.Scanner;

public abstract class Product {
    private double price;
    private String name;
    private int ref;
    private int available_quantity ;
    private String  recent_review;
    private static double mininum_price_forDiscount =200.00; //when an order price is >= 200dollars : you can have a discount on your order


    public Product(String msg) {
        System.out.println(msg);
        Scanner s=new Scanner(System.in) ;
        System.out.print("enter product name : ");
        this.name=s.nextLine();
        System.out.print("enter product price : ( dollars ) : ");
        this.price=s.nextDouble();
        System.out.print("enter product available quantity : ");
        this.available_quantity=s.nextInt();
        s.nextLine();
        System.out.print("enter product recently review : ( exe :  ***-- )   : ");
        this.recent_review=s.nextLine();
        this.ref=HashPass.idGenerator(name);
    }

    public Product(double price, String name, int ref, int available_quantity, String recent_review_by_ten) {
        this.name=name;
        this.ref = ref;
        this.available_quantity=available_quantity;
        this.price=price;
        this.recent_review= recent_review_by_ten;
    }

    public static double getMininum_price_forDiscount() {
        return mininum_price_forDiscount;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public String getReview_by_ten() {
        return recent_review;
    }

    public abstract String productCategory();

    public void updateQuantity(int amount) {
        if (amount > 0 && amount <= available_quantity) {
            available_quantity -= amount;
            System.out.println("Quantity of " + name + " decreased by " + amount);
        } else {
            System.out.println("Invalid quantity to decrease or insufficient stock.");
        }

        System.out.print("\n\n\n");

    }

    public abstract  String owner();
}


