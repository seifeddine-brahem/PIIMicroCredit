package tn.esprit.PIIMicroCredit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comments {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;
		@Column(name = "description")
	    private String description;
	    @ManyToOne(fetch=FetchType.EAGER)
	    @JoinColumn(name = "news")
	    private News news;
	    @ManyToOne(fetch=FetchType.EAGER)
	    @JoinColumn(name = "user")
	    private User user;
	    
	    
	    
	    public Comments() {
			
		}
		public Comments(String description, News news, User user) {
			super();
			this.description = description;
			this.news = news;
			this.user = user;
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
		public News getNews() {
			return news;
		}
		public void setNews(News news) {
			this.news = news;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
}
