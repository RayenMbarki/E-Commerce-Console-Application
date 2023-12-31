import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InventoryManager {

    public void checkProductsStock(List<Product> availableProds, ShoppingCart cart) {
        Map<Product,Integer> productsToUpdate = new HashMap<>();
        for (Product cartProduct : cart.getShoppingCart().keySet()) {
            int cartQuantity = cart.getShoppingCart().get(cartProduct);
            boolean foundInStock = false;

            for (Product availableProduct : availableProds) {
                if (cartProduct.equals(availableProduct)) {
                    foundInStock = true;
                    int availableQuantity = availableProduct.getAvailable_quantity();

                    if (availableQuantity >= cartQuantity) {
                        System.out.println("Product  [  " + cartProduct.getName() + " ] has enough stock.");
                    } else {
                        System.out.println("Insufficient stock for product  [ " + cartProduct.getName() + " ]  :  Available quantity: " + availableQuantity);
                        productsToUpdate.put(cartProduct,availableQuantity);

                        System.out.println("WE HAVE UPDATED PRODUCT QUANTITY IN YOUR SHOPPING CART.");
                    }
                    break;
                }
            }

            if (!foundInStock) {
                System.out.println("Product '" + cartProduct.getName() + "' not found in available products.");
                cart.remove_item(cartProduct);
            }
        }
        for (Map.Entry<Product, Integer> entry : productsToUpdate.entrySet()) {
            cart.updateQuantity(entry.getKey(), entry.getValue());
        }
        System.out.print("\n\n\n");

    }
    public void checkProductStock(Product productToCheck, int quantity, List<Product> availableProds,ShoppingCart cart) {
        boolean foundInStock = false;

        for (Product availableProduct : availableProds) {
            if (productToCheck.equals(availableProduct)) {
                foundInStock = true;
                int availableQuantity = availableProduct.getAvailable_quantity();
                if (availableQuantity < quantity)  cart.updateQuantity(productToCheck,quantity-availableQuantity);
                break;
            }
        }

        if (!foundInStock) {
            System.out.println("Product [ " + productToCheck.getName() + " ] not found in available products.");

        }
        System.out.print("\n\n\n");
    }



    //discount feature to added products in my shopping cart
    public double priceDiscount(Product p,int numbers) {
        double x=Product.getMininum_price_forDiscount(); // x=200 dollars : target to apply coupon
        double min = 0.0; // min coupon (0% discount )
        double max = 0.3; // max coupon (30% discount)
        Random random = new Random();
        double coupon = min + (max - min) * random.nextDouble();
        if (p.getPrice() * numbers >= x) return p.getPrice()*numbers*(1-coupon);
        System.out.println("THERE IS NO COUPONS FOR THE CURRENT PRICE AS IT IS LOW");
        System.out.print("\n\n\n");

        return (p.getPrice()*numbers);

    }
}
