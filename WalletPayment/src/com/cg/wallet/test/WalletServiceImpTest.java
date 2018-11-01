package com.cg.wallet.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImp;

public class WalletServiceImpTest {

	private static IWalletService service = null;
	private static CustomerBean custBean = null;

	@BeforeClass
	public static void creatInstance() {

		service = new WalletServiceImp();
		custBean = new CustomerBean();

	}

	@Test(expected = WalletException.class)
	public void testforFirstNameNotnull() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName(" ");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforFirstNameNotNumber() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("997868");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforFirstNameMinimumLength() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abh");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test
	public void testFirstNameTrueCase() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhil");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertTrue(valid);
	}

	@Test(expected = WalletException.class)
	public void testforLastNameNotnull() throws WalletException {
		custBean.setBalance(100);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforLastNameNotNumber() throws WalletException {
		custBean.setBalance(100);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("9");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforLastNameMinimumLength() throws WalletException {
		custBean.setBalance(100);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("l");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertTrue(valid);
	}

	@Test
	public void testforLastNameTrueCase() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertTrue(valid);
	}

	@Test(expected = WalletException.class)
	public void testforNillBalance() throws WalletException {
		custBean.setBalance(0);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforMinimumBalance() throws WalletException {
		custBean.setBalance(99);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test
	public void testforBalanceTrueCase() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertTrue(valid);
	}

	@Test(expected = WalletException.class)
	public void testforPhoneNumberLength() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforPhoneNumberOverRanged() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test
	public void testforPhoneNumberTrueCase() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertTrue(valid);
	}

	@Test(expected = WalletException.class)
	public void testforEmailIdNotNull() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforEmailIdInitNum() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("177%%%asdf@gmail.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforEmailIdNoatSymbol() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("$*(()@bhigamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test
	public void testforEmailIdTrueCase() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertTrue(valid);
	}

	@Test(expected = WalletException.class)
	public void testforEmailIdWrongFormat() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhigamil.com");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}

	@Test(expected = WalletException.class)
	public void testforEmailIdNoDot() throws WalletException {
		custBean.setBalance(1000);
		custBean.setEmailId("abhi@gamilcom");
		custBean.setFirstName("abhi");
		custBean.setLastName("lash");
		custBean.setPhoneNum(new BigInteger("9999999999"));
		boolean valid = service.createAccount(custBean);
		assertFalse(valid);
	}
	
	//withdraw
	@Test
	public void testWithdraw() {
	
		double bal = service.withdraw(new BigInteger("9979896543"),900);
		assertEquals(1100,bal,0);
	}
	
	@Test
	public void testWithdrawNotPossible() {
	
	double bal = service.withdraw(new BigInteger("9979896543"),1100);
		assertEquals(0,bal,0);
	}
	//deposit
	@Test
	public void testDeposit() {
	
		double bal = service.deposit(new BigInteger("9979896544"),1000);
		assertEquals(6000,bal,0);
	}
	
	//showbalance
	@Test
	public void testShowBalance() {
	
		double bal = service.showBalance(new BigInteger("9979896543"));
		assertEquals(2000.0,bal,0);
	}
	@Test
	public void testShowBalanceForNotTrue() {
	
		double bal = service.showBalance(new BigInteger("9979896543"));
		assertNotEquals(9000,bal,0);
	}
	//fund transfer
	@Test
	public void testFundTransfer() {
	
		boolean isValid = service.fundTransfer(new BigInteger("9979896544"),new BigInteger("9979896543"),500);
		assertTrue(isValid);
	}
	
	@Test
	public void testFundTransferForNotTrue()  {
		
		boolean isValid = service.fundTransfer(new BigInteger("9979896544"),new BigInteger("9976586544"),900);
		assertFalse(isValid);
	}
	//printTransactions
	@Test
	public void testPrintTransactions()throws WalletException{
		
	}
}