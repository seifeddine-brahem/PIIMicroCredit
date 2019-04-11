package tn.esprit.PIMicroCredit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.AccountType;
import tn.esprit.PIIMicroCredit.entity.Offer;
import tn.esprit.PIIMicroCredit.entity.Transaction;
import tn.esprit.PIIMicroCredit.entity.TransactionType;
import tn.esprit.PIMicroCredit.interfacee.ITransactionRemote;

@Remote
@Stateless

public class TransactionService implements ITransactionRemote {

	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;
	
	@Override
	public Account consultercompte(int id) {
		Account ba=em.find(Account.class,id);
		if(ba==null) throw new RuntimeException("Compte introuvable");
		return ba;

	}
	
	@Override
	public void retirer(double montant,int id,int User_ID)//withdrawal
	{
		Account ba = consultercompte(id);
		ba.setSolde(ba.getSolde()-montant);
		
	}
	
	@Override
	public List<Transaction> consulterTransaction (int id) {
		Query req=em.createQuery("Select o from Transaction where o.Account.id=:x");
		req.setParameter("x", id); 
		return req.getResultList();
	}
	
	@Override
	public void UpdateSolde(int id, double solde) {
		Account accc= em.find(Account.class, id);
		System.out.println("Account Update ****************");
		System.out.println(accc);
		accc.setAccount_type(AccountType.CurrentAccount);
		accc.setSolde(accc.getSolde()-solde);
		System.out.println("Acoount updated ******** "+accc);
	    em.merge(accc);	
	      
	     
	}
	
	public List<Transaction> consulterAllTransactions() {
		List<Transaction> Operations=em.createQuery("from Operation", Transaction.class).getResultList();
		return Operations;
		
	}
	@Override
	public void addTransaction(Transaction op) {
		System.out.println("ssssssssssssssssssss******************************************");
		op.setDate_transaction(new Date());
		System.out.println(op.getDate_transaction());
		em.persist(op);
		
		
	}
	
	@Override
	public int add(Transaction n) {
		em.persist(n);
		System.out.println("Out of transaction" + n.getId());
		return n.getId();
	}
	
	@Override
	public void UpdateBalanceplus(int id, double balance) {
	
		Account accc= new Account();
		accc.setAccount_type(AccountType.CurrentAccount);
		accc = em.find(Account.class, id);
		
		accc.setSolde(accc.getSolde()+balance);
	      em.merge(accc);	
	      
		
		
	}

	@Override
	public ArrayList<Transaction> findAllTransaction() {
		
		TypedQuery<Transaction> A =  em.createQuery("select c from Transaction c",Transaction.class) ;
		ArrayList<Transaction> O = (ArrayList<Transaction>) A.getResultList() ;
		return O;
	
	}
	@Override
	public Long nbTransaction() {
		TypedQuery<Long> q =  em.createQuery("select Count(c) from Transaction c ",Long.class) ;
		return q.getSingleResult() ;
	}
	
	
	
}
