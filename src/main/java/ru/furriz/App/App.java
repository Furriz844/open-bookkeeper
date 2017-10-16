package ru.furriz.App;

import ru.furriz.beans.Payments.Payment;
import ru.furriz.beans.Payments.PaymentImpl;
import ru.furriz.beans.Wallets.Wallet;
import ru.furriz.beans.Wallets.WalletImpl;

import java.math.BigDecimal;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        Date date = new Date();
        Wallet wallet = new WalletImpl("Кошелек",BigDecimal.valueOf(0));
        Payment zarplata = new PaymentImpl(0,"Зарплата",true,true, date, BigDecimal.valueOf(100));
        Payment kvartira = new PaymentImpl(1,"Кварплата", false, true, date, BigDecimal.valueOf(45));
        Payment eda = new PaymentImpl(2,"Еда",false,true,date,BigDecimal.valueOf(5));
        wallet.registerPayment(zarplata);
        wallet.registerPayment(kvartira);
        wallet.registerPayment(eda);
        wallet.removePaymentById(eda.getId());
        System.out.println(wallet.toString());
    }
}
