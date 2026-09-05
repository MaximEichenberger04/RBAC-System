package ch.maxim.rbac_system.service;

import ch.maxim.rbac_system.exception.RoleNotFoundException;
import ch.maxim.rbac_system.model.Permission;
import ch.maxim.rbac_system.model.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RoleService {

    private final Map<String, Role> rolesByName = new HashMap<>();

    public Role createRole(String name, Set<Permission> permissions) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Role needs a name.");
        }

        Role role = new Role(name, permissions);
        rolesByName.put(name, role);

        return role;
    }

    public Role findByName(String name) {
        Role role = rolesByName.get(name);

        if (role == null) {
            throw new RoleNotFoundException("Role not found: " + name);
        }

        return role;
    }

    public List<Role> listRoles() {
        return new ArrayList<>(rolesByName.values());
    }

    public void createDefaultRoles() {
        createRole("VISITOR", Set.of(Permission.VIEW_SITE));
        createRole("MODERATOR", Set.of(Permission.VIEW_SITE, Permission.MODERATE_SITE));
        createRole("ADMIN", Set.of(Permission.VIEW_SITE, Permission.MODERATE_SITE, Permission.ACCESS_ADMIN_PANEL));
    }
}
