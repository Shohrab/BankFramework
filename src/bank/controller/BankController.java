package bank.controller;
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

public class BankController extends Controller {
	private static BankController bankinstance;

	private BankFrm bankFrm;;
	private String accountype;
	private Bank bank = new Bank();
	private CreateAccountFrame createAccountFrame;
	private JDialog_Deposit depositFrm;
    private JDialog_Withdraw withdrawFrame;
	private String accountNumber;
	private int selectedAccount;
	
	private BankController() {
		
	} //

	public static BankController createinstance() {
		if (bankinstance == null) {
			bankinstance = new BankController();
		}
		return bankinstance;
	}



	class addAccountForPeronal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			bankFrm = new BankFrm();
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
				bankFrm.TableDataLoad(rowdata);
			}
			//createAccountFrame.setVisible(false);
		}

	}
	class addAccountForPeronalListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog personalDialog = new JDialog_AddPersonalAccount(bankFrm);
			personalDialog.setVisible(true);

		}

	}
	public ActionListener getaddAccountForPeronalFrameSubmitListener(CreateAccountFrame frame) {
		createAccountFrame = frame;
		return new addAccountForPeronal();
	}
	public ActionListener getaddAccountForPeronalListener(BankFrm frame) {
		return new addAccountForPeronalListner();
	}
	
	class AddAccountForCompany implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			bank = new Bank();
			String[] fields = createAccountFrame.getAccountInfo();
			IAddress address = new Address(fields[1], fields[2], fields[3],fields[4]);
			String accountType = accountype;
			bank.addNewAccount(fields[0], address, fields[5], fields[6], accountType, "C", fields[7], 0.0);
//			String[] rowdata = new String[8];
//			rowdata[0] = fields[1];
//			rowdata[1] = fields[2];
//			rowdata[2] = fields[3];
//			rowdata[3] = fields[4];
//			rowdata[4] = "C";
//			rowdata[5] = accountType;
//			rowdata[6] = "0.0";
//			rowdata[7] = fields[6];
//			bankFrm = new BankFrm();
//			bankFrm.TableDataLoad(rowdata);
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
				bankFrm.TableDataLoad(rowdata);
			}
			//createAccountFrame.setVisible(false);
		}

	}
	class AddAccountForCompanyListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog buisnessDialog = new JDialog_AddCompanyAccount(bankFrm);
			buisnessDialog.setVisible(true);

		}

	}
	public ActionListener getAddAccountForCompanySubmitListener(CreateAccountFrame frame) {
		createAccountFrame = frame;
		return new AddAccountForCompany();
	}
	public ActionListener getAddAccountForCompanyListener(BankFrm frame) {
		return new AddAccountForCompanyListner();
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
			
			selectedAccount = bankFrm.JTable1.getSelectionModel().getMinSelectionIndex();
			if (selectedAccount >= 0) {
				accountNumber = (String) bankFrm.model.getValueAt(selectedAccount, 7);
				TranActionFrame deposit = new JDialog_Deposit(bankFrm,"Deposit", accountNumber);
				deposit.setVisible(true);
			}
		}

	}
	public ActionListener getDepositeAmountforAllCustomerSubmitListener(JDialog_Deposit frame) {
		depositFrm = frame;
		return new DepositeAmountforAllCustomer();
	}
	public ActionListener getDepositeAmountforAllCustomerListener(BankFrm frame) {
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
				selectedAccount = bankFrm.JTable1.getSelectionModel().getMinSelectionIndex();
				if (selectedAccount >= 0) {
					accountNumber = (String) bankFrm.model.getValueAt(selectedAccount, 7);
					TranActionFrame withDrowal = new JDialog_Withdraw(bankFrm,"Withdraw", accountNumber);
					withDrowal.setVisible(true);
				}
			}
	}
	public ActionListener getWithDrawalAmountforAllCustomerSubmitListener(JDialog_Withdraw frame) {
		withdrawFrame = frame;
		return new WithDrawalAmountforAllCustomer();

	}
	public ActionListener getWithDrawalAmountforAllCustomerListener(JDialog_Withdraw Form) {
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
