package framework.Interfaces;

public interface IAccountFactory {
	IAccount createAccoutnFactory(String acctountNumber,ICustomer accountHolder,double balance,String acctountType);
}
