package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String comment;
	private Date datePost ;
	
	@ManyToOne
	private Offer forumC ;

	@OneToMany (mappedBy="CommentUC" , cascade= CascadeType.ALL)
	private List <Undercomment> undercomment;
	
	
	
	
	
	

	
	/* Association */
	
	 
	
	
	
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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
	



	public List<Undercomment> getUndercomment() {
		return undercomment;
	}


	public void setUndercomment(List<Undercomment> undercomment) {
		this.undercomment = undercomment;
	}


	public Offer getForumC() {
		return forumC;
	}


	public void setForumC(Offer forumC) {
		this.forumC = forumC;
	}


	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", datePost=" + datePost + "]";
	}


	public Comment() {
	}


	public Comment(String comment, Date datePost) {
		this.comment = comment;
		this.datePost = datePost;
	}
	
	/***************/
	
	
}
