package tn.esprit.infini.micro_credit.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated method stub

	}

}
