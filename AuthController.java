package controller;

import model.User;

public class AuthController {
    private User currentUser;

    public boolean login(String email, String name) {
        if (email == null || email.isEmpty()) return false;
        currentUser = new User("u1", email, name, "demo");
        return true;
    }

    public void logout() { currentUser = null; }

    public User getCurrentUser() { return currentUser; }
}
