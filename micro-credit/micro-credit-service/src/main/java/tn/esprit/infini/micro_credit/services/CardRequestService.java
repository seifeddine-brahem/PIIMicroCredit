package tn.esprit.infini.micro_credit.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infini.micro_credit.entities.CardRequest;

/**
 * Session Bean implementation class CardRequestService
 */
@Stateless
public class CardRequestService implements CardRequestServiceRemote, CardRequestServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CardRequestService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCardRequest(CardRequest cardRequest) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processCardRequest(CardRequest cardRequest, Boolean status, Date dateOfProcess) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CardRequest> findAllRequestsByCustomer(int idCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
