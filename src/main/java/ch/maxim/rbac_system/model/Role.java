package ch.maxim.rbac_system.model;
import java.util.Set;

public class Role {
    
    private String name;
    private Set<Permission> permissions;

    public Role() {
    }

    public Role(String name, Set<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
