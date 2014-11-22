package framework.model;

import framework.Interfaces.ITransection;

public class Transection implements ITransection {

	@Override
	public void depoist() {
		System.out.println("Deposit");
		
	}

	@Override
	public void withdrwal() {
		System.out.println("Withdrawl");		
	}

}
