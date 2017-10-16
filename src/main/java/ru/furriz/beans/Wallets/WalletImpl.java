package ru.furriz.beans.Wallets;

import ru.furriz.beans.Payments.Payment;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class WalletImpl implements Wallet {

    String name;
    BigDecimal balance;
    Map<Long,Payment> payments;

    public WalletImpl(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
        payments = new HashMap<Long, Payment>();
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        Payment paymentObj;
        for (Map.Entry<Long,Payment> payment: payments.entrySet()
             ) {
            paymentObj = payment.getValue();
            if (paymentObj.isMade()){
                System.out.println(paymentObj.getPaymentAmount());
                balance = balance.add(paymentObj.getPaymentAmount());
            }
        }
        return balance;
    }

    public void registerPayment(Payment payment) {
        payments.put(payment.getId(),payment);
    }

    public Map<Long, Payment> getPayments() {
        return payments;
    }

    public void removePaymentById(long id) {
        payments.remove(id);
    }

    @Override
    public String toString() {
        return "WalletImpl{" +
                "name='" + name + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
