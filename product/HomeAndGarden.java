import java.util.Scanner;

public class HomeAndGarden extends Product{
    private String creator , electricity_use;

    public HomeAndGarden() {
        super(" ----  YOU ARE ADDING TO HomeAndGarden CATEGORY ---- ");
        Scanner s=new Scanner(System.in) ;
        System.out.print("enter the item maker name  : ");
        this.creator=s.nextLine();
        System.out.print("this item use electricity Y/N ? ");
        this.electricity_use=s.nextLine();
    }

    public HomeAndGarden(int ref, double price, String name, int available_quantity, String recent_review_by_ten, String creator, String electricity_use) {
        super(price, name, ref, available_quantity, recent_review_by_ten);
        this.creator = creator;
        this.electricity_use = electricity_use;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setElectricity_use(String electricity_use) {
        this.electricity_use = electricity_use;
    }

    public String getElectricity_use() {
        return electricity_use;
    }

    @Override
    public String productCategory() {
        return "HomeAndGarden";
    }

    @Override
    public String owner() {
        return creator;
    }
}
