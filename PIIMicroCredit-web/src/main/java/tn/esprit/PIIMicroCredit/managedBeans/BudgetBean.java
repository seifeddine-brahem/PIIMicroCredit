package tn.esprit.PIIMicroCredit.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.service.AccountService;
import tn.esprit.PIIMicroCredit.service.BudgetService;
import tn.esprit.PIIMicroCredit.service.UserService;

@ManagedBean(name = "budgetBean")
@SessionScoped 
public class BudgetBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	BudgetService bs;
	private Account a ;
	private User u = new User();
	public BudgetBean() {
	
		super();
		u.setId(1);
		// TODO Auto-generated constructor stub
	}
	public double getSolde()
	{

		System.out.println(u);
		a=bs.getAccountUser(u);
		
		return a.getSolde();
	}
	public List<Account> getAllUserAccounts()
	{
		AccountService us = new AccountService();
		List<Account> l = new ArrayList<>();
		l=us.getAllAccountsByuser(u.getId());
		System.out.println(l.size());
		
		return l;
	}

}
