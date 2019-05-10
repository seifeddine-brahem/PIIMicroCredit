package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tn.esprit.PIIMicroCredit.Interface.IAccount;
import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.AccountType;
import tn.esprit.PIIMicroCredit.entity.User;
@Stateless
@LocalBean
public class AccountService implements IAccount {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addAccount(Account A) {
		em.persist(A);
		System.out.println("Out of addAccount" + A.getId());
		return A.getId();
	}

	@Override
	public void removeAccount(int id) {
		System.out.println("In removeAccount: ");
		em.remove(em.find(Account.class, id));
		System.out.println("Out of removeAccount: ");

	}

	@Override
	public void updateAccount(Account A) {
		System.out.println("In updateAccount: ");
		Account acc = em.find(Account.class, A.getId());
		acc.setAccount_type(A.getAccount_type());
		acc.setOpenning_date(A.getOpenning_date());
		acc.setOwner(A.getOwner());
		acc.setRib(A.getRib());
		acc.setSolde(A.getSolde());

	}

	@Override
	public Account findAccountById(int id) {
		System.out.println("In findAccountById: ");
		Account A = em.find(Account.class, id);
		System.out.println("Out of findAccountById: ");
		return A;
	}

	@Override
	public List<Account> findAccounts() {
		System.out.println("In findAllAccounts: ");
		List<Account> accs = em.createQuery("from Account", Account.class).getResultList();
		System.out.println("Out of findAllAccounts: ");
		return accs;
	}

	@Override
	public Account findAccountByUser(int id) {
		UserService us = new UserService();
		User u = new User();
		u = us.FindUserById(id);
		Query query = em.createQuery("SELECT u FROM  Account u where u.owner=:ow");
		query.setParameter("ow", u);
		try {
			return (Account) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public long CalculerNombreComptesParType(AccountType type) {
		Query query = em.createQuery("SELECT count(u.id) FROM  Account u where u.account_type=:type");
		query.setParameter("type", type);
		try {
			return (long) query.getSingleResult();
		} catch (NoResultException e) {
			return 0;
		}
	}
	 @Override
	public Account FindAccoutByOwner(User owner)
    {
		Query query = em.createQuery("SELECT u FROM  Account u where u.owner=:owner");
		query.setParameter("owner", owner);
		try {
			return (Account) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
   // @Override
  /*  public List <Account> getAllAccountsByType(AccountType type)
    {   
    
    	String sql = "select i from Account i where i.account_type=:type";
    	
    	
		List<Account> emp =em.createQuery(sql, Account.class).getResultList();
		return emp;	
    	
    }*/
    
    @Override
    public List <Account> getAllAccountsByRIB(String RIB)
    {
    	
    	
    	String sql = "select i from Account i where i.rib like '"+RIB+"%'";
		List<Account> emp = em.createQuery(sql, Account.class).getResultList();
		return emp;		
    	
    }
    @Override
    public List <Account> getAllAccountsByuser(int id)
    {
    	
    	
    	String sql = "select i from Account i where i.owner = "+id+"";
		List<Account> emp = em.createQuery(sql, Account.class).getResultList();
		return emp;		
    	
    }
    
    
	
    
    
    
    
    
    
    
}
