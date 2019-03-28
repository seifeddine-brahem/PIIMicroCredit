package tn.esprit.infini.micro_credit.app.client.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infini.micro_credit.entities.CardOffer;
import tn.esprit.infini.micro_credit.services.CardOfferServiceRemote;

public class TestDeleteCardOffer {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CardOfferServiceRemote cardOfferServiceRemote = (CardOfferServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/CardOfferService!tn.esprit.infini.micro_credit.services.CardOfferServiceRemote");

		CardOffer cardOffer = cardOfferServiceRemote.findCardOfferById(1);

		cardOfferServiceRemote.deleteCardOffer(cardOffer);
	}

}
