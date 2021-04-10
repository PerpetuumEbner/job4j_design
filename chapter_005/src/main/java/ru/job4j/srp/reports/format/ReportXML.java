package ru.job4j.srp.reports.format;

import ru.job4j.srp.reports.Employee;
import ru.job4j.srp.reports.Report;
import ru.job4j.srp.reports.Store;

import java.util.function.Predicate;

public class ReportXML implements Report {
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<Employee>").
                append("<data>")
                .append("<query attr1=“value 1”>Name</query>")
                .append("<query attr2=“value 2”>Hired</query>")
                .append("<query attr3=“value 3”>Fired</query>")
                .append("<query attr4=“value 4”>Salary</query>")
                .append("</data>");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append("<name>").append(employee.getName()).append(";").append("/<name>")
                    .append("<hired>").append(employee.getHired()).append(";").append("</hired>")
                    .append("<fired>").append(employee.getFired()).append(";").append("</fired>")
                    .append("<salary>").append(employee.getSalary()).append(";").append("</salary>")
                    .append("</Employee>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}