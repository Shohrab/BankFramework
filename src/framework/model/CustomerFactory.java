package framework.model;

import framework.Interfaces.IAddress;
import framework.Interfaces.ICustomer;
import framework.Interfaces.ICustomerFactory;

public class CustomerFactory implements ICustomerFactory
{
	@Override
	public ICustomer createCustomerFactory (String customerName,IAddress customerAddress,String customerEmailAddress
				,String customertype,String parametar){
		if (customertype.equals("P")) {
			return new Person(customerName, customerAddress, customerEmailAddress, parametar);
		}
		return new Company(customerName, customerAddress, customerEmailAddress,parametar);
	}
}
