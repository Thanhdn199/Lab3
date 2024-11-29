package Main;

public class Store {
    private static final int MAX_NUMBERS_ITEMS = 20;
    private DigitalVideoDisc[] itemInStore = new DigitalVideoDisc[MAX_NUMBERS_ITEMS];
    private int qtyItems = 0;

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyItems < MAX_NUMBERS_ITEMS) {
            itemInStore[qtyItems] = dvd;
            qtyItems++;
            System.out.println("Added Item: " + dvd.toString());
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }

    // Method to remove a DVD from the store
    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyItems; i++) {
            if (dvd.equals(itemInStore[i])) {  // Check equality of the DVD
                // Shift the remaining items to the left
                for (int j = i; j < qtyItems - 1; j++) {
                    itemInStore[j] = itemInStore[j + 1];
                }
                itemInStore[qtyItems - 1] = null;  // Optional: Set the last item to null
                qtyItems--;
                System.out.println("Removed item successfully: " + dvd.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in store.");
    }

    // Method to print the store's current inventory
    public void printStore() {
        if (qtyItems == 0) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Store Inventory:");
            for (int i = 0; i < qtyItems; i++) {
                System.out.println(itemInStore[i].toString());
            }
        }
    }
}
