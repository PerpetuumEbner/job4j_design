package ru.job4j.isp.payment;

import ru.job4j.isp.payment.Pay;

public class Pixel implements Pay {
    @Override
    public void applePay() {
        throw new UnsupportedOperationException("The payment system Apple Pay is not supported.");
    }

    @Override
    public void googlePay() {
        System.out.println("Payment completed.");
    }

    @Override
    public void samsungPay() {
        throw new UnsupportedOperationException("The payment system Samsung Pay is not supported.");
    }
}