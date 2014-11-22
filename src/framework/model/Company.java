package framework.model;

import java.util.*;

import framework.Interfaces.IAddress;
import framework.Interfaces.ICompany;

public class Company extends Customer implements ICompany
{

	private String  numberOfEmployee;
	public Company(String customerName,IAddress customerAddress,String customerEmailAddress,String  numberOfEmployee){
		super(customerName,customerAddress,customerEmailAddress,"C");
		this.numberOfEmployee = numberOfEmployee;
	}
	
	@Override
	public String  getnumberOfEmployee() {
		// TODO Auto-generated method stub
		return numberOfEmployee;
	}	
}
