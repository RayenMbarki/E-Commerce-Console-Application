import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Admin implements LoginLogout{
    private String userid,password,role;
    private  boolean log_check = false;
    public  List<Product> catalogue=new ArrayList<>();
    private ProductManager manager;


    public Admin(String userid, String password,List<Product> catalogue) {
        manager=new ProductManager(catalogue);
        this.userid = userid;
        this.password = password;
        this.catalogue=catalogue;
        role="ADMIN";

    }

    public boolean isLog_check() {
        return log_check;
    }

    public ProductManager getManager() {
        return manager;
    }

    public  String getRole() {
        return role;
    }

    @Override
    public void login() {
        System.out.println("                                      YOU ARE IN Admin INTERFACE                                  ");

        Scanner s=new Scanner(System.in);
        System.out.print("Enter your adminName : ");
        String enteredAdminName = s.nextLine();
        System.out.print("Enter your password : ");
        String enteredPassword =s.nextLine();
        System.out.print("---------- Checking entered Informations in Process ------------");
        if  (userid.equals(enteredAdminName) && enteredPassword.equals(password) ) { System.out.println(" <<You are  successfully logged in >>"); log_check=true;}
        else System.out.println(" << please check entered information ,  something gone wrong >>");
        System.out.println("\n\n\n");
    }

    @Override
    public void logout() {
        if (this.log_check) {
            System.out.println(" <<  you are logging out , good bye . >>");
            this.log_check=false;
        }
        else System.out.println(">-------- You were not already logged in ------<");
        System.out.println("\n\n\n");
    }
    public void productsCatalogue() {
        System.out.println("                                          -------------------------- ADMIN  INTERFACE -------------------------");
        System.out.println("                              ----------------------------  ADMIN ENTER  THE PRODUCTS AVAILABLE FOR THE CUSTOMERS  -----------------------");
        Scanner s=new Scanner(System.in);
        System.out.println(" [ 1 ] : ADD PRODUCT OF PC AND VIDEOS GAMES");
        System.out.println(" [ 2 ] : ADD PRODUCT OF ELECTRONICS");
        System.out.println(" [ 3 ] : ADD PRODUCT OF HOME AND GARDEN ");
        System.out.println(" [ 4 ] : ADD PRODUCT OF TOYS AND GAMES");
        System.out.println(" [ 5 ] : ADD PRODUCT OF FASHION");
        System.out.println(" [ 6 ] : ADD PRODUCT OF BOOKS ");
        System.out.println(" [ 7 ] : EXIT  ");
        int choice=s.nextInt();
        s.nextLine();
        switch(choice) {
            case 1: {
                Product p=new PcAndVideosGames();
                manager.add_entered_product(p);
                break;}
            case 2:{
                Product p=new Electronics();
                manager.add_entered_product(p);
                break;}
            case 3:{
                Product p=new HomeAndGarden();
                manager.add_entered_product(p);
                break;}
            case 4:{
                Product p=new ToysAndGames();
                manager.add_entered_product(p);
                break;}
            case 5:{
                Product p=new Fashion();
                manager.add_entered_product(p);
                break;}
            case 6:{
                Product p=new Books();
                manager.add_entered_product(p);
                break;}
            case 7:{

                break;}

            default:{
                System.out.println(" Invalid choice");break;}

        }


        System.out.println("                              ----------------------------  USER INTERFACE  -------------------------");
        System.out.println("                              ------------------   SO NOW YOU CAN FILTER PRODUCTS   -----------------");












    }
}
