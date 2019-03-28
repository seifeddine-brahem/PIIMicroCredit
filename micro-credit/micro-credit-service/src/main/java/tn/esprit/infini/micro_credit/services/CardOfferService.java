package tn.esprit.infini.micro_credit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCardOffer(CardOffer cardOffer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCardOffer(CardOffer cardOffer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCardOffer(CardOffer cardOffer) {
		// TODO Auto-generated method stub

	}

	@Override
	public CardOffer findCardOfferById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CardOffer> findAllCardOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardOffer findCardOfferAccount(Integer idAccount) {
		// TODO Auto-generated method stub
		return null;
	}

}
