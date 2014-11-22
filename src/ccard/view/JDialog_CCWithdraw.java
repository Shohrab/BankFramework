package ccard.view;
import java.awt.*;

import javax.swing.*;

import ccard.controller.CCController;
import bank.controller.BankController;
import framework.view.MainFrame;
import framework.view.TranActionFrame;



public class JDialog_CCWithdraw extends TranActionFrame
{
   
	private CCController control;
    private MainFrame parentframe;
    private String accountnumber;
    

	public JDialog_CCWithdraw(MainFrame parent, String title,String accountnumber)
	{
		super(parent,title,accountnumber);
		control = CCController.createinstance();
		JButton_OK.addActionListener(control.getWithDrawalAmountforAllCustomerSubmitListener(this));
	}

	public String getDepositAmount() {
		return JTextField_Deposit.getText();
	}
}