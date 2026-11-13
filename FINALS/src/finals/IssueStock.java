  
package finals;

import java.util.ArrayList;


public class IssueStock extends Transaction {
    public IssueStock(String productId, int amount) {
        super(productId, amount);
    }

    @Override
    public void process(ArrayList<Product> products) {
        for (Product p : products) {
            if (p.getId().equals(productId)) {
                if (p.getQuantity() >= amount) {
                    p.setQuantity(p.getQuantity() - amount);
                    System.out.println("Issued " + amount + " of " + p.getName());
                } else {
                    System.out.println("Not enough stock.");
                }
                return;
            }
        }
        System.out.println("Product not found.");
    }
}
