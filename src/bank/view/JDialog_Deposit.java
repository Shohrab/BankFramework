package bank.view;

import bank.controller.BankController;
import framework.view.MainFrame;
import framework.view.TranActionFrame;



public class JDialog_Deposit extends TranActionFrame
{
	private BankController control;
    private MainFrame parentframe;
    private String accountnumber;
    
    
	public JDialog_Deposit(MainFrame parent, String title,String accountnumber)
	{
		super(parent,title,accountnumber);
		control =  BankController.createinstance();
		JButton_OK.addActionListener(control.getDepositeAmountforAllCustomerSubmitListener(this));
	}

	public String getDepositAmount() {
		return JTextField_Deposit.getText();
	}
}