package ch.maxim.rbac_system.service;

import ch.maxim.rbac_system.model.Permission;
import ch.maxim.rbac_system.model.Resource;
import ch.maxim.rbac_system.model.User;

import java.util.List;

public class SiteService {

    private final AccessControlService accessControlService;
    private final List<Resource> sites = List.of(
            new Resource("public-forum"),
            new Resource("moderator-tools"),
            new Resource("admin-dashboard")
    );

    public SiteService(AccessControlService accessControlService) {
        this.accessControlService = accessControlService;
    }

    public List<Resource> viewSites(User activeUser) {
        accessControlService.requirePermission(activeUser, Permission.VIEW_SITE);
        return sites;
    }

    public String openModeratorTools(User activeUser) {
        accessControlService.requirePermission(activeUser, Permission.MODERATE_SITE);
        return activeUser.getUsername() + " opened moderator-tools";
    }

    public String loginToAdminDashboard(User activeUser) {
        accessControlService.requirePermission(activeUser, Permission.ACCESS_ADMIN_PANEL);
        return activeUser.getUsername() + " logged into admin-dashboard";
    }
}
