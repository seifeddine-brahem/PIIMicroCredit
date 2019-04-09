package tn.esprit.infini.micro_credit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: CardOffer
 *
 */
@Entity

public class CardOffer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numCard;
	private Date validityDate;
	private Integer cryptogramme;

	@OneToMany(mappedBy = "cardOffer")
	private List<CardRequest> cardRequests;
	private static final long serialVersionUID = 1L;

	public CardOffer() {
		super();
	}

	public CardOffer(String numCard, Date validityDate, Integer cryptogramme) {
		super();
		this.numCard = numCard;
		this.validityDate = validityDate;
		this.cryptogramme = cryptogramme;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumCard() {
		return this.numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public Date getValidityDate() {
		return this.validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	public Integer getCryptogramme() {
		return this.cryptogramme;
	}

	public void setCryptogramme(Integer cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public List<CardRequest> getCardRequests() {
		return cardRequests;
	}

	public void setCardRequests(List<CardRequest> cardRequests) {
		this.cardRequests = cardRequests;
	}

}