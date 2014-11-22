package ccard.model;

import framework.Interfaces.ICustomer;

public class SilverCard extends CCAccount {

	private String cardType="";
	public SilverCard(String acctountNumber, ICustomer accountHolder,	double balance, String acctountType,String cardType) {
		super(acctountNumber, accountHolder, balance, acctountType);
		this.cardType = cardType;
	}
	public String getCardType() {
		return cardType;
	}

}
