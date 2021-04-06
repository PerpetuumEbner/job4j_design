package ru.job4j.srp.reports;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Employee> findBy(Predicate<Employee> filter);
}