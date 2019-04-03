package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tn.esprit.PIIMicroCredit.Interface.IAccount;
import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.User;

@Stateless
@Remote
public class AccountService implements IAccount{
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
		UserService us= new UserService();
		User u=new User();
		u=us.FindUserById(id);
		Query query = em.createQuery("SELECT u FROM  Account u where u.owner=:ow");
		query.setParameter("ow",u);
		try {
			return (Account) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
