package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Notification")
public class Notification implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "opened")
    private Boolean opened;
    @ManyToOne
    @JoinColumn(name = "depositorComplaint")
    private User depositorComplaint;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getOpened() {
		return opened;
	}

	public void setOpened(Boolean opened) {
		this.opened = opened;
	}

	public User getDepositorComplaint() {
		return depositorComplaint;
	}

	public void setDepositorComplaint(User depositorComplaint) {
		this.depositorComplaint = depositorComplaint;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	@OneToOne
    @JoinColumn(name = "complaint")
    private Complaint complaint;
    
	public Notification() {
		depositorComplaint=new User();
		complaint= new Complaint();
	}

	public Notification(Integer id, Boolean opened, User depositorComplaint, Complaint complaint) {
		this.id = id;
		this.opened = opened;
		this.depositorComplaint = depositorComplaint;
		this.complaint = complaint;
	}
    



}
