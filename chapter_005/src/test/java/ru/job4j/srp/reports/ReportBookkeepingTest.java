package ru.job4j.srp.reports;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportBookkeepingTest {

    @Test
    public void whenSalaryForeignCurrency() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee(
                "Ivan", now, now, new Salary(Salary.Currency.DOLLAR, BigDecimal.valueOf(100)));
        Employee worker2 = new Employee(
                "Roman", now, now, new Salary(Salary.Currency.GBP, BigDecimal.valueOf(75)));
        Employee worker3 = new Employee(
                "Pavel", now, now, new Salary(Salary.Currency.EURO, BigDecimal.valueOf(90)));

        store.add(worker1);
        store.add(worker2);
        store.add(worker3);

        ReportBookkeeping engine = new ReportBookkeeping(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator()).append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";").append(worker1.getFired()).append(";")
                .append(worker1.getCurrency()).append(";")
                .append(System.lineSeparator())

                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";").append(worker2.getFired()).append(";")
                .append(worker2.getCurrency()).append(";")
                .append(System.lineSeparator())

                .append(worker3.getName()).append(";")
                .append(worker3.getHired()).append(";").append(worker3.getFired()).append(";")
                .append(worker3.getCurrency()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}