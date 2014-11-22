package bank.view;
import java.awt.*;

import javax.swing.*;

import bank.controller.BankController;
import framework.view.MainFrame;
import framework.view.TranActionFrame;



public class JDialog_Withdraw extends TranActionFrame
{
   
	private BankController control;
    private MainFrame parentframe;
    private String accountnumber;
    

	public JDialog_Withdraw(MainFrame parent, String title,String accountnumber)
	{
		super(parent,title,accountnumber);
		control = BankController.createinstance();
		JButton_OK.addActionListener(control.getWithDrawalAmountforAllCustomerSubmitListener(this));
	}

	public String getDepositAmount() {
		return JTextField_Deposit.getText();
	}
}