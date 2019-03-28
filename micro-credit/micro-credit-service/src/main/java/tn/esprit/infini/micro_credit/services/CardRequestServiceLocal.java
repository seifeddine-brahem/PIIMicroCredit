package tn.esprit.infini.micro_credit.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.infini.micro_credit.entities.CardRequest;

@Local
public interface CardRequestServiceLocal {
	void addCardRequest(CardRequest cardRequest);

	void processCardRequest(CardRequest cardRequest, Boolean status, Date dateOfProcess);

	List<CardRequest> findAllRequestsByCustomer(int idCustomer);
}
