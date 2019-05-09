package tn.esprit.infini.micro_credit.entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: CurrencyAccount
 *
 */
@Entity

public class CurrencyAccount extends Account implements Serializable {

	private Currency currency;
	private static final long serialVersionUID = 1L;

	public CurrencyAccount() {
		super();
	}

	public CurrencyAccount(String rib, String solde, Currency currency) {
		super(rib, solde);
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
