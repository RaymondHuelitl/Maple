package model;

public class User {
    private String id;
    private String email;
    private String name;
    private String passwordHash;

    public User(String id, String email, String name, String passwordHash) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.passwordHash = passwordHash;
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPasswordHash() { return passwordHash; }

    public void setName(String name) { this.name = name; }
}
