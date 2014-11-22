package framework.model;

import framework.Interfaces.*;


public class TransectionManager implements ITransectionManager {
	
	private IAction action;

	@Override
	public void setCommand(IAction action) {
		this.action= action;		
	}

	@Override
	public void pressCommand() {
		action.Excute();		
	}

}
