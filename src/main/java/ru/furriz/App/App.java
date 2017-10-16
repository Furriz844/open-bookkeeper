package ru.furriz.App;

import ru.furriz.beans.Payments.Payment;
import ru.furriz.beans.Payments.PaymentImpl;
import ru.furriz.beans.Users.User;
import ru.furriz.beans.Users.UserImpl;
import ru.furriz.beans.Wallets.Wallet;
import ru.furriz.beans.Wallets.WalletImpl;

import java.math.BigDecimal;
import java.util.Date;
//this is test app class, its will be remove
public class App {
    public static void main(String[] args) {
        Date date = new Date();
//        Wallet wallet = new WalletImpl("Кошелек",BigDecimal.valueOf(0));
//        Payment zarplata = new PaymentImpl(0,"Зарплата",true,true, date, BigDecimal.valueOf(100));
//        Payment kvartira = new PaymentImpl(1,"Кварплата", false, true, date, BigDecimal.valueOf(45));
//        Payment eda = new PaymentImpl(2,"Еда",false,true,date,BigDecimal.valueOf(5));
//        wallet.registerPayment(zarplata);
//        wallet.registerPayment(kvartira);
//        wallet.registerPayment(eda);
//        wallet.removePaymentById(eda.getId());
//        System.out.println(wallet.toString());
        //TODO how to get wallet?? =)
        User dima = new UserImpl("Dmitriy",0);
        Wallet debitCard = dima.createWallet("Дебетовая карта",BigDecimal.valueOf(0));
        //TODO maybe cast long to BigDecimal in constructor?
        Payment zarplata = dima.createPayment(debitCard,"Зарплата",true,false,date,BigDecimal.valueOf(100));

        Wallet wallet = dima.createWallet("Кошелек",BigDecimal.valueOf(20));
        Payment eda = dima.createPayment(wallet, "Еда",false,true,date,BigDecimal.valueOf(10));
        Payment kvarplata = dima.createPayment(debitCard,"Кварплата", false, false,date,BigDecimal.valueOf(45));
        dima.transactPayment(debitCard.getId(), zarplata.getId());
        //dima.getWalletsStatus();
        System.out.println(dima.toString());
        System.out.println();
        System.out.println("Пользователь "+ dima.getName()+" провел платеж: "+kvarplata.getName()+" на сумму "+kvarplata.getPaymentAmount());
        System.out.println();
        dima.transactPayment(debitCard.getId(),kvarplata.getId());
        System.out.println(dima.toString());
        //dima.toString();
        //System.out.println(dima.getUserBalance().toString());
    }
}
