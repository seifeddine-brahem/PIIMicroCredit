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
@Table(name = "undercomment")
public class Undercomment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	private String comment;
	private Date datePost ;
	
	@ManyToOne
	private Comment CommentUC ;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public Comment getCommentUC() {
		return CommentUC;
	}

	public void setCommentUC(Comment commentUC) {
		CommentUC = commentUC;
	}

	public Undercomment(String comment, Date datePost, Comment commentUC) {
		super();
		this.comment = comment;
		this.datePost = datePost;
		CommentUC = commentUC;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Undercomment() {
		super();
	}





	
	
	
	

	
	
	
}
