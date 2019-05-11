package tn.esprit.infini.micro_credit.services;

import javax.ejb.Local;

import tn.esprit.infini.micro_credit.entities.Account;

@Local
public interface TransferServiceLocal {
	void transferToAccount(Double amount, Account accountFrom, Account accountTo);
	void allowanceToAccount(Double amout, Account account);
}
