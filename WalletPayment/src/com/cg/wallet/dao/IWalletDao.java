package com.cg.wallet.dao;


import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.exception.WalletException;

public interface IWalletDao {

public double showBalance(BigInteger phone);

public boolean createAccount(CustomerBean cb);

public double deposit(BigInteger phone,double amount) ;

public double withdraw(BigInteger phone,double amount);

public boolean fundTransfer(BigInteger toPhone,BigInteger fromPhone,double amount);

public ArrayList<WalletTransactions> printTransactions(BigInteger phone,LocalDateTime sd,LocalDateTime ed);

}
