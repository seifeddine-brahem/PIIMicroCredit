package tn.esprit.infini.micro_credit.entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CardRequest
 *
 */
@Entity

public class CardRequest implements Serializable {

	   
	@Id
	private Integer id;
	private Date creationDate;
	private Date processDate;
	private Boolean status;
	private static final long serialVersionUID = 1L;

	public CardRequest() {
		super();
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
   
}
