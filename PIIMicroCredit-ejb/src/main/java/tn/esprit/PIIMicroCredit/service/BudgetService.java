package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.PIIMicroCredit.Interface.IBudgetManagement;
import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.AccountType;
import tn.esprit.PIIMicroCredit.entity.Complaint;
import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.Transaction;
import tn.esprit.PIIMicroCredit.entity.User;

@Stateless
@LocalBean
public class BudgetService implements IBudgetManagement {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;
	@Override
	public Account getAccountUser(User u) {
		System.out.println("In findAccountByUser(User): ");
		User u1= this.FindUserById(u.getId());
		Account c = em.createQuery("select c from Account c where c.owner= "+u1.getId(), Account.class).getSingleResult() ;
		System.out.println("In findAccountByUser(User): ");
		return c;
	}

	@Override
	public List<Transaction> getIncomingTransaction(User u) {
		System.out.println(" getIncomingTransaction(User u): ");
		List<Transaction> c = em.createQuery("select c from Transaction c where c.receiver = "+u.getId(), Transaction.class).getResultList();
		System.out.println(" getIncomingTransaction(User u) ");
		return c;
	}

	@Override
	public List<Transaction> getOutgoingTransaction(User u) {
		System.out.println(" getOutgoingTransaction(User u): ");
		List<Transaction> c = em.createQuery("select c from Transaction c where c.sender = "+u.getId(), Transaction.class).getResultList();
		System.out.println(" getOutgoingTransaction(User u) ");
		return c;
	}

	@Override
	public Loan getAccountLoan(Account a) {
		System.out.println("================================== In findLoanByOwner(User): ");
		Loan l = em.createQuery("select l from Loan l where l.account= "+a.getId(), Loan.class).getSingleResult();
		System.out.println("================================== Out of findLoantByOwner =================================="+l.getAmount());
		return l;	}


	@Override
	public User FindUserById(int id) {
		System.out.println("In findUserByIdBudget: ");
		User d = em.find(User.class, id);
		System.out.println("Out of findUserByIdBudget: ");
		return d;
	}
	@Override
    public List <Account> getAllAccountsByuser(int id)
    {
    	
    	
    	String sql = "select i from Account i where i.owner = "+id+"";
		List<Account> emp = em.createQuery(sql, Account.class).getResultList();
		return emp;		
    	
    }
	@Override
	 public List <Account> getAllAccountsByType(AccountType type, User u)
    {   
    
    	String sql = "select i from Account i where i.account_type=:type";
    	
    	
		List<Account> emp =em.createQuery(sql, Account.class).getResultList();
		return emp;	
    	
    }
}
