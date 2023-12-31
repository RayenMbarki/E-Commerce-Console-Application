import java.util.Scanner;

public class PcAndVideosGames extends Product {
    private String founder,brand;

    public PcAndVideosGames() {
        super(" ----  YOU ARE ADDING TO PcAndVideosGames CATEGORY ---- ");
        Scanner s=new Scanner(System.in) ;
        System.out.print("enter game or pc creator : ");
        this.founder=s.nextLine();
        System.out.print("enter game / pc  local brand : ");
        this.brand=s.nextLine();
    }

    public PcAndVideosGames(int ref, double price, String name, int available_quantity, String recent_review_by_ten, String founder, String brand) {
        super(price, name, ref, available_quantity, recent_review_by_ten);
        this.founder = founder;
        this.brand = brand;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String productCategory() {
        return "PcAndVideosGames";
    }

    @Override
    public String owner() {
        return founder;
    }

    public String getBrand() {
        return brand;
    }
}
