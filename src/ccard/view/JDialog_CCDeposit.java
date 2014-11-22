package ccard.view;

import ccard.controller.CCController;
import bank.controller.BankController;
import framework.view.MainFrame;
import framework.view.TranActionFrame;



public class JDialog_CCDeposit extends TranActionFrame
{
	private CCController control;
    private MainFrame parentframe;
    private String accountnumber;
    
    
	public JDialog_CCDeposit(MainFrame parent, String title,String accountnumber)
	{
		super(parent,title,accountnumber);
		control =  CCController.createinstance();
		JButton_OK.addActionListener(control.getDepositeAmountforAllCustomerSubmitListener(this));
	}

	public String getDepositAmount() {
		return JTextField_Deposit.getText();
	}
}