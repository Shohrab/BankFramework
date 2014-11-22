package framework.Interfaces;

public interface IBankSubject {
	void registerAccount(IAccount account);
	void unregisterAccount(IAccount account);
	void addInterest();
	void addCharge();
}
