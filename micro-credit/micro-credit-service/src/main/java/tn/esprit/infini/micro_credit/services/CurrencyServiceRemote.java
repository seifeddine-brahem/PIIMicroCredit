package tn.esprit.infini.micro_credit.services;

import javax.ejb.Remote;

import tn.esprit.infini.micro_credit.entities.Currency;

@Remote
public interface CurrencyServiceRemote {
	Double convertToCurrency(Currency currencyFrom,Currency currencyTo,Double amount);

}
