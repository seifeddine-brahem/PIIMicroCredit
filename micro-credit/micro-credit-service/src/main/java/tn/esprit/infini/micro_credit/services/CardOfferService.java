package tn.esprit.infini.micro_credit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CardOffer;

/**
 * Session Bean implementation class CardOfferService
 */
@Stateless
public class CardOfferService implements CardOfferServiceRemote, CardOfferServiceLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CardOfferService() {
	}

	@Override
	public void addCardOffer(CardOffer cardOffer) {
		em.merge(cardOffer);

	}

	@Override
	public void updateCardOffer(CardOffer cardOffer) {
		em.merge(cardOffer);

	}

	@Override
	public void deleteCardOffer(CardOffer cardOffer) {
		em.remove(em.merge(cardOffer));

	}

	@Override
	public CardOffer findCardOfferById(Integer id) {
		return em.find(CardOffer.class, id);
	}

	@Override
	public List<CardOffer> findAllCardOffers() {
		return (List<CardOffer>) em.createQuery("SELECT c FROM CardOffer c ").getResultList();
	}

	@Override
	public CardOffer findCardOfferAccount(Integer idAccount) {
		Account account = em.find(Account.class, idAccount);
		return account.getCardOffer();
	}

}
