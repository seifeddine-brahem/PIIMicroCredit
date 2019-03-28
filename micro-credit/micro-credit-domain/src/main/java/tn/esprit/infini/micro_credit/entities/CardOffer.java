package tn.esprit.infini.micro_credit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CardOffer
 *
 */
@Entity

public class CardOffer implements Serializable {

	   
	@Id
	private Integer id;
	private String numCard;
	private Date validityDate;
	private Integer cryptogramme;
	private static final long serialVersionUID = 1L;

	public CardOffer() {
		super();
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
   
}
