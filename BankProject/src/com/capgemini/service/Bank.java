package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.*;
public interface Bank {
	String createAccount(int accountNumber, int amount) throws InsufficientOpeningAmountException;
	Account searchAccount(int accountNumber)throws InvalidAccountNumberException;
	int withdrawAmount(int accountNumber, int amount)throws InsufficientBalanceException, InvalidAccountNumberException;
	int depositAmount(int accountNumber, int amount)throws InvalidAccountNumberException;
	int[] fundTransfer(int senderAccount, int receiverAccount, int amount)throws InvalidAccountNumberException;
}
