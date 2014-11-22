package framework.model;

import framework.Interfaces.*;

public class Person extends Customer implements IPerson
{

	private String dateOfBirth;
	public Person(String customerName, IAddress customerAddress,String customerEmailAddress,String dateOfBirth) {
		super(customerName, customerAddress, customerEmailAddress,"P");
		this.dateOfBirth = dateOfBirth;		
	}

	@Override
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
}
