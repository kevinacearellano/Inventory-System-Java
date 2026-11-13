package finals;

import java.util.Scanner;

public class FINALS {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        InventoryManager inv = new InventoryManager();
        SupplierManager sup = new SupplierManager();
        StockManager stk = new StockManager(inv.getProducts(), sup.getSuppliers());

        while (true) {
            System.out.println("==== Inventory System ====");
            System.out.println("1. Products 2. Suppliers 3. Stock 4. Reports 5. Exit");
            System.out.print("Choice: ");

            switch (inp.nextInt()) {
                case 1 ->
                    productMenu(inp, inv);
                case 2 ->
                    supplierMenu(inp, sup);
                case 3 ->
                    stockMenu(inp, stk);
                case 4 ->
                    inv.viewProducts();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default ->
                    System.out.println("Invalid.");
            }
        }
    }

    public static void productMenu(Scanner inp, InventoryManager m) {
        while (true) {
            System.out.println("-- Product Menu --");
            System.out.println("1.Add 2.View 3.Search 4.Update 5.Delete 6.Back");
            System.out.print("Choice: ");

            switch (inp.nextInt()) {
                case 1 -> {
                    inp.nextLine();
                    System.out.print("ID: ");
                    String id = inp.nextLine();
                    System.out.print("Name: ");
                    String name = inp.nextLine();
                    System.out.print("Qty: ");
                    int qty = inp.nextInt();
                    m.addProduct(new Product(id, name, qty));
                }
                case 2 ->
                    m.viewProducts();
                case 3 -> {
                    inp.nextLine();
                    System.out.print("ID: ");
                    Product p = m.findById(inp.nextLine());
                    System.out.println(p != null ? p.getName() + ", Qty: " + p.getQuantity() : "Not found.");
                }
                case 4 -> {
                    inp.nextLine();
                    System.out.print("ID: ");
                    Product p = m.findById(inp.nextLine());
                    if (p != null) {
                        System.out.print("New Name: ");
                        p.setName(inp.nextLine());
                        System.out.print("New Qty: ");
                        p.setQuantity(inp.nextInt());
                    } else {
                        System.out.println("Not found.");
                    }
                }
                case 5 -> {
                    inp.nextLine();
                    System.out.print("ID: ");
                    m.deleteProduct(inp.nextLine());
                }
                case 6 -> {
                    return;
                }
            }
        }
    }

    public static void supplierMenu(Scanner sc, SupplierManager m) {
        sc.nextLine();
        System.out.println("Supplier Information");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Contact: ");
        String contact = sc.nextLine();
        m.addSupplier(new Supplier(id, name, contact));
        m.viewSuppliers();
    }

    public static void stockMenu(Scanner sc, StockManager m) {
        while (true) {
            System.out.println("-- Stock Menu --");
            System.out.println("1.Receive 2.Issue 3.View 4.Back");
            System.out.print("Choice: ");

            switch (sc.nextInt()) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Enter Clothing ID: ");
                    String rId = sc.nextLine();
                    System.out.print("Enter Quantity to receive: ");
                    int rQty = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Supplier ID: ");
                    String supplierId = sc.nextLine();
                    m.receiveStock(rId, rQty, supplierId);
                    
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Qty: ");
                    int qty = sc.nextInt();
                    m.issueStock(id, qty);
                }
                case 3 ->
                    m.viewStockLevels();
                case 4 -> {
                    return;
                }
            }
        }
    }
}
