package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Account;


@Remote
public interface IAccount {
	public int addAccount(Account A);
	public void removeAccount(int id);
	public void updateAccount(Account A);
	public Account findAccountById(int id);
	public List<Account> findAccounts();
	public Account findAccountByUser(int id);
}
