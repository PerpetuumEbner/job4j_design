package ru.job4j.srp.reports;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportProgrammersTest {

    @Test
    public void whenReportGeneratedInHtml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportProgrammers engine = new ReportProgrammers(store);
        StringBuilder expect = new StringBuilder()
                .append("<tr><td>")
                .append("Name; Hired; Fired; Salary")
                .append("<tr><td>")
                .append(System.lineSeparator())
                .append("<tr><td>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("<tr><td>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}