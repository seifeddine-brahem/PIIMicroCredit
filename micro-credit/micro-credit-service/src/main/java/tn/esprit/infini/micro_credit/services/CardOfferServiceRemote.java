package tn.esprit.infini.micro_credit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infini.micro_credit.entities.CardOffer;

@Remote
public interface CardOfferServiceRemote {

	void addCardOffer(CardOffer cardOffer);

	void updateCardOffer(CardOffer cardOffer);

	void deleteCardOffer(CardOffer cardOffer);

	CardOffer findCardOfferById(Integer id);

	CardOffer findCardOfferAccount(Integer idAccount);

	List<CardOffer> findAllCardOffers();
}
