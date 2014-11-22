package framework.model;

import framework.Interfaces.IRuleFunctor;

public class RuleFunctor implements IRuleFunctor {
	
	int compareMaxValue=0;
	int compareMinValue=0;
	public RuleFunctor(int compareMaxValue,int compareMinValue) {
		this.compareMaxValue = compareMaxValue;
		this.compareMinValue = compareMinValue;
	}
	
	@Override
	public boolean checkRules(double value) {
		if(value > compareMaxValue || value < compareMinValue) 
			return true;
		return false;
	}

}
