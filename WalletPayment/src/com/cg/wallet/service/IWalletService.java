package com.cg.wallet.service;


import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.exception.WalletException;

public interface IWalletService {

	public boolean createAccount(CustomerBean custBean) throws WalletException;
	
	public double deposit(BigInteger phone,double amount);
	
	public double withdraw(BigInteger phone,double amount);
	
	public boolean fundTransfer(BigInteger toPhone,BigInteger fromPhone,double amount);
	
	public ArrayList<WalletTransactions> printTransactions(BigInteger phone,LocalDateTime sd, LocalDateTime ed);
	
	public boolean validate(CustomerBean custBean) throws WalletException;
	
	public double showBalance(BigInteger phone);
}