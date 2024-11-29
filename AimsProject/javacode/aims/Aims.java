// DigitalVideoDisc.java
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    // Override equals() and hashCode() for correct comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DigitalVideoDisc that = (DigitalVideoDisc) obj;
        return title.equals(that.title) && director.equals(that.director);
    }

    @Override
    public int hashCode() {
        return 31 * title.hashCode() + director.hashCode();
    }
}

// Cart.java
import java.util.ArrayList;

public class Cart {
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    // Add a DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        itemsOrdered.add(dvd);
    }

    // Remove a DVD from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        itemsOrdered.remove(dvd);
    }

    // Get the total cost of all DVDs in the cart
    public float totalCost() {
        float total = 0;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            total += dvd.getCost();
        }
        return total;
    }

    // Get the quantity of DVDs in the cart
    public int getQtyOrderd() {
        return itemsOrdered.size();
    }
}

// Aims.java
public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        // Create and add DigitalVideoDisc objects to the cart
        DigitalVideoDisc dics1 = new DigitalVideoDisc("The Lion King", "Animation", 
                "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dics1);

        DigitalVideoDisc dics2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 
                "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dics2);

        DigitalVideoDisc dics3 = new DigitalVideoDisc("Aladin", "Animation", 
                "George Lucas", 87, 18.99f);
        anOrder.addDigitalVideoDisc(dics3);

        // Print the total cost and quantity
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println("So luong: " + anOrder.getQtyOrderd());

        // Create a DigitalVideoDisc object to remove
        DigitalVideoDisc disc4 = new DigitalVideoDisc("The Lion King", "Animation", 
                "Roger Allers", 87, 19.95f);
        anOrder.removeDigitalVideoDisc(disc4);

        // Print the updated total cost and quantity
        System.out.println("New total cost is:");
        System.out.println(anOrder.totalCost());
        System.out.println("So luong: " + anOrder.getQtyOrderd());
    }
}
