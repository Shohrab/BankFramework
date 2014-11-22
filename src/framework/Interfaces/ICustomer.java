package framework.Interfaces;

import java.util.*;

public interface ICustomer {
	public void addAccount(IAccount account);
	public ICustomer getCustomerDetails();
	//public List<IAccount> getAccountList();
	public List getAccountList();
	public IAddress getAddress();
	String getCustomerType();

}
