package model;

public class User {
    private String id;
    private String name;
    private String email;
    private int purchaseCount;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.purchaseCount = 0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void incrementPurchaseCount() {
        this.purchaseCount++;
    }
}
