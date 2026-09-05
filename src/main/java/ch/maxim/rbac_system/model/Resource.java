package ch.maxim.rbac_system.model;

public class Resource {

    private final String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
