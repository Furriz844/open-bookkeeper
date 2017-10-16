package ru.furriz.beans.Payments;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentImpl implements Payment {
    long id;
    String name;
    Boolean profit;
    Boolean made;
    Date paymentDate;
    BigDecimal paymentAmount;

    public PaymentImpl(long id,String name, Boolean profit, Boolean made, Date paymentDate, BigDecimal paymentAmount) {
        this.id = id;
        this.name = name;
        this.profit = profit;
        this.made = made;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
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
}
