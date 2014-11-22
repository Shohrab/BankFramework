package framework.model;

import framework.Interfaces.*;
public class Withdraw implements IAction {

	ITransection transection;
	
	public Withdraw(ITransection transection) {
		this.transection=transection;
	}	
	
	@Override
	public void Excute() {
		transection.withdrwal();
	}

}
