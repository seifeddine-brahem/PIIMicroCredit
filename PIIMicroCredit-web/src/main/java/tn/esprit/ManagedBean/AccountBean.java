package tn.esprit.ManagedBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.AccountType;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.service.AccountService;
import tn.esprit.PIIMicroCredit.service.UserService;


@SessionScoped
@ManagedBean
public class AccountBean {
	private Integer id;
	private AccountType accountT;
	private Date date;
	private String rib;
	private double solde;
	private boolean state;
	private User user;
	
	@EJB
	private AccountService as;

	

	@EJB
	private UserService us;

	public List<Account> showAll(int id) {
		return as.getAllAccountsByuser(id);

	}

	public String disableAccount(int id) {
		String navigateTo = "null";
		Account a = as.findAccountById(id);
		a.setState(false);
		as.updateAccount(a);
		navigateTo = "/xhtml/ShowAccounts2?faces-redirect=true";
		return navigateTo;
	}

	public String addAccount() {
		String navigateTo = "null";
		long rib_n=0;
        rib_n=(long)Math.random() * 10000;
		Account a = new Account(rib_n+"", 0, LocalDateTime.now(), accountT, Authenticator.currentsession.getUser());
		as.addAccount(a);

		navigateTo = "/xhtml/ShowAccounts2?faces-redirect=true";
		return navigateTo;
	}
	
	
	public String showAccounts() {
		String navigateTo = "null";
		
		navigateTo = "/xhtml/ShowAccounts2?faces-redirect=true";
		return navigateTo;
	}
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AccountType getAccountT() {
		return accountT;
	}

	public void setAccountT(AccountType accountT) {
		this.accountT = accountT;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AccountService getAs() {
		return as;
	}

	public void setAs(AccountService as) {
		this.as = as;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public AccountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountType[] getTypes() {
		return AccountType.values();
	}

}
