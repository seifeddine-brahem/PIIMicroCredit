package tn.esprit.infini.micro_credit.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infini.micro_credit.entities.Account;

/**
 * Session Bean implementation class ClaimService
 */
@Stateless
public class ClaimService implements ClaimServiceRemote, ClaimServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ClaimService() {
	}

	@Override
	public void unboundCard(Integer idAccount) {
		Account account = em.find(Account.class, idAccount);
		account.setCardOffer(null);

		em.merge(account);

	}

}
