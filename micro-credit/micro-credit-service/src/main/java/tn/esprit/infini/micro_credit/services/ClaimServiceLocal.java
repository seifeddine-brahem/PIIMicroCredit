package tn.esprit.infini.micro_credit.services;

import javax.ejb.Local;

@Local
public interface ClaimServiceLocal {
	void unboundCard(Integer idAccount);
}
