package ccard.model;

import framework.Interfaces.ICustomer;
import framework.model.Account;

public class CCAccount extends Account {

	final static String acctountType="Ch";
	private double interestRate = 0.1;
	public CCAccount(String acctountNumber, ICustomer accountHolder,double balance, String acctountType) {
		super(acctountNumber, accountHolder, balance, acctountType);
	}
	public String getacctountType(){
		return acctountType;
	}
	public double getinterestRate(){
		return interestRate;
	}

}
