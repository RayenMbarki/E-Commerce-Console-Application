import java.util.Scanner;

public class Books extends Product{

    private String writer, theme;

    public Books() {

        super(" ----   YOU ARE ADDING TO BOOKS CATEGORY ---- ");
        Scanner s=new Scanner(System.in) ;
        System.out.print("enter book writer : ");
        this.writer=s.nextLine();
        System.out.print("enter book theme : ");
        this.theme=s.nextLine();
    }

    public Books(int ref, double price, String name, int available_quantity, String recent_review_by_ten, String writer, String theme) {
        super(price, name, ref, available_quantity, recent_review_by_ten);
        this.writer = writer;
        this.theme = theme;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String productCategory() {
        return "Books";
    }

    @Override
    public String owner() {
        return writer;
    }
    public String theme() {
        return theme;
    }
}
