package tn.esprit.infini.micro_credit.services;

import javax.ejb.Local;

import tn.esprit.infini.micro_credit.entities.Currency;

@Local
public interface CurrencyServiceLocal {
	Double convertToCurrency(Currency currencyFrom,Currency currencyTo,Double amount);

}
