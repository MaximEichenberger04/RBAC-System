package ch.maxim.rbac_system.service;

import ch.maxim.rbac_system.exception.AccessDeniedException;
import ch.maxim.rbac_system.model.Permission;
import ch.maxim.rbac_system.model.User;
import ch.maxim.rbac_system.policy.AccessPolicy;
import ch.maxim.rbac_system.policy.DefaultAccessPolicy;

public class AccessControlService {

    private final AccessPolicy accessPolicy;

    public AccessControlService() {
        this(new DefaultAccessPolicy());
    }

    public AccessControlService(AccessPolicy accessPolicy) {
        this.accessPolicy = accessPolicy;
    }

    public boolean can(User user, Permission permission) {
        return accessPolicy.isAllowed(user, permission);
    }

    public void requirePermission(User user, Permission permission) {
        if (!can(user, permission)) {
            throw new AccessDeniedException(
                    user.getUsername() + " lacks permission " + permission
            );
        }
    }
}
