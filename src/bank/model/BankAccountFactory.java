package bank.model;

import framework.Interfaces.IAccount;
import framework.Interfaces.ICustomer;
import framework.model.*;

public class BankAccountFactory extends AccountFactory {
	@Override
	public IAccount createAccoutnFactory(String acctountNumber,	ICustomer accountHolder, double balance, String acctountType) {
		// TODO Auto-generated method stub
		//return super.createAccoutnFactory(acctountNumber, accountHolder, balance,acctountType);
		if(acctountType.endsWith("S")){
			return new SavingAccount(acctountNumber, accountHolder, balance, acctountType);
		}
		return new CheckingAccount(acctountNumber, accountHolder, balance, acctountType);
	}
	
}
