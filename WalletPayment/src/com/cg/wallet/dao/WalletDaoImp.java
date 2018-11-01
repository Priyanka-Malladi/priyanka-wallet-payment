package com.cg.wallet.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.db.WalletDB;
import com.cg.wallet.exception.WalletException;

public class WalletDaoImp implements IWalletDao {

	List<CustomerBean> customerList = WalletDB.getList();

	List<WalletTransactions> transacList = new ArrayList<WalletTransactions>();

	@Override
	public boolean createAccount(CustomerBean cb) {
		// TODO Auto-generated method stub

		return customerList.add(cb);

	}

	@Override
	public double deposit(BigInteger phone, double amount) {
		// TODO Auto-generated method stub
		double bal = 0.0;
		for (CustomerBean custBean : customerList) {
			if (custBean.getPhoneNum().equals(phone)) {
				double balance = custBean.getBalance();
				balance = balance + amount;
				custBean.setBalance(balance);
				bal = showBalance(custBean.getPhoneNum());
				WalletTransactions transac = new WalletTransactions();
				transac.setAmount(amount);
				transac.setBalance(custBean.getBalance());
				transac.setDate(custBean.getDate());
				transac.setPhoneNum(custBean.getPhoneNum());
				transac.setType("withdraw");
				transacList.add(transac);
			}
		}
		return bal;
	}

	@Override
	public double withdraw(BigInteger phone, double amount)  {
		// TODO Auto-generated method stub
		double bal = 0.0;
		for (CustomerBean custBean : customerList) {
			if (custBean.getPhoneNum().equals(phone)) {
				if (custBean.getBalance() >= amount) {
					double balance = custBean.getBalance();
					balance = balance - amount;
					custBean.setBalance(balance);
					bal = showBalance(custBean.getPhoneNum());
					WalletTransactions transac = new WalletTransactions();
					transac.setAmount(amount);
					transac.setBalance(custBean.getBalance());
					transac.setDate(custBean.getDate());
					transac.setPhoneNum(custBean.getPhoneNum());
					transac.setType("withdraw");
					transacList.add(transac);
				}
			}
		}

		return bal;
	}

	@Override
	public double showBalance(BigInteger phone) {
		// TODO Auto-generated method stub
		double bal = 0.0;
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getPhoneNum().equals(phone)) {
				bal = customerBean.getBalance();
			}
		}

		return bal;

	}

	@Override
	public boolean fundTransfer(BigInteger toPhone, BigInteger fromPhone, double amount)  {
		// TODO Auto-generated method stub
		boolean valid = false;
		for (CustomerBean custBean : customerList) {
			if (custBean.getPhoneNum().equals(fromPhone)) {
				for (CustomerBean custrBean : customerList) {
					if (custBean.getPhoneNum().equals(toPhone)) {
						withdraw(fromPhone, amount);
						deposit(toPhone, amount);
						valid = true;
					}
				}
			}
		}
		return valid;
	}

	@Override
	public ArrayList<WalletTransactions> printTransactions(BigInteger phone, LocalDateTime sd, LocalDateTime ed) {
		ArrayList<WalletTransactions> li = new ArrayList<>();
		for (WalletTransactions walletTransac : transacList) {
			if (walletTransac.getPhoneNum().equals(phone)) {
				if (walletTransac.getDate().isAfter(sd) && walletTransac.getDate().isBefore(ed)) {
					li.add(walletTransac);
				}
			}
		}
		return li;
	}

}