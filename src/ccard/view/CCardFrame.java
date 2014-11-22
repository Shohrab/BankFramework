package ccard.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import ccard.controller.CCController;
import bank.controller.*;
import framework.view.*;

/**
 * A basic JFC based application.
 */
public class CCardFrame extends MainFrame //extends javax.swing.JFrame
{
    
	/****
	 * init variables in the object
	 ****/

	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	private CCController control;

	public  CCardFrame() {
		//super();
		control = CCController.createinstance();
		


		
        //thisframe=this;
		
		setTitle("Credit-card processing Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[7];
       // newaccount=false;
        
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];
		
		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setText("Generate Monthly bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240,20,192,33);
        
        //rowdata = new Object[8];
		
		SymAction lSymAction = new SymAction();
		//JButton_Checking.addActionListener(lSymAction);
		//JButton_Deposit.addActionListener(lSymAction);
		//JButton_Withdraw.addActionListener(lSymAction);
		//JButton_Addinterest.addActionListener(lSymAction);

		JButton_Deposit.addActionListener(control .getDepositeAmountforAllCustomerListener(this));
		JButton_Withdraw.addActionListener(control.getDepositeAmountforAllCustomerListener(this));
		
		JButton_NewCCAccount.addActionListener(control.getaddAccountForCCListener(this));//  getaddAccountForPeronalListener(this));
		//JButton_CompAC.addActionListener(control.getAddAccountForCompanyListener(this));

	}
	

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_NewCCAccount);
		}
	}
	
	void JButton_Checking_actionPerformed(java.awt.event.ActionEvent event)
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
			(new CCardFrame()).setVisible(true);
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
