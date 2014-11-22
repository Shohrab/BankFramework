package bank.model;

import framework.Interfaces.*;
import framework.model.*;

public class Bank extends FinancialOrg {
	
	ICustomer customer;
	IAccount account;
	
	public Bank() {
		super();
	}
	
	public void addNewAccount(String customerName, IAddress customerAddress, String parametar,String accounttNo, String accountType, String customertype, String customerEmailAddress,double balance) {
	    
		IAccountFactory Bfactory = new BankAccountFactory();
	    ICustomerFactory factory=new CustomerFactory();
		customer = factory.createCustomerFactory(customerName, customerAddress, customerEmailAddress, customertype, parametar);
		super.customerList.add(customer);		
		account = Bfactory.createAccoutnFactory(accounttNo, customer, balance, accountType);
		super.accountList.add(account);
		
//		String[] rowdata = new String[8];
//		rowdata[0] = customerAddress.getStreet();
//		rowdata[1] = customerAddress.;
//		rowdata[2] = fields[3];
//		rowdata[3] = fields[4];
//		rowdata[4] = customer.getCustomerType();
//		rowdata[5] = accountType;
//		rowdata[6] = balance;
//		rowdata[7] = accounttNo;
//		
//		bankFrm.TableDataLoad(rowdata);

	}
	
	public double deposit(String accountno, double amount, IRuleFunctor depositpredicate) {
		System.out.println("Deposit");
		return 0;

	}
	public boolean withdraw(String accountno, double amount, IRuleFunctor withdrawpredicate) {
		System.out.println("Deposit");
		return true;	
	}
	private IAccount getAccountInfo(String acctno) {
		if (!super.accountList.isEmpty()) {
		for (IAccount account : super.accountList) {
			if (account.getAcctountNumber().equals(acctno))
				return account;		
			}
		}
		return null;
	}
}
