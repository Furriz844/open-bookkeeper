package ru.furriz.beans.Wallets;

import ru.furriz.beans.Payments.Payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface Wallet {

    String getName();

    BigDecimal getBalance();

    void registerPayment(Payment payment);

    Map<Long,Payment> getPayments();

    void removePaymentById(long id);
}
