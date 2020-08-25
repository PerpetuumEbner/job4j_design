package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rls = false;
        int index = indexOf(id);
        if (index != 1) {
            mem.set(index, model);
            rls = true;
        }
        return rls;
    }

    @Override
    public boolean delete(String id) {
        boolean rls = false;
        int index = indexOf(id);
        if (index != -1) {
            mem.remove(index);
            rls = true;
        }
        return rls;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return index != -1 ? mem.get(index) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        int index = 0;
        while (index < mem.size()) {
            if (mem.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }
}