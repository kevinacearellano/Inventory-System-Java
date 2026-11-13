package finals;

import java.util.ArrayList;

public class ReceiveStock extends Transaction {
       private String supplierName;

    public ReceiveStock(String productId, int amount, String supplierName) {
        super(productId, amount);
        this.supplierName = supplierName;
    }

    @Override
    public void process(ArrayList<Product> products) {
        for (Product p : products) {
            if (p.getId().equals(productId)) {
                p.setQuantity(p.getQuantity() + amount);
                System.out.println("Received " + amount + " of " + p.getName() + " from Supplier: " + supplierName);
                return;
            }
        }
        System.out.println("Clothing item not found.");
    }
}
