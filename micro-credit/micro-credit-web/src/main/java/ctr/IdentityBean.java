package ctr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.infini.micro_credit.entities.Role;
import tn.esprit.infini.micro_credit.entities.User;
import tn.esprit.infini.micro_credit.services.IdentityServiceLocal;

@ManagedBean
@SessionScoped
public class IdentityBean {
	// Models
	private User user = new User();
	private boolean loggedIn = false;
	private boolean loggedInAsAgent = false;
	private boolean loggedInAsClient = false;
	// Injection
	@EJB
	private IdentityServiceLocal identityServiceLocal;

	public String logout() {
		loggedIn = false;
		loggedInAsAgent = false;
		loggedInAsClient = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String doLogin() {
		User userLoggedIn;
		userLoggedIn = identityServiceLocal.login(user.getEmail(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			loggedIn = true;
			if (userLoggedIn.getRole().equals(Role.admin)) {
				System.out.println("admin");
			} else if (userLoggedIn.getRole().equals(Role.agent)) {
				loggedInAsClient = false;
				loggedInAsAgent = true;
				return "/pages/agentHome/home";
			} else {
				loggedInAsAgent = false;
				loggedInAsClient = true;
				return "/pages/clientHome/home";
			}
		} else {
			return "ko";
		}
		return "ok";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isLoggedInAsClient() {
		return loggedInAsClient;
	}

	public void setLoggedInAsClient(boolean loggedInAsClient) {
		this.loggedInAsClient = loggedInAsClient;
	}

	public boolean isLoggedInAsAgent() {
		return loggedInAsAgent;
	}

	public void setLoggedInAsAgent(boolean loggedInAsAgent) {
		this.loggedInAsAgent = loggedInAsAgent;
	}

}
