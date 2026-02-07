package ch.maxim.rbac_system.model;
import java.util.Set;

public class User {
    
    private Long id;
    private String username;
    private String email;
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String username, String email, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
