package ru.furriz.beans.Payments;

import java.math.BigDecimal;
import java.util.Date;

public interface Payment {
    long getId();
    long getWalletId();
    long getUserId();
    void transactPayment();
    void cancelPayment();
    String getName();

    Boolean isProfit();

    Date getPaymentDate();

    BigDecimal getPaymentAmount();

    Boolean isMade();
    String paymentToString();

}
