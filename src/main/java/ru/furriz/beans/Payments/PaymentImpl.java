package ru.furriz.beans.Payments;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentImpl implements Payment {
    long id;
    long userId;
    long walletId;
    String name;
    Boolean profit;
    Boolean made;
    Date paymentDate;
    BigDecimal paymentAmount;

    public PaymentImpl(long id, long userId, long walletId, String name, Boolean profit, Boolean made, Date paymentDate, BigDecimal paymentAmount) {
        this.userId = userId;
        this.walletId = walletId;
        this.id = id;
        this.name = name;
        this.profit = profit;
        this.made = made;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public long getWalletId() {
        return walletId;
    }

    public long getUserId() {
        return userId;
    }

    public void transactPayment() {
        made=true;
    }

    public void cancelPayment() {
        made=false;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean isProfit() {
        return profit;
    }


    public Date getPaymentDate() {
        return paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        if(profit){
            return paymentAmount;
        }
        return paymentAmount.negate();
    }

    public Boolean isMade() {
        return made;
    }

    @Override
    public String toString() {
        return "PaymentImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profit=" + profit +
                ", made=" + made +
                ", paymentDate=" + paymentDate +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
    //TODO rewrite or delete
    public String paymentToString() {
        String status = " Статус: проведен";
        if(made!=true){
            status = " Статус: не проведен";
        }
        return "\""+ name+"\": "+getPaymentAmount()+status;
    }
}
