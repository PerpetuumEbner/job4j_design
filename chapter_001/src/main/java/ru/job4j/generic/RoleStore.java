package ru.job4j.generic;

public class RoleStore implements Store<Role> {
    private final Store<Role> role = new MemStore<>();

    @Override
    public void add(Role model) {
        role.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return delete(id);
    }

    @Override
    public Role findById(String id) {
        return findById(id);
    }
}
