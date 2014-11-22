package framework.model;

import java.util.*;

import framework.Interfaces.*;
import framework.controller.*;
public class FinancialOrg implements IFinancialOrg,IBankSubject {

	public List<ICustomer> customerList;
	public List<IAccount> accountList;
	IController control = Controller.createInstance();
	IAccountFactory factory = new AccountFactory();
	//IAccountFactory factory = new AccountFactory();
	private String emailNotification = "";

	public FinancialOrg() {
		customerList= new ArrayList<ICustomer>();
		accountList= new ArrayList<IAccount>();
	}
	
	@Override
	public void registerAccount(IAccount account) {
		addNewAccount(account);
	}

	@Override
	public void unregisterAccount(IAccount account) {
		accountList.remove(account);		
	}

	@Override
	public void addNewAccount(IAccount account) {
		accountList.add(account);
	}
	
	@Override
	public void addInterest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCharge() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}

}
