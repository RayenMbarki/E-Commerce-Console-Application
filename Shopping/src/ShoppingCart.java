import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class ShoppingCart {

    private  Map<Product,Integer> shoppingCart = new HashMap<>();
    private List<Product> liste;
    public ShoppingCart(List<Product> liste) {
        shoppingCart = new HashMap<>();
        this.liste=liste;
    }

    public  void add_item(Product p,int quantity) {

        System.out.println("------item addition to your cart has begun , the operation will be instantly ----- :");

        if (this.shoppingCart.containsKey(p)) {

            if (quantity > p.getAvailable_quantity()) shoppingCart.put(p, p.getAvailable_quantity());
            else {
                int x = shoppingCart.get(p);
                x++;
                shoppingCart.put(p, x);
            }
        }

        else {if (quantity > p.getAvailable_quantity()) shoppingCart.put(p, p.getAvailable_quantity());
        else  shoppingCart.put(p, quantity);
        }
        System.out.print("\n\n\n");
    }

    public  Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void remove_item(Product productToRemove) {
        System.out.print("---- item [ " + productToRemove.getName()+ " ]  delete has begun -----  :");
        if (shoppingCart.containsKey(productToRemove)) {
            shoppingCart.remove(productToRemove);
            System.out.println("Item removed successfully");
        } else {
            System.out.println("This item is not in your cart.");
        }
    }


    public  void update_item(Product p,boolean orderStatut) {
        Scanner s=new Scanner(System.in);
        if (shoppingCart.containsKey(p)) {
            if (orderStatut ) {
                if (shoppingCart.get(p) == 0) {
                    shoppingCart.remove(p);
                }

                else  {
                    shoppingCart.put(p, (shoppingCart.get(p)) - 1);
                }

            } else {
                System.out.println("you want to decrease or increase quantity of this product to your chart , answer by ---INC--- OR ---DEC--- :  ? ");
                String answer = s.nextLine();
                System.out.println("----------" + p.productCategory() + " product update will begin instantly -------: ");


                if (answer.equals("INC")) {
                    System.out.print("how many item of this product you want to add ?");
                    int x = s.nextInt();
                    shoppingCart.put(p, (shoppingCart.get(p)) + x);
                } else {
                    System.out.print("how many items of this product you want to remove ?");
                    int x = s.nextInt();
                    if (shoppingCart.get(p) >= x) {
                        shoppingCart.put(p, (shoppingCart.get(p)) - x);
                        if (shoppingCart.get(p) == 0) shoppingCart.remove(p);
                    } else {
                        System.out.println("quantity of this product already low than the inputed number !!!!!");
                    }
                }

            }
        }
        else System.out.println("you have not already added this item to your cart before ");
        if (shoppingCart.get(p)==0) shoppingCart.remove(p);
        System.out.print("\n\n\n");
    }
    public  void displayShoppingCart() {
        try {
            if (shoppingCart.isEmpty()) {
                throw new Exception("EmptyCartException");
            }

            System.out.println("HERE IS YOUR ACTUAL SHOPPING CART ------ > :");
            for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
                System.out.println("Product : " + entry.getKey().getName() + "   ------> " + " selected Quantity : " + entry.getValue());
            }
        } catch (Exception e) {
            System.out.println("Your shopping cart is empty.");
        }
        System.out.print("\n\n\n");
    }

    public  void updateQuantity(Product product, int newQuantity) {
        if (newQuantity==0) {this.remove_item(product);}
        else shoppingCart.put(product, newQuantity);
        System.out.print("\n\n\n");
    }
    public void emptyCart() {
        this.shoppingCart.clear();
    }



}
