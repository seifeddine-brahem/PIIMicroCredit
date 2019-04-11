package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    @Column(name = "publishing_date")
    private LocalDateTime publishing_date;
    @Column(name = "complaint_type")
    private AccountType complaint_type;
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getPublishing_date() {
		return publishing_date;
	}
	public void setPublishing_date(LocalDateTime publishing_date) {
		this.publishing_date = publishing_date;
	}
	public AccountType getComplaint_type() {
		return complaint_type;
	}
	public void setComplaint_type(AccountType complaint_type) {
		this.complaint_type = complaint_type;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
    
    

}
