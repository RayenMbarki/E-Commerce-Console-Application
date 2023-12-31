import java.util.Scanner;

public class ToysAndGames extends  Product{
    private String owner;
    private String brand;

    public ToysAndGames() {
        super(" ----  YOU ARE ADDING TO ToysAndGames CATEGORY ---- ");
        Scanner s=new Scanner(System.in) ;
        System.out.print("enter product owner name  : ");
        this.owner=s.nextLine();
        System.out.print("enter product brand : ");
        this.brand=s.nextLine();


    }

    public ToysAndGames(int ref, double price, String name, int available_quantity, String recent_review_by_ten, String owner, String brand) {
        super(price, name, ref, available_quantity, recent_review_by_ten);
        this.owner = owner;
        this.brand = brand;
    }

    @Override
    public String productCategory() {
        return "ToysAndGames";
    }

    @Override
    public String owner() {
        return owner ;
    }
    public String brand() {
        return brand;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
