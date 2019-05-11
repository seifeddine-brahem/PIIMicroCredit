package tn.esprit.infini.micro_credit.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.AccountType;
import tn.esprit.infini.micro_credit.entities.CardOffer;
import tn.esprit.infini.micro_credit.entities.Currency;
import tn.esprit.infini.micro_credit.entities.CurrencyAccount;
import tn.esprit.infini.micro_credit.entities.Role;
import tn.esprit.infini.micro_credit.entities.User;

/**
 * Session Bean implementation class DbPopulator
 */
@Singleton
@LocalBean
@Startup
public class DbPopulator {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public DbPopulator() {
	}

	@PostConstruct
	private void inigt() {
		User user = new User("u", "u", "u@esprit.tn", "u", "u", "u1", Role.agent);
		User user1 = new User("u1", "u1", "u1@esprit.tn", "u1", "u1", "u1", Role.agent);
		User user2 = new User("u2", "u2", "u2@esprit.tn", "u2", "u2", "u1", Role.client);
		User user3 = new User("u3", "u3", "u3@esprit.tn", "u3", "u3", "u1", Role.client);

		Account account = new Account("12345", 1000D, AccountType.CurrentAccount);
		Account account2 = new Account("12346", 2000D, AccountType.DepositAccount);
		Account account3 = new Account("12347", 3000D, AccountType.CurrentAccount);
		CurrencyAccount account4 = new CurrencyAccount("112233", 4000D, Currency.EUR);

		CardOffer cardOffer = new CardOffer("master-card", "master-card", "123456789", new Date(), 123);
		CardOffer cardOffer2 = new CardOffer("e-dinar", "e-dinar", "12345678910", new Date(), 124);
		CardOffer cardOffer3 = new CardOffer("post-card", "post", "12345678911", new Date(), 125);
		CardOffer cardOffer4 = new CardOffer("Inter-Card", "international card", "1235487", new Date(), 127);

		List<Account> accounts = new ArrayList<>();
		accounts.add(account);
		accounts.add(account2);

		user2.linkAccounts(accounts);

		List<Account> accounts2 = new ArrayList<>();
		accounts2.add(account3);
		accounts2.add(account4);

		user3.linkAccounts(accounts2);

		em.merge(user);
		em.merge(user1);
		em.merge(user2);
		em.merge(user3);
		em.merge(cardOffer);
		em.merge(cardOffer2);
		em.merge(cardOffer3);
		em.merge(cardOffer4);
	}

}
