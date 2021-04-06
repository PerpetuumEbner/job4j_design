package ru.job4j.srp.reports;

import java.util.function.Predicate;

public class ReportProgrammers implements Report {
    private Store store;

    public ReportProgrammers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<tr><td>")
                .append("Name; Hired; Fired; Salary")
                .append("<tr><td>");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append("<tr><td>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("<tr><td>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}