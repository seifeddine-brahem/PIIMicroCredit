package ctr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.infini.micro_credit.entities.Role;
import tn.esprit.infini.micro_credit.entities.User;
import tn.esprit.infini.micro_credit.services.IdentityServiceLocal;

@ManagedBean
@SessionScoped
public class IdentityBean {
	// Models
	private User user = new User();
	// Injection
	@EJB
	private IdentityServiceLocal identityServiceLocal;

	public String doLogin() {
		User userLoggedIn;
		userLoggedIn = identityServiceLocal.login(user.getEmail(), user.getPassword());
		if (userLoggedIn != null) {
			user = userLoggedIn;
			if (userLoggedIn.getRole().equals(Role.admin)) {
				System.out.println("admin");
			} else if (userLoggedIn.getRole().equals(Role.agent)) {
				return"/pages/agentHome/home";
			} else {
				return"/pages/clientHome/home";
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

}
