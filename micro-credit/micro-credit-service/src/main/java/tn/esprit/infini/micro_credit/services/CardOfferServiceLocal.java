package tn.esprit.infini.micro_credit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.infini.micro_credit.entities.CardOffer;

@Local
public interface CardOfferServiceLocal {
	void addCardOffer(CardOffer cardOffer);

	void updateCardOffer(CardOffer cardOffer);

	void deleteCardOffer(CardOffer cardOffer);

	CardOffer findCardOfferById(Integer id);

	CardOffer findCardOfferAccount(Integer idAccount);

	List<CardOffer> findAllCardOffers();

}
