package ru.job4j.srp.reports;

import java.math.BigDecimal;

public class Salary {
    private Currency currency;
    private BigDecimal value;

    public Salary(Currency currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    enum Currency {
        GBP, DOLLAR, EURO;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}