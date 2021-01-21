package com.capgemini.ui;

import com.capgemini.exceptions.*;
import com.capgemini.service.*;

public class Client {

	public static void main(String[] args) throws InsufficientOpeningAmountException, InsufficientBalanceException, InvalidAccountNumberException {
		HDFCBank bank = new HDFCBank();
		try
		{
		
		System.out.println(bank.createAccount(101,3000));
		System.out.println(bank.createAccount(102,3000));
		System.out.println("balance after amount withdrawn= "+bank.withdrawAmount(101,500));
		System.out.println("balance after amount deposited= "+bank.depositAmount(102,500));
		int[] amt = bank.fundTransfer(101, 102, 1000);
		System.out.println("sender accounts balance= "+ amt[0]);
		System.out.println("recievers account balance= "+amt[1]);
		
		}catch(InvalidAccountNumberException ie)
		{
			System.out.println("Invalid account number exception");
		}
		catch(InsufficientBalanceException ibe)
		{
			System.out.println("Insufficient balance");
		}
		catch(InsufficientOpeningAmountException ioa)
		{
			System.out.println("minimum balance should be 500");
		}
		
		
	}

}

