package framework.Interfaces;

public interface IAccount {
	double getBalance();
	void deposit();
	void withdraw();
	double getInterestRate();
	ICustomer getAccountHolder();
	void generateReport();
	String getAcctountType();
	String getAcctountNumber();
}
