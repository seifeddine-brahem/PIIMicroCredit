package tn.esprit.infini.micro_credit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: CardRequest
 *
 */
@Entity

public class CardRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date creationDate;
	private Date processDate;
	private Boolean status;

	@ManyToOne
	private Account account;

	@ManyToOne
	private CardOffer cardOffer;

	public CardRequest() {
		super();
	}

	public CardRequest(Date creationDate, Date processDate, Account account, CardOffer cardOffer) {
		super();
		this.creationDate = creationDate;
		this.processDate = processDate;
		this.status = false;
		this.account = account;
		this.cardOffer = cardOffer;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public CardOffer getCardOffer() {
		return cardOffer;
	}

	public void setCardOffer(CardOffer cardOffer) {
		this.cardOffer = cardOffer;
	}

}
