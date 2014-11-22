package ccard.model;

import framework.Interfaces.IAccount;
import framework.Interfaces.ICustomer;
import framework.model.*;

public class CCAccountFactory extends AccountFactory {
	@Override
	public IAccount createAccoutnFactory(String acctountNumber,	ICustomer accountHolder, double balance, String acctountType) {
		// TODO Auto-generated method stub
		//return super.createAccoutnFactory(acctountNumber, accountHolder, balance,acctountType);
			//return new (acctountNumber, accountHolder, balance, acctountType);
		if(acctountType.equals("G"))
			return new GoldCard(acctountNumber, accountHolder, balance, acctountType,acctountType);
		else if(acctountType.equals("B"))
			return new BronzeeCard(acctountNumber, accountHolder, balance, acctountType,acctountType);
		else if(acctountType.equals("S"))
			return new SilverCard(acctountNumber, accountHolder, balance, acctountType,acctountType);
		return null;
	}
	
}
