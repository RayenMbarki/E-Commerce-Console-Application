import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ProductManager {
    // List to store products
    private static List<Product> products = new ArrayList<Product>();
    private static int ref = 01;

    // Method to add a product to the list


    public ProductManager(List<Product> products) {
        ProductManager.products=products;
    }

    public  void add_entered_product(Product p) {
        boolean check = true;
        System.out.println("Adding a " + p.productCategory() + " product to the products list");

        // Checking if the product already exists
        for (Product product : products) {
            if (product.getRef() == p.getRef()) {
                check = false;
                product.setAvailable_quantity(product.getAvailable_quantity()+p.getAvailable_quantity());
                break;
            }
        }

        // If product doesn't exist, add it; otherwise, display a message
        if (check)
            products.add(p);
        System.out.println("Product has been successfully saved");

        System.out.print("\n\n\n");
    }

    // Method to delete a product from the list based on its reference ID
    public  void delete_product(int ref) {
        Product check = null;

        // Finding the product based on the reference ID
        for (Product p : products) {
            if (p.getRef() == ref) {
                check = p;
                break;
            }
        }

        // If the product is found, remove it; otherwise, display a message
        if (check == null) {
            System.out.println("Delete operation failed! Product with ID " + ref + " not found");
        } else {
            products.remove(check);
            System.out.println("Product has been successfully deleted");
        }
        System.out.print("\n\n\n");
    }

    // Method to update product details based on its reference ID
    public  void update_product(int ref) {
        Product searchedProduct = null;
        Scanner s = new Scanner(System.in);

        // Finding the product based on the reference ID
        for (Product p : products) {
            if (p.getRef() == ref) {
                searchedProduct = p;
                break;
            }
        }

        // If the product is found, update its details; otherwise, display a message
        if (searchedProduct == null) {
            System.out.println("Update operation failed! Product with ID " + ref + " not found");
        } else {
            System.out.print("Enter new name: ");
            String name = s.nextLine();
            System.out.print("Enter new price: ");
            double price = s.nextDouble();
            System.out.print("Enter new review rate: ");
            String rate = s.nextLine(); // consumes the newline after nextDouble()
            s.nextLine();
            searchedProduct.setName(name);
            searchedProduct.setPrice(price);
        }
        System.out.println("\n\n\n");
    }

    // Method to display all products in the list
    public  void display_products() {
        System.out.println("--------ID -------- NAME ------ PRICE ------- CATEGORY ------- OWNER -------- QUANTITY ");
        for (Product p : products) {
            System.out.println(
                    p.getRef() + " -------- " + p.getName() + " ------ " + p.getPrice() + " ------- " + p.productCategory()
                            + " ------- " + p.owner() + " -------- " + p.getAvailable_quantity()
            );
        }
        System.out.println("\n\n\n");
    }
}
