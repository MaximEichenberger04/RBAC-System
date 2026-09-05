package ch.maxim.rbac_system.service;

import ch.maxim.rbac_system.exception.UserNotFoundException;
import ch.maxim.rbac_system.model.Role;
import ch.maxim.rbac_system.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserService {

    private final Map<String, User> usersByUsername = new HashMap<>();

    public User createUser(String username, String email) {
        // validation
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email is not valid.");
        }

        User user = new User();
        user.setId(generateUserId());
        user.setUsername(username);
        user.setEmail(email);

        usersByUsername.put(username, user);

        return user;
    }

    public void assignRole(String username, Role role) {
        User user = findByUsername(username);
        user.addRole(role);
    }

    public User findByUsername(String username) {
        User user = usersByUsername.get(username);

        if (user == null) {
            throw new UserNotFoundException("User not found: " + username);
        }

        return user;
    }

    public static String generateUserId() {
        return UUID.randomUUID().toString();
    }

    public List<User> listUsers() {
        return new ArrayList<>(usersByUsername.values());
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}
