 package ru.furriz.beans.Wallets;

        import ru.furriz.beans.Payments.Payment;

        import java.math.BigDecimal;
        import java.util.HashMap;
        import java.util.Map;

public class WalletImpl implements Wallet {

    long userId;
    long id;
    String name;
    BigDecimal startBalance;
    Map<Long,Payment> payments;

    public WalletImpl(long id, long userId, String name, BigDecimal balance) {
        this.id=id;
        this.userId = userId;
        this.name = name;
        this.startBalance = balance;
        payments = new HashMap<Long, Payment>();
    }
    public long getId() {
        return id;
    }

    public long getOwnerId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        BigDecimal balance =this.startBalance;
        Payment paymentObj;
        for (Map.Entry<Long,Payment> payment: payments.entrySet()
                ) {
            paymentObj = payment.getValue();
            if (paymentObj.isMade()){
                //System.out.println(paymentObj.getPaymentAmount());
                balance = balance.add(paymentObj.getPaymentAmount());
            }
        }
        return balance;
    }

    public Payment getPaymentById(long paymentId) {
        return payments.get(paymentId);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment.getId());
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
    //TODO rewrite or delete
    public String balanceToString(){
        return "\""+ name+"\"- Баланс:"+getBalance();
    }
}