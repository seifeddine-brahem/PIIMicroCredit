package tn.esprit.infini.micro_credit.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.Currency;
import tn.esprit.infini.micro_credit.entities.CurrencyAccount;

/**
 * Session Bean implementation class TransferService
 */
@Stateless
public class TransferService implements TransferServiceRemote, TransferServiceLocal {
	@EJB
	private CurrencyServiceLocal currencyService;
	@EJB
	private CardRequestServiceLocal cardRequestServiceLocal;

	/**
	 * Default constructor.
	 */
	public TransferService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transferToAccount(Double amount, Account accountFrom, Account accountTo) {
		if (accountFrom instanceof CurrencyAccount) {
			Double amountWithChange = currencyService.convertToCurrency(((CurrencyAccount) accountFrom).getCurrency(),
					Currency.DT, amount);
			accountTo.setSolde(accountTo.getSolde() + amountWithChange);
			accountFrom.setSolde(accountFrom.getSolde() - amountWithChange);

			cardRequestServiceLocal.updateAccount(accountTo);
			cardRequestServiceLocal.updateAccount(accountFrom);

		} else {
			accountTo.setSolde(accountTo.getSolde() + amount);
			accountFrom.setSolde(accountFrom.getSolde() - amount);
			cardRequestServiceLocal.updateAccount(accountTo);
			cardRequestServiceLocal.updateAccount(accountFrom);
		}

	}

	@Override
	public void allowanceToAccount(Double amout, Account account) {
		Double amountWithChange = currencyService.convertToCurrency(((CurrencyAccount) account).getCurrency(),
				Currency.DT, amout);
		account.setSolde(account.getSolde() + amountWithChange);

		cardRequestServiceLocal.updateAccount(account);

	}

}
