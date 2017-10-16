package ru.furriz.beans.Wallets;

import ru.furriz.beans.Payments.Payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface Wallet {

    void removePaymentById(long paymentId);
    void removePayment(Payment payment);

    Payment getPaymentById(long paymentId);

    long getId();
    long getOwnerId(); //return user owner id
    String balanceToString();
    void registerPayment(Payment payment);
    BigDecimal getBalance();
    Map<Long,Payment> getPayments();
}
