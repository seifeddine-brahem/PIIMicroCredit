package tn.esprit.infini.micro_credit.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CardRequest;

@Remote
public interface CardRequestServiceRemote {

	CardRequest findCardRequestById(Integer id);

	Account findAccountById(Integer id);

	void addCardRequest(CardRequest cardRequest);

	void processCardRequest(CardRequest cardRequest, Boolean status, Date dateOfProcess);

	List<CardRequest> findAllRequestsByCustomer(int idCustomer);

}
