package ru.job4j.srp.reports;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportHRTest {

    @Test
    public void whenSalaryListedDescendingOrder() {
        MemStore store = new MemStore();
        Employee worker1 = new Employee("Roman", 200);
        Employee worker2 = new Employee("Ivan", 150);
        Employee worker3 = new Employee("Stepan", 100);
        Employee worker4 = new Employee("Pavel", 90);

        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        store.add(worker4);

        ReportHR engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";").append(worker1.getSalary()).append(";")
                .append(worker2.getName()).append(";").append(worker2.getSalary()).append(";")
                .append(worker3.getName()).append(";").append(worker3.getSalary()).append(";")
                .append(worker4.getName()).append(";").append(worker4.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}