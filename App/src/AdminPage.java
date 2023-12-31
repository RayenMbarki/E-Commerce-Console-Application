import java.util.Scanner;

public class AdminPage {
    private boolean in_use=true;
    private Admin admin;


    public AdminPage(Admin admin) {
        this.admin = admin;
    }

    public void handle_app() {
        admin.login();
        if (admin.isLog_check()) {
            while (in_use) {
                System.out.println(" -- Admin Menu --");
                System.out.println(" [ 1 ] :Add Product");
                System.out.println(" [ 2 ] :Remove Product");
                System.out.println(" [ 3 ] :update Product");
                System.out.println(" [ 4 ] :DISPLAY PRODUCTS CATALOGUE ON THE APP");
                System.out.println(" [ 5 ] : LOGOUT");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                sc.nextLine();
                boolean found = false;
                switch (choice) {
                    case 1: {
                        admin.productsCatalogue();
                        break;
                    }
                    case 2: {
                        System.out.println("ENTER THE EXACT NAME OF PRODUCT YOU WANT TO REMOVE :  ");
                        String product = sc.nextLine();
                        for (Product p : admin.catalogue) {
                            if (p.getName().equals(product)) {
                                found = true;
                                admin.getManager().delete_product(p.getRef());
                                break;
                            }
                        }
                        if (!found)
                            System.out.println(" ITEM  " + product + " already not added on the e-commerce app");
                        break;
                    }
                    case 3: {
                        System.out.println("ENTER THE EXACT NAME OF PRODUCT YOU WANT TO UPDATE :  ");
                        String product = sc.nextLine();
                        for (Product p : admin.catalogue) {
                            if (p.getName().equals(product)) {
                                found = true;
                                admin.getManager().update_product(p.getRef());
                                break;
                            }
                        }
                        if (!found)
                            System.out.println(" ITEM  " + product + " already not added on the e-commerce app");
                        break;
                    }
                    case 4: {
                        admin.getManager().display_products();
                        break;
                    }
                    case 5: {
                        admin.logout();
                        in_use = false;
                        break;
                    }

                    default: {
                        System.out.println(" Invalid choice");
                        break;
                    }

                }

            }

        }
        else System.out.println("YOUR SESSION HAS EXPIRED ( YOU HAVE LOGGED OUT ) ");
    }

}
