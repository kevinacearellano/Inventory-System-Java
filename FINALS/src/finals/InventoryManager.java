
package finals;

import java.util.ArrayList;


public class InventoryManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) { products.add(p); }
    public void viewProducts() {
        for (Product p : products) {
            System.out.println(p.getId() + " - " + p.getName() + " - " + p.getQuantity());
        }
    }
    public Product findById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }
    public void deleteProduct(String id) {
        products.removeIf(p -> p.getId().equals(id));
    }
    public ArrayList<Product> getProducts() { return products; }
}


 