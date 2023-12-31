import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements LoginLogout {
    private String userid, password, role;
    private Rating myReview = new Rating();
    private double money_card;



    public  boolean log_check = false;

    // Constructor to initialize user information
    public User(String userid, String password) {
        // Displaying information about user account creation
        System.out.println("Your User Account has been created with the inputted Information.");
        this.userid = userid;
        this.password = password;
        role = "USER";
    }

    // Method to allow the user to rate a product
    public void rateProduct(Product p) {
        myReview.addreview(p);
    }

    // Getter method for user ID
    public String getUserid() {
        return userid;
    }

    // Login method implementation
    @Override
    public void login() {
        // Displaying the user interface for login
        System.out.println("YOU ARE IN USER INTERFACE");
        Scanner s = new Scanner(System.in);

        // Prompting for username and password
        System.out.print("Enter your username: ");
        String enteredUsername = s.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = s.nextLine();
        System.out.print("Checking entered information...");

        // Validating entered username and password
        if (userid.equals(enteredUsername) && enteredPassword.equals(password)) {
            System.out.println("You are successfully logged in.");
            log_check = true;
        } else {
            // Invalid login attempt
            System.out.println("Please check entered information. Something went wrong.");
            System.out.println("YOU WANT TO RECONNECT AGAIN? (NB: please answer by: Y or N)");
            String ch = s.nextLine();
            if (ch.equals("Y")) {
                login(); // Recursive call to login if user chooses to reconnect
            } else {
                System.out.println("[OK SEE YOU SOON]");
                log_check=false;
            }
        }
    }

    // Getter method for user role
    public String getRole() {
        return role;
    }

    // Logout method implementation
    @Override
    public void logout() {
        if (this.log_check) {
            System.out.println("You are logging out. Goodbye.");
            this.log_check = false;
        } else {
            System.out.println("You were not already logged in.");
        }
    }

    // Method to search for a product by name
    public void searchProductByName(List<Product> liste) {
        // Retrieving product information from the admin
        /*System.out.println("Retrieving catalog of all available products...");
        Admin a = new Admin("admin", "admin123");
        a.productsCatalogue();
        List<Product> liste = a.catalogue;*/

        // Prompting for the name of the product to search for
        System.out.print("Enter the name of the product you are searching for: ");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        List<String> searchResults = new ArrayList<>();

        // Searching for the product by name
        for (Product product : liste) {
            if (product.getName().equalsIgnoreCase(name.toLowerCase())) {
                searchResults.add(product.getName());
            }
        }

        // Displaying search results
        if (searchResults.isEmpty()) {
            System.out.println("No products found matching the search query.");
        } else {
            System.out.println("Products found:");
            for (String productName : searchResults) {
                System.out.println("- " + productName);
            }
        }
    }

    // Method to filter products by price range
    public void filterByPrice(List<Product> liste) {
        // Retrieving product information from the admin
        /*System.out.println("Retrieving catalog of all available products...");
        System.out.println("We are about to check products in the stock and list them for you. Be patient.");
        Admin a = new Admin("admin", "admin123");
        a.productsCatalogue();
        List<Product> productList = a.catalogue;*/

        // Prompting for minimum and maximum price range
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter the maximum price: ");
        double maxPrice = scanner.nextDouble();

        // Filtering products within the specified price range
        List<String> searchResults = new ArrayList<>();
        for (Product product : liste) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                searchResults.add(product.getName());
            }
        }

        // Displaying filtered products
        if (searchResults.isEmpty()) {
            System.out.println("No products found within the given price range.");
        } else {
            System.out.println("Products found within the given price range:");
            for (String productName : searchResults) {
                System.out.println("- " + productName);
            }
        }
    }

    // Method to filter products by category
    public void filterByCategorie(List<Product> liste) {
        // Retrieving product information from the admin
        /*System.out.println("Retrieving catalog of all available products...");
        System.out.println("We are about to check products in the stock and list them for you. Be patient.");
        Admin a = new Admin("admin", "admin123");
        a.productsCatalogue();
        List<Product> productList = a.catalogue;*/

        // Prompting for the category
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category: ");
        String category = scanner.nextLine();

        // Filtering products by category
        List<String> searchResults = new ArrayList<>();
        for (Product product : liste) {
            if (product.productCategory().equalsIgnoreCase(category)) {
                searchResults.add(product.getName());
            }
        }

        // Displaying filtered products
        if (searchResults.isEmpty()) {
            System.out.println("No products found in the given category.");
        } else {
            System.out.println("Products found in the given category:");
            for (String productName : searchResults) {
                System.out.println("- " + productName);
            }
        }
    }

    // Method to transfer money to the user's account
    public void transferMoneyToAccount(double amount) {
        if (amount > 0) {
            this.money_card += amount;
            System.out.println(amount + " dollars transaction successfully done to " + userid + "'s account.");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void setMoney_card(double money_card) {
        this.money_card = money_card;
    }

    // Getter method for money in user's account
    public double getMoney_card() {
        return money_card;
    }

    // Method for payment selection
    public int pay() {
        Scanner s = new Scanner(System.in);
        System.out.println("CHOOSE WHICH PAYMENT METHOD YOU WANT TO PROCEED WITH:");
        System.out.println("[1] Your Current Balance");
        System.out.println("[2] Your PayPal");
        System.out.println("[3] Your Visa Card");
        int payment = s.nextInt();
        return payment;
    }
}
