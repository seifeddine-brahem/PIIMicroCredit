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

	/**
	 * 
	 */
	private static final long serialVersionUID = 8166263809649454653L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private String numCard;
	private Date validityDate;
	private Integer cryptogramme;

	@OneToMany(mappedBy = "cardOffer")
	private List<CardRequest> cardRequests;

	public CardOffer() {
		super();
	}

	public CardOffer(String numCard, Date validityDate, Integer cryptogramme) {
		super();
		this.numCard = numCard;
		this.validityDate = validityDate;
		this.cryptogramme = cryptogramme;
	}

	public CardOffer(String name, String description, String numCard, Date validityDate, Integer cryptogramme) {
		super();
		this.name = name;
		this.description = description;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
