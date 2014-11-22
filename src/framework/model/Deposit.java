package framework.model;

import framework.Interfaces.*;
public class Deposit implements IAction {

	ITransection transection;
	public Deposit(ITransection transection) {
		this.transection=transection;
	}
	
	@Override
	public void Excute() {
		transection.depoist();
	}

}
