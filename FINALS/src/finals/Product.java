package finals;

public class Product extends Item {

    private int quantity;

    public Product(String id, String name, int quantity) {
        super(id, name);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
