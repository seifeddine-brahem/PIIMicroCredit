package tn.esprit.PIMicroCredit.interfacee;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.AccountType;
import tn.esprit.PIIMicroCredit.entity.User;


@Remote
public interface IAccount {
	public int addAccount(Account A);
	public void removeAccount(int id);
	public void updateAccount(Account A);
	public Account findAccountById(int id);
	public List<Account> findAccounts();
//	public Account findAccountByUser(int id);
	public long CalculerNombreComptesParType(AccountType type);
	public Account FindAccoutByOwner(User owner);
}
