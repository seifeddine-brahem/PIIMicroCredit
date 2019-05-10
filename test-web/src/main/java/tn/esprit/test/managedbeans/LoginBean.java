package tn.esprit.test.managedbeans;


import java.io.Serializable;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.PIIMicroCredit.entity.Employe;
import tn.esprit.PIIMicroCredit.entity.Role;
import tn.esprit.PIMicroCredit.service.EmployeService;









@ManagedBean(name="loginBean") 
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String login; 
	private String password; 
	private Employe employe; 
	private Boolean loggedIn;

	@EJB
	EmployeService employeService; 

	public String doLogin()
	{
		String navigateTo = "null"; 
		employe = employeService.getEmployeByEmailAndPassword(login, password); 

		if (employe != null && employe.getRole() == Role.admin) {
			navigateTo = "/pages/offer/Offer2?faces-redirect=true";

			loggedIn = true; 
		}
		else 
		{
			navigateTo = "/pages/offer/Offer2?faces-redirect=true";
			//FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
 
	public LoginBean() {} 
	
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public Employe getEmploye() {return employe;}
	public void setEmploye(Employe employe) {this.employe = employe;}
	public Boolean getLoggedIn() {return loggedIn;}
	public void setLoggedIn(Boolean loggedIn) {this.loggedIn = loggedIn;}

}
