package tn.esprit.infini.micro_credit.services;

import javax.ejb.Remote;

@Remote
public interface ClaimServiceRemote {
	void unboundCard(Integer idAccount);
}
