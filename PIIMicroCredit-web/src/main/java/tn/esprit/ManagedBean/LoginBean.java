package tn.esprit.ManagedBean;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import tn.esprit.PIIMicroCredit.entity.Role;
import tn.esprit.PIIMicroCredit.entity.Session;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.service.UserService;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private User user;
	private Boolean loggedIn;
	
	@EJB
	UserService us;

	public String doLogin() {
		
		String navigateTo = "null";
		user = us.FindUserByEmailAndPsswd(login, password);
		if (user != null && user.getRole() == Role.client) {
			navigateTo = "/xhtml/Welcome?faces-redirect=true";
			Authenticator.currentsession=new Session(user);
			System.out.println(Authenticator.currentsession.getUser().getId());
			loggedIn = true;
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo;
	}
	public User getCurrent()
	{
		return Authenticator.currentsession.getUser();
	}
	
	
	

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        Authenticator.currentsession=null;
		return "../xhtml/login.jsf";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
