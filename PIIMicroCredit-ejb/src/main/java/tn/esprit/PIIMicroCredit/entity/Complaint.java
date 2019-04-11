package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Complaint")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "decription")
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "publishing_date")
    private Date publishing_date;
    @Column(name = "complaint_type")
    private ComplaintType complaint_type;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Complaint() {
	}
	public Complaint(String title, String description, Date publishing_date, ComplaintType complaint_type, User owner) {
	System.out.println("ezrze");
		this.title = title;
		this.description = description;
		this.publishing_date = publishing_date;
		this.complaint_type = complaint_type;
		this.owner = owner;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublishing_date() {
		return publishing_date;
	}
	public void setPublishing_date(Date publishing_date) {
		this.publishing_date = publishing_date;
	}
	public ComplaintType getComplaint_type() {
		return complaint_type;
	}
	public void setComplaint_type(ComplaintType complaint_type) {
		this.complaint_type = complaint_type;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

}
