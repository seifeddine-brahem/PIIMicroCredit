/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author elbrh
 */

@Entity
@Table(name = "News")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;
    @Column(name = "photo")
    private String photo;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;
    @Column(name = "approved")
    private int approved;
    @Column(name = "date_approved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_approved;
    @Column(name = "score")
    private int score;
    public News() {
    }
    
    

    public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }



	public Date getDate_creation() {
		return date_creation;
	}



	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}



	public Date getDate_approved() {
		return date_approved;
	}



	public void setDate_approved(Date date_approved) {
		this.date_approved = date_approved;
	}



	public News(String description, String title, String photo, Date date_creation ,int approved) {
		super();
		this.description = description;
		this.title = title;
		this.photo = photo;
		this.date_creation = date_creation;
		this.approved = approved;
	}



	public News(String description, String title,  Date date_creation, int approved, int score) {
		super();
		this.description = description;
		this.title = title;
		//this.photo = photo;
		this.date_creation = date_creation;
		this.approved = approved;
		this.score = score;
	}

   
    
    
    

    
}
