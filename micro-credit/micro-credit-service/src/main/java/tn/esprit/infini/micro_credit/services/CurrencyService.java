package tn.esprit.infini.micro_credit.services;

import javax.ejb.Stateless;

import tn.esprit.infini.micro_credit.entities.Currency;

/**
 * Session Bean implementation class CurrencyService
 */
@Stateless
public class CurrencyService implements CurrencyServiceRemote, CurrencyServiceLocal {

    /**
     * Default constructor. 
     */
    public CurrencyService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Double convertToCurrency(Currency currencyFrom, Currency currencyTo, Double amount) {
		switch (currencyFrom) {
		case USD:
			switch (currencyTo) {
			case EUR:
				return amount=amount*1.2;
			case DT:
				return amount=amount*1.3;

			default:
				break;
			}
		case EUR:
			switch (currencyTo) {
			case USD:
				return amount=amount*1.2;
			case DT:
				return amount=amount*3.4;
			default:
				break;
			}
		case DT:
			switch (currencyTo) {
			case EUR:
				return amount=amount*0.3;
			case USD:
				return amount=amount*0.6;

			default:
				break;
			}

		default:
			break;
		}
		return amount;
	}

}
