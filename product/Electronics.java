import java.util.Scanner;

public class Electronics extends Product{
   private String owner, Smart_or_No;

    public Electronics() {
        super(" ----  YOU ARE ADDING TO ELECTRONICS CATEGORY ---- ");
        Scanner s=new Scanner(System.in) ;
        System.out.print("enter the console / item owner name  : ");
        this.owner=s.nextLine();
        System.out.print("this item is smart when using it  Y/N ? ");
        this.Smart_or_No=s.nextLine();
    }


    public Electronics(int ref, double price, String name, int available_quantity, String recent_review_by_ten, String owner, String smart_or_No) {
        super(price, name, ref, available_quantity, recent_review_by_ten);
        this.owner = owner;
        Smart_or_No = smart_or_No;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setSmart_or_No(String smart_or_No) {
        Smart_or_No = smart_or_No;
    }

    @Override
    public String productCategory() {
        return "Electronics";
    }

    @Override
    public String owner() {
        return owner;
    }

    public String getSmart_or_No() {
        return Smart_or_No;
    }
}
