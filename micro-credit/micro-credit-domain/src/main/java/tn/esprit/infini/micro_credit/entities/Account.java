package tn.esprit.infini.micro_credit.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "rib")
	private String rib;
	@Column(name = "solde")
	private String solde;
	@Column(name = "openning_date")
	private LocalDateTime openning_date;
	@Column(name = "account_type")
	private AccountType account_type;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	@ManyToOne
	private CardOffer cardOffer;
	
	@OneToMany(mappedBy="account")
	private List<CardRequest> cardRequests;

	public Account() {
		this.owner = new User();

	}

	public Account(String rib, String solde, AccountType account_type) {
		super();
		this.rib = rib;
		this.solde = solde;
		this.account_type = account_type;
	}
	public Account(String rib, String solde) {
		super();
		this.rib = rib;
		this.solde = solde;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	public LocalDateTime getOpenning_date() {
		return openning_date;
	}

	public void setOpenning_date(LocalDateTime openning_date) {
		this.openning_date = openning_date;
	}

	public AccountType getAccount_type() {
		return account_type;
	}

	public void setAccount_type(AccountType account_type) {
		this.account_type = account_type;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public CardOffer getCardOffer() {
		return cardOffer;
	}

	public void setCardOffer(CardOffer cardOffer) {
		this.cardOffer = cardOffer;
	}

	public List<CardRequest> getCardRequests() {
		return cardRequests;
	}

	public void setCardRequests(List<CardRequest> cardRequests) {
		this.cardRequests = cardRequests;
	}

}
