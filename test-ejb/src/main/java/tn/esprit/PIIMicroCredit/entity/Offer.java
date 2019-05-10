/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author elbrh
 */
@Entity
@Table(name = "Offer")
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "expiry_date")
    private Date expiry_date;
    @Column(name = "path")
    private String path;
    @Column(name = "views")
    private int views;
   
    @Column(name = "likes")
    private int likes;
    
    @OneToMany (mappedBy="forumC" , cascade= CascadeType.ALL)
	private List <Comment> comment;    
    

  

	public int getId() {
		return id;
	}




	public void setId(int id) {
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




	public Date getStart_date() {
		return start_date;
	}




	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}




	public Date getExpiry_date() {
		return expiry_date;
	}




	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}




	public String getPath() {
		return path;
	}




	public void setPath(String path) {
		this.path = path;
	}




	public int getViews() {
		return views;
	}




	public void setViews(int views) {
		this.views = views;
	}




	public int getLikes() {
		return likes;
	}




	public void setLikes(int likes) {
		this.likes = likes;
	}




	public List<Comment> getComment() {
		return comment;
	}




	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}




	public Offer() {
		super();
	}

	
    
	
	
    

    
}
