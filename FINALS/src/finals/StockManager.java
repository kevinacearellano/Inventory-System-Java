
package finals;

import java.util.ArrayList;


public class StockManager {
     private ArrayList<Product> products;
    private ArrayList<Supplier> suppliers;

    public StockManager(ArrayList<Product> products, ArrayList<Supplier> suppliers) {
        this.products = products;
        this.suppliers = suppliers;
    }

    public void receiveStock(String productId, int amount, String supplierId) {
        String supplierName = getSupplierName(supplierId);
        if (supplierName == null) {
            System.out.println("Supplier not found.");
            return;
        }

        Transaction t = new ReceiveStock(productId, amount, supplierName);
        t.process(products);
    }

    private String getSupplierName(String supplierId) {
        for (Supplier s : suppliers) {
            if (s.getId().equals(supplierId)) {
                return s.getName();
            }
        }
        return null;
    }

    public void issueStock(String productId, int amount) {
        Transaction t = new IssueStock(productId, amount);
        t.process(products);
    }

    public void viewStockLevels() {
        for (Product p : products) {
            System.out.println(p.getName() + ": " + p.getQuantity());
        }
    }
}

