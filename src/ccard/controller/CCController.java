package ccard.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import bank.model.*;
import bank.view.*;
import framework.Interfaces.IAccount;
import framework.Interfaces.IAddress;
import framework.controller.*;
import framework.model.*;
import framework.view.*;
import ccard.view.*;

public class CCController extends Controller {
	private static CCController bankinstance;

	private CCardFrame ccardFrame;;
	private String accountype;
	private Bank bank = new Bank();
	private CreateAccountFrame createAccountFrame;
	private JDialog_CCDeposit depositFrm;
    private JDialog_CCWithdraw withdrawFrame;
	private String accountNumber;
	private int selectedAccount;
	
	private CCController() {
		
	} //

	public static CCController createinstance() {
		if (bankinstance == null) {
			bankinstance = new CCController();
		}
		return bankinstance;
	}



	class addAccountForCC implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ccardFrame = new CCardFrame();
			String[] fields = createAccountFrame.getAccountInfo();
			IAddress address = new Address(fields[1], fields[2], fields[3],fields[4]);
			String accountType = accountype;
			bank.addNewAccount(fields[0], address, fields[5], fields[6], accountType, "P", fields[7], 0.0);
			
			for(IAccount account:bank.accountList){
				String[] rowdata = new String[8];
				rowdata[0] = account.getAccountHolder().getAddress().getStreet();//   fields[1];
				rowdata[1] = account.getAccountHolder().getAddress().getCity();
				rowdata[2] = account.getAccountHolder().getAddress().getState();
				rowdata[3] = account.getAccountHolder().getAddress().getZip();
				rowdata[4] = account.getAccountHolder().getCustomerType();
				rowdata[5] = account.getAcctountType();
				rowdata[6] = String.valueOf(account.getBalance());
				rowdata[7] = account.getAcctountNumber();
				
//				rowdata[0] = fields[1];
//				rowdata[1] = fields[2];
//				rowdata[2] = fields[3];
//				rowdata[3] = fields[4];
//				rowdata[4] = "P";
//				rowdata[5] = accountype;
//				rowdata[6] = "0.0";
//				rowdata[7] = fields[6];
				ccardFrame.TableDataLoad(rowdata);
			}
			//createAccountFrame.setVisible(false);
		}

	}
	class addAccountForCCListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog personalDialog = new JDialog_AddCCAccount(ccardFrame);
			personalDialog.setVisible(true);

		}

	}
	public ActionListener getaddAccountForCCFrameSubmitListener(CreateAccountFrame frame) {
		createAccountFrame = frame;
		return new addAccountForCC();
	}
	public ActionListener getaddAccountForCCListener(CCardFrame frame) {
		return new addAccountForCCListner();
	}

	class montlyBill implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ccardFrame = new CCardFrame();
			String[] fields = createAccountFrame.getAccountInfo();
			IAddress address = new Address(fields[1], fields[2], fields[3],fields[4]);
			String accountType = accountype;
			bank.addNewAccount(fields[0], address, fields[5], fields[6], accountType, "P", fields[7], 0.0);
			
			for(IAccount account:bank.accountList){
				String[] rowdata = new String[8];
				rowdata[0] = account.getAccountHolder().getAddress().getStreet();//   fields[1];
				rowdata[1] = account.getAccountHolder().getAddress().getCity();
				rowdata[2] = account.getAccountHolder().getAddress().getState();
				rowdata[3] = account.getAccountHolder().getAddress().getZip();
				rowdata[4] = account.getAccountHolder().getCustomerType();
				rowdata[5] = account.getAcctountType();
				rowdata[6] = String.valueOf(account.getBalance());
				rowdata[7] = account.getAcctountNumber();
				
//				rowdata[0] = fields[1];
//				rowdata[1] = fields[2];
//				rowdata[2] = fields[3];
//				rowdata[3] = fields[4];
//				rowdata[4] = "P";
//				rowdata[5] = accountype;
//				rowdata[6] = "0.0";
//				rowdata[7] = fields[6];
				ccardFrame.TableDataLoad(rowdata);
			}
			//createAccountFrame.setVisible(false);
		}

	}
	class montlyBillListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog personalDialog = new JDialog_AddCCAccount(ccardFrame);
			personalDialog.setVisible(true);

		}

	}
	public ActionListener getMontlyBillSubmitListener(CreateAccountFrame frame) {
		createAccountFrame = frame;
		return new montlyBill();
	}
	public ActionListener getMontlyBillListener(CCardFrame frame) {
		return new montlyBillListner();
	}

	
	class DepositeAmountforAllCustomer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Deposit Listner");
		}
	}
	class DepositeAmountforAllCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		//	 TODO Auto-generated method stub
			
			selectedAccount = ccardFrame.JTable1.getSelectionModel().getMinSelectionIndex();
			if (selectedAccount >= 0) {
				accountNumber = (String) ccardFrame.model.getValueAt(selectedAccount, 7);
				TranActionFrame deposit = new JDialog_CCDeposit(ccardFrame,"Deposit", accountNumber);
				deposit.setVisible(true);
			}
		}

	}
	public ActionListener getDepositeAmountforAllCustomerSubmitListener(JDialog_CCDeposit frame) {
		depositFrm = frame;
		return new DepositeAmountforAllCustomer();
	}
	public ActionListener getDepositeAmountforAllCustomerListener(CCardFrame frame) {
		return new DepositeAmountforAllCustomerListener();

	}
	
	class WithDrawalAmountforAllCustomer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Withdrwal ");
		}
	}
	class WithDrawalAmountforAllCustomerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
				selectedAccount = ccardFrame.JTable1.getSelectionModel().getMinSelectionIndex();
				if (selectedAccount >= 0) {
					accountNumber = (String) ccardFrame.model.getValueAt(selectedAccount, 7);
					TranActionFrame withDrowal = new JDialog_CCWithdraw(ccardFrame,"Withdraw", accountNumber);
					withDrowal.setVisible(true);
				}
			}
	}
	public ActionListener getWithDrawalAmountforAllCustomerSubmitListener(JDialog_CCWithdraw frame) {
		withdrawFrame = frame;
		return new WithDrawalAmountforAllCustomer();

	}
	public ActionListener getWithDrawalAmountforAllCustomerListener(JDialog_CCWithdraw Form) {
		// TODO Auto-generated method stub
		withdrawFrame = Form;
		return new WithDrawalAmountforAllCustomerListener();
	}
	
	class radioButtonSVBoxListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			accountype = "S";
		}
	}
	public java.awt.event.MouseListener getradioButtonSVBoxListener() {
		return new radioButtonSVBoxListener();

	}

	class radioButtonChkBoxListener extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			accountype = "Ch";
		}
	}
	public java.awt.event.MouseAdapter getradioButtonChkBoxListener() {
		return new radioButtonChkBoxListener();

	}	
}
