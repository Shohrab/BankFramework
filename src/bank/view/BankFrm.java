package bank.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import bank.controller.*;
import framework.view.*;

/**
 * A basic JFC based application.
 */
public class BankFrm extends MainFrame //extends javax.swing.JFrame
{
    
	/****
	 * init variables in the object
	 ****/

	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	private BankController control;

	public  BankFrm() {
		//super();
		control = BankController.createinstance();
		
		
		
		setTitle("Bank Application.");	
	
		setVisible(true);
		setSize(650, 650);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		
		JButton_PerAC.setText("Add personal account");
		JButton_PerAC.setActionCommand("jbutton");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);

		model.addColumn("Street");
		model.addColumn("City");
		model.addColumn("State");
		model.addColumn("Zip");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		model.addColumn("Acc no");

		rowdata = new Object[8];
		
		SymAction lSymAction = new SymAction();
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		//JButton_Withdraw.addActionListener(lSymAction);
		//JButton_Addinterest.addActionListener(lSymAction);

		JButton_Deposit.addActionListener(control.getDepositeAmountforAllCustomerListener(this));
		JButton_Withdraw.addActionListener(control.getDepositeAmountforAllCustomerListener(this));
		
		JButton_PerAC.addActionListener(control.getaddAccountForPeronalListener(this));
		JButton_CompAC.addActionListener(control.getAddAccountForCompanyListener(this));

	}
	

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButton_Deposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButton_Withdraw_actionPerformed(event);
		}
	}
	
	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.out.println("Hello");
    }

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.out.println("Hello Com");
	}
	void JButton_Withdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.out.println("Hello Deposit");
	}
	void JButton_Deposit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.out.println("Hello Withdraw");
	}
	public void TableDataLoad(String[] data) {
		rowdata[0] = data[0];
		rowdata[1] = data[1];
		rowdata[2] = data[2];
		rowdata[3] = data[3];
		rowdata[4] = data[4];
		rowdata[5] = data[5];
		rowdata[6] = data[6];
		rowdata[7] = data[7];
		model.addRow(rowdata);
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}

	static public void main(String args[]) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
				} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new BankFrm()).setVisible(true);
			} catch (Throwable t) {
				t.printStackTrace();
				// Ensure the application exits with an error condition.
				System.exit(1);
			}
	}

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

}
