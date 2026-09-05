package ch.maxim.rbac_system.policy;

import ch.maxim.rbac_system.model.Permission;
import ch.maxim.rbac_system.model.Role;
import ch.maxim.rbac_system.model.User;

public class DefaultAccessPolicy implements AccessPolicy {

    @Override
    public boolean isAllowed(User user, Permission permission) {
        for (Role role : user.getRoles()) {
            if (role.hasPermission(permission)) {
                return true;
            }
        }

        return false;
    }
}
