package finals;

public class Supplier extends Item {

    private String contact;

    public Supplier(String id, String name, String contact) {
        super(id, name);
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
