
package finals;

import java.util.ArrayList;


public class SupplierManager {
     private ArrayList<Supplier> suppliers = new ArrayList<>();

    public void addSupplier(Supplier s) { suppliers.add(s); }
    public void viewSuppliers() {
        for (Supplier s : suppliers) {
            System.out.println(s.getId() + " - " + s.getName() + " - " + s.getContact());
        }
    }public ArrayList<Supplier> getSuppliers() {
    return suppliers;
}
}

