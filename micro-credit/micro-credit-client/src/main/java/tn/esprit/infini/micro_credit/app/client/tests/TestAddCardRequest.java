package tn.esprit.infini.micro_credit.app.client.tests;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CardOffer;
import tn.esprit.infini.micro_credit.entities.CardRequest;
import tn.esprit.infini.micro_credit.services.CardOfferServiceRemote;
import tn.esprit.infini.micro_credit.services.CardRequestServiceRemote;

public class TestAddCardRequest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CardRequestServiceRemote cardRequestServiceRemote = (CardRequestServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/CardRequestService!tn.esprit.infini.micro_credit.services.CardRequestServiceRemote");

		CardOfferServiceRemote cardOfferServiceRemote = (CardOfferServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/CardOfferService!tn.esprit.infini.micro_credit.services.CardOfferServiceRemote");

		Account account = cardRequestServiceRemote.findAccountById(2);
		
		CardOffer cardOffer = cardOfferServiceRemote.findCardOfferById(1);
		
		CardRequest cardRequest = new CardRequest(new Date(), new Date(), account, cardOffer);
		
		cardRequestServiceRemote.addCardRequest(cardRequest);

	}

}
