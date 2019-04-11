package tn.esprit.infini.micro_credit.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CardRequest;
import tn.esprit.infini.micro_credit.entities.User;

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
	}

	@Override
	public void addCardRequest(CardRequest cardRequest) {
		em.persist(cardRequest);
	}

	@Override
	public void processCardRequest(CardRequest cardRequest, Boolean status, Date dateOfProcess) {
		if (status == true) {
			Account account = cardRequest.getAccount();
			account.setCardOffer(cardRequest.getCardOffer());
			cardRequest.setStatus(status);
			em.merge(cardRequest);
			em.merge(account);
		} else {
			Account account = cardRequest.getAccount();
			account.setCardOffer(null);
			cardRequest.setStatus(status);
			em.merge(cardRequest);
			em.merge(account);
		}

	}

	@Override
	public List<CardRequest> findAllRequestsByCustomer(int idCustomer) {
		List<CardRequest> cardRequests = new ArrayList<>();
		User customer = em.find(User.class, idCustomer);
		List<Account> accounts = new ArrayList<>();
		accounts = customer.getAccounts();
		for (Account c : accounts) {
			cardRequests.addAll(c.getCardRequests());
		}
		return cardRequests;
	}

	@Override
	public Account findAccountById(Integer id) {
		return em.find(Account.class, id);
	}

	@Override
	public CardRequest findCardRequestById(Integer id) {
		return em.find(CardRequest.class, id);
	}

	@Override
	public List<Account> findAllAccountsByCustomer(int idCustomer) {
		User user = em.find(User.class, idCustomer);
		return em.createQuery("SELECT a FROM Account a WHERE a.owner=:p").setParameter("p", user).getResultList();
	}

	@Override
	public List<CardRequest> findAllRequests() {
		return em.createQuery("SELECT a FROM CardRequest a ").getResultList();
	}

}
