package framework.Interfaces;

public interface ICustomerFactory {
	ICustomer createCustomerFactory (String customerName,IAddress customerAddress,String customerEmailAddress,String customertype,String parametar);
}
