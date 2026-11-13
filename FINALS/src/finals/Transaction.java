
package finals;

import java.util.ArrayList;



    
 public abstract class Transaction {
    protected String productId;
    protected int amount;

    public Transaction(String productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public abstract void process(ArrayList<Product> products);
}
