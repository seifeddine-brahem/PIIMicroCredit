package tn.esprit.infini.micro_credit.app.client.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.infini.micro_credit.services.ClaimServiceRemote;

public class TestClaimCard {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ClaimServiceRemote claimServiceRemote = (ClaimServiceRemote) context.lookup(
				"micro-credit-ear/micro-credit-service/ClaimService!tn.esprit.infini.micro_credit.services.ClaimServiceRemote");

		claimServiceRemote.unboundCard(1);

	}

}
