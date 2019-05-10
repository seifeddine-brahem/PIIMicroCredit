package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.AccountType;
import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.Transaction;
import tn.esprit.PIIMicroCredit.entity.User;

@Remote
public interface IBudgetManagement {
	public User FindUserById(int id);
	public Account getAccountUser(User u);
	public List<Transaction> getIncomingTransaction(User u);
	public List<Transaction> getOutgoingTransaction(User u);
	public Loan getAccountLoan(Account a);
	public List <Account> getAllAccountsByuser(int id);
	public List <Account> getAllAccountsByType(AccountType type,User u);


}
