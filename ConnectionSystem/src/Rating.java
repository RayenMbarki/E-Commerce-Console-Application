import java.util.Scanner;

public class Rating {
    private String stars, review;

    // Method to add a review for a product
    public void addreview(Product p) {
        Scanner s = new Scanner(System.in);

        // Prompting for rating
        System.out.println("RATE THE " + p.getName() + " YOU PURCHASED:");
        System.out.println("1 --> [*]");
        System.out.println("2 --> [**]");
        System.out.println("3 --> [***]");
        System.out.println("4 --> [****]");
        System.out.println("5 --> [*****]");
        int star_nb = s.nextInt();

        // Assigning stars based on rating
        switch (star_nb) {
            case 1:
                stars = "MY REVIEW FOR " + p.getName() + " : [*----]";
                break;
            case 2:
                stars = "MY REVIEW FOR " + p.getName() + " : [**---]";
                break;
            case 3:
                stars = "MY REVIEW FOR " + p.getName() + " : [***--]";
                break;
            case 4:
                stars = "MY REVIEW FOR " + p.getName() + " : [****-]";
                break;
            case 5:
                stars = "MY REVIEW FOR " + p.getName() + " : [*****]";
                break;
            default:
                break;
        }

        // Prompting for additional comments
        System.out.print("DO YOU WANT TO POINT OUT SOMETHING ABOUT THIS PRODUCT: ");
        s.nextLine(); // Consuming newline character after the previous nextInt()
        String ch = s.nextLine();
        review = ch;

        // Displaying saved review and comments
        System.out.println("YOUR REVIEW HAS BEEN SAVED");
        System.out.println(stars + " ------- MY COMMENTS: '" + review + "'");
    }
}