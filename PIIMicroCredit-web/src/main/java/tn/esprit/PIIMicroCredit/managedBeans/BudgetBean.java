package tn.esprit.PIIMicroCredit.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.AccountType;
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
	private Account depositA ;
	private Account currentA ;
	private Account savingA ;
	private Account a ;

	public Account getDepositA() {
		u.setId(1);
		
		List<Account> l = new ArrayList<>();
		l=bs.getAllAccountsByuser(u.getId());
		for(int i=0;i<l.size();i++)
		{
		
			if (l.get(i).getAccount_type()==AccountType.DepositAccount)
			{
				depositA=l.get(i);
			}
			
				
		}
		return depositA;
		
	}
	public void setDepositA(Account depositA) {
		this.depositA = depositA;
	}
	public Account getCurrentA() {
		u.setId(1);
		
		List<Account> l = new ArrayList<>();
		l=bs.getAllAccountsByuser(u.getId());
		for(int i=0;i<l.size();i++)
		{
			if (l.get(i).getAccount_type()==AccountType.CurrentAccount)
			{
				currentA=l.get(i);
			}
				
			}			
		
		
		return currentA;
	}
	public void setCurrentA(Account currentA) {
		this.currentA = currentA;
	}
	public Account getSavingA() {
		u.setId(1);
		
		List<Account> l = new ArrayList<>();
		l=bs.getAllAccountsByuser(u.getId());
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
	
			if (l.get(i).getAccount_type()==AccountType.SavingAccount)
			{
				savingA=l.get(i);
				
			}			
		}
		
		return savingA;
	}
	public void setSavingA(Account savingA) {
		this.savingA = savingA;
	}
	private User u = new User();
	public BudgetBean() {
	
		super();
		
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
		u.setId(1);
		
		List<Account> l = new ArrayList<>();
		l=bs.getAllAccountsByuser(u.getId());
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			if (l.get(i).getAccount_type()==AccountType.CurrentAccount)
			{
				currentA=l.get(i);
			}
			if (l.get(i).getAccount_type()==AccountType.DepositAccount)
			{
				depositA=l.get(i);
			}
			if (l.get(i).getAccount_type()==AccountType.SavingAccount)
			{
				savingA=l.get(i);
				
			}			
		}
		
		return l;
	}

}
