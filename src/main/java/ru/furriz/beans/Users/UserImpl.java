
        package ru.furriz.beans.Users;

        import ru.furriz.beans.Payments.Payment;
        import ru.furriz.beans.Payments.PaymentImpl;
        import ru.furriz.beans.Wallets.Wallet;
        import ru.furriz.beans.Wallets.WalletImpl;

        import java.math.BigDecimal;
        import java.util.Date;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Random;

/**
 * Created by VasilyevD on 16.10.2017.
 */
public class UserImpl  implements User{
    String name;
    long id;
    Map<Long,Wallet> wallets;
    BigDecimal userBalance;

    //TODO rewrite getting id
    long walletsId=0;
    long paymentsId=0;

    public String getName() {
        return name;
    }

    public UserImpl(String name, long id) {
        this.name = name;
        this.id = id;
        userBalance = BigDecimal.valueOf(0);
        wallets = new HashMap<Long, Wallet>();
        //this.userBalance = userBalance;
    }

    public Wallet createWallet(String name, BigDecimal value) {
        Wallet wallet = new WalletImpl(walletsId++,id,name,value);
        wallets.put(wallet.getId(),wallet);
        return wallet;
    }

    public void deleteWalletById(long walletId) {
    }

    public Payment createPayment(Wallet wallet, String name, Boolean profit, Boolean made, Date paymentDate, BigDecimal paymentAmount) {
        Payment payment = new PaymentImpl(paymentsId++, this.id, wallet.getId(), name, profit,made,paymentDate,paymentAmount);
        wallet.registerPayment(payment);
        return  payment;
    }


    public void deletePaymentById(long walletID, long paymentId) {
        Wallet wallet = wallets.get(walletID);
        Payment payment = wallet.getPaymentById(paymentId);
        if(payment != null){
            wallet.removePayment(payment);
        }
    }

    public void transactPayment(long walletID, long paymentId) {
        Wallet wallet = wallets.get(walletID);
        Payment payment = wallet.getPaymentById(paymentId);
        if(payment!=null){
            payment.transactPayment();
        }

    }

    public void cancelTransactPayment(long walletID, long paymentId) {
        Wallet wallet = wallets.get(walletID);
        Payment payment = wallet.getPaymentById(paymentId);
        if(payment!=null){
            payment.cancelPayment();
        }
    }

    public BigDecimal getUserBalance() {
        BigDecimal userBalance = BigDecimal.valueOf(0);
        Wallet walletObj;
        for (Map.Entry<Long,Wallet> wallet: wallets.entrySet()
                ) {
            walletObj = wallet.getValue();
            userBalance = userBalance.add(walletObj.getBalance());
        }
        return userBalance;
    }

    public Map<Long, Wallet> getUserWallets() {
        return wallets;
    }

    public Map<Long, Payment> getUserPayments() {
        return null;
    }
    public void getWalletsStatus(){
        Wallet walletObj;
        for (Map.Entry<Long,Wallet> wallet: wallets.entrySet()
                ) {
            walletObj = wallet.getValue();
            System.out.println(walletObj.balanceToString());
        }
    }
    //TODO rewrite or delete
    @Override
    public String toString() {
        String output=  name+":\n";
        Wallet walletObj;
        Payment paymentObj;
        for (Map.Entry<Long,Wallet> wallet: wallets.entrySet()
                ) {
            walletObj = wallet.getValue();
            output = output + "    " + walletObj.balanceToString() + "\n";
            for (Map.Entry<Long, Payment> payment : walletObj.getPayments().entrySet()) {
                paymentObj = payment.getValue();
                output = output + "        " + paymentObj.paymentToString() + "\n";
            }
        }
        output=output+"Итого: "+getUserBalance();
        return output;
    }
}