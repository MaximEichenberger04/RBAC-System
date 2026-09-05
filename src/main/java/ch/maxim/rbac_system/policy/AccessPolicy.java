package ch.maxim.rbac_system.policy;

import ch.maxim.rbac_system.model.Permission;
import ch.maxim.rbac_system.model.User;

public interface AccessPolicy {

    boolean isAllowed(User user, Permission permission);
}
