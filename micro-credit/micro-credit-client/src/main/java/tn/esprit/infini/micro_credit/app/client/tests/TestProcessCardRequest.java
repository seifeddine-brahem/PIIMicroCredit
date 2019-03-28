package tn.esprit.infini.micro_credit.app.client.tests;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infini.micro_credit.entities.CardRequest;
import tn.esprit.infini.micro_credit.services.CardRequestServiceRemote;

public class TestProcessCardRequest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CardRequestServiceRemote cardRequestServiceRemote = (CardRequestServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/CardRequestService!tn.esprit.infini.micro_credit.services.CardRequestServiceRemote");

		CardRequest cardRequest = cardRequestServiceRemote.findCardRequestById(1);

		cardRequestServiceRemote.processCardRequest(cardRequest, true, new Date());

		CardRequest cardRequest2 = cardRequestServiceRemote.findCardRequestById(1);
		
		System.out.println(cardRequest2.getStatus());

	}

}
