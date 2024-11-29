package aims.cart;

import aims.disc.DigitalVideoDisc;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20;
    private static int qtyOrdered = 0; // Số lượng DVD trong giỏ hàng
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; // Mảng chứa các DVD

    // Lấy số lượng DVD trong giỏ hàng
    public int getQtyOrderd() {
        return qtyOrdered;
    }

    // Thêm DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // Xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {  // Sử dụng equals() để so sánh nội dung đối tượng
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("No disc in the cart found");
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();  // Cộng tổng chi phí
        }
        return sum;
    }

    // Thêm mảng DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (int i = 0; i < dvdList.length; i++) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
            } else {
                break;
            }
        }
    }

    // Thêm hai DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
        } else {
            return;  // Giỏ hàng đã đầy
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
        } else {
            return;  // Giỏ hàng đã đầy
        }
    }

    // In ra các DVD trong giỏ hàng và tổng chi phí
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].toString());  // In ra thông tin từng DVD
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    // Tìm DVD theo tên
    public void search(String title) {
        boolean found = false;  // Biến kiểm tra xem có DVD nào trùng tên không
        for (int i = 0; i < qtyOrdered; i++) {
            if (title.equals(itemsOrdered[i].getTitle())) {  // Sử dụng equals() để so sánh chuỗi
                System.out.println(itemsOrdered[i].toString());  // In ra DVD nếu tìm thấy
                found = true;
            }
        }
        if (!found) {
            System.out.println("No disc found with the title: " + title);
        }
    }
}
