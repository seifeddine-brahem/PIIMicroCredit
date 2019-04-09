package tn.esprit.infini.micro_credit.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infini.micro_credit.entities.User;

/**
 * Session Bean implementation class IdentityService
 */
@Stateless
public class IdentityService implements IdentityServiceRemote, IdentityServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public IdentityService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		try {
			user = em.createQuery("SELECT u FROM User u WHERE u.email=:l AND u.password=:p", User.class)
					.setParameter("l", login).setParameter("p", password).getSingleResult();
		} catch (Exception e) {
		}
		return user;
	}

}
