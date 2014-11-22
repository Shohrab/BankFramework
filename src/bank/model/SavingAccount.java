package bank.model;

import framework.Interfaces.ICustomer;
import framework.model.Account;

public class SavingAccount extends Account {

	final static String acctountType="S"; 
	private double interestRate = 0.1;
	public SavingAccount(String acctountNumber, ICustomer accountHolder,double balance, String acctountType) {
		super(acctountNumber, accountHolder, balance, acctountType);
		// TODO Auto-generated constructor stub
	}
	public String getacctountType(){
		return acctountType;
	}
	public double getinterestRate(){
		return interestRate;
	}

}
