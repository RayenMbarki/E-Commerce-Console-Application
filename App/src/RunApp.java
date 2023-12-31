import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RunApp {
    private static boolean app_working ;
    private List<Product> catalogue=new ArrayList<>();


    public void open_app() {
        Scanner s=new Scanner(System.in);
        System.out.println("   1 .[  OPEN  APP  ]     ||||    2.  [  DON'T ]  ---- >");
        int ch=s.nextInt();
        s.nextLine();
        switch(ch) {
            case 1:{app_working=true;this.navigateMerch();break;}
            case 2:{System.out.println("  --------    E-COMMERCE APPLICATION HAS NOT BEEN OPENED  ---------   ");break;}
            default:break;
        }

    }
    public void navigateMerch() {
        while (app_working) {
            System.out.println("  --------    E-COMMERCE APPLICATION  ---------   ");
            System.out.println(" [ 1 ]  [ CONNECT AS CUSTOMER ]");
            System.out.println(" [ 2 ]  [  CONNECT AS ADMIN   ] ");
            System.out.println(" [ 3 ]  [         CLOSE THE APP        ]");
            Scanner s=new Scanner(System.in);
            int connect=s.nextInt();
            s.nextLine();
            switch(connect) {
                case 1:{
                    System.out.print("  ------   HELLO DEAR CUSTOMER  ------------ ");
                    System.out.println("         CREATE YOUR ACCOUNT");

                    UserPage userInterface=new UserPage(catalogue);
                    userInterface.run_app();break;
                }
                case 2:{
                    System.out.print("  --------   HELLO MR ADMIN  ---------");
                    System.out.print("enter you account username : ");
                    String name=s.nextLine();
                    System.out.print(" create you password : ");
                    String pass=s.nextLine();
                    Admin admin=new Admin(name,pass,catalogue);
                    AdminPage adminInterface=new AdminPage(admin);
                    adminInterface.handle_app();break;
                }
                case 3:{app_working=false;System.out.println(" ------  YOU HAVE CLOSED THE APP  --------");break;}
            }
        }
    }
}
