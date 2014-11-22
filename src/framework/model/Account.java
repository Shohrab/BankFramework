package framework.model;

import java.util.List;

import framework.Interfaces.*;

public class Account implements IAccount  {

	private String acctountNumber;
	private double balance;
	private List<ITransection> entryList;
	private ICustomer accountHolder;
	private String acctountType;
	private double interestRate;

	public Account(String acctountNumber,ICustomer accountHolder,double balance,String acctountType) {
		this.acctountNumber = acctountNumber;
		this.balance = balance;
		this.accountHolder = accountHolder;
		this.acctountType = acctountType;
		//this.interestRate = interestRate;
		//accountHolder.addAccount(this);
	}
	public String getAcctountNumber() {
		return acctountNumber;
	}
	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void deposit() {
				
		
	}
	public String getAcctountType() {
		return acctountType;
	}
	@Override
	public void withdraw() {
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public ICustomer getAccountHolder() {
		return accountHolder;
	}

	@Override
	public void generateReport() {
	}
	
}
