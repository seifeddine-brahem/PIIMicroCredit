package tn.esprit.infini.micro_credit.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CardRequest;

@Local
public interface CardRequestServiceLocal {
	CardRequest findCardRequestById(Integer id);

	Account findAccountById(Integer id);

	void addCardRequest(CardRequest cardRequest);

	void processCardRequest(CardRequest cardRequest, Boolean status, Date dateOfProcess);

	List<CardRequest> findAllRequestsByCustomer(int idCustomer);
	
	List<Account> findAllAccountsByCustomer(int idCustomer);
	
	List<CardRequest> findAllRequests();
}
