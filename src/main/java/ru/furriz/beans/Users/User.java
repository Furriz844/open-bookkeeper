
        package ru.furriz.beans.Users;

        import ru.furriz.beans.Payments.Payment;
        import ru.furriz.beans.Wallets.Wallet;

        import java.math.BigDecimal;
        import java.util.Date;
        import java.util.Map;

/**
 * Created by VasilyevD on 16.10.2017.
 */
public interface User {
    String getName();

    Wallet createWallet(String name, BigDecimal value);

    void deleteWalletById(long walletId); //delete wallet and all payments?

    Payment createPayment(Wallet wallet, String name, Boolean profit, Boolean made, Date paymentDate, BigDecimal paymentAmount);

    void deletePaymentById(long walletId, long paymentId);

    void transactPayment(long walletId, long paymentId);

    void cancelTransactPayment(long walletId, long paymentId);

    BigDecimal getUserBalance();

    Map<Long,Wallet>  getUserWallets();

    Map<Long, Payment> getUserPayments();
    void getWalletsStatus();
}