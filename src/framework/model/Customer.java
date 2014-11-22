package framework.model;

import java.util.*;

import framework.Interfaces.*;

public class Customer implements ICustomer {

	private String customerName;
	private String customerType;
	private String customerEmailAddress;
	private IAddress customerAddress;
	private List<IAccount> accountList;
	
	public Customer(String customerName,IAddress customerAddress,String customerEmailAddress,String customerType){
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerType= customerType;
		this.customerEmailAddress = customerEmailAddress;
	}	

	@Override
	public Customer getCustomerDetails() {
		return this;
	}

	@Override
	public List<IAccount> getAccountList() {
		return accountList;
	}

	@Override
	public IAddress getAddress() {
		return customerAddress;
	}

	@Override
	public void addAccount(IAccount account) {
		accountList.add(account);
		
	}

	@Override
	public String getCustomerType() {
		// TODO Auto-generated method stub
		return customerType;
	}



}
