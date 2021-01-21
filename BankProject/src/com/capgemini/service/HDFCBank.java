package com.capgemini.service;
import com.capgemini.beans.*;
import com.capgemini.exceptions.*;
import java.util.LinkedList;

public class HDFCBank implements Bank {
	private LinkedList <Account> accounts = new LinkedList<>();

	public String createAccount(int accountNumber, int amount) throws InsufficientOpeningAmountException
	{
		if(amount>=500)
		{
		Account account =new Account(accountNumber, amount);
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);;
		accounts.add(account);
		return "account created successfully";
		}
		throw new InsufficientOpeningAmountException();
	}
	
	public Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}
	public int withdrawAmount(int accountNumber, int amount)throws InsufficientBalanceException, InvalidAccountNumberException

	{
		Account account = searchAccount(accountNumber);
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		throw new InsufficientBalanceException();
	}
	public int depositAmount(int accountNumber, int amount)throws InvalidAccountNumberException{
		Account account = searchAccount(accountNumber);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
	}
	
	public int[] fundTransfer(int senderAccount, int receiverAccount, int amount)throws InvalidAccountNumberException
	{
		Account sender =searchAccount(senderAccount);
		Account receiver= searchAccount(receiverAccount);
		sender.setAmount(sender.getAmount()-amount);
		receiver.setAmount(receiver.getAmount()+amount);
		int[] amt = { sender.getAmount() , receiver.getAmount()};
		return amt;
		
	}


}
