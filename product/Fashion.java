import java.util.Scanner;

public class Fashion extends Product{
    private String brand,owner;

    public Fashion() {
        super(" ----  YOU ARE ADDING TO FASHION CATEGORY ---- ");
        Scanner s=new Scanner(System.in) ;
        System.out.print("enter fashion item owner name : ");
        this.owner=s.nextLine();
        System.out.print("enter fashion item brand : ");
        this.brand=s.nextLine();


    }
    public Fashion( int ref,double price, String name, int available_quantity, String recent_review_by_ten, String brand, String owner) {
        super(price, name, ref, available_quantity, recent_review_by_ten);
        this.brand = brand;
        this.owner = owner;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String productCategory() {
        return "Fashion";
    }

    @Override
    public String owner() {
        return owner;
    }

    public String brand() {
        return brand;
    }
}
