package ccard.model;

import framework.Interfaces.ICustomer;

public class GoldCard extends CCAccount {

	private String cardType="";
	public GoldCard(String acctountNumber, ICustomer accountHolder,	double balance, String acctountType,String cardType) {
		super(acctountNumber, accountHolder, balance, acctountType);
		this.cardType = cardType;
	}
	public String getCardType() {
		return cardType;
	}

}
