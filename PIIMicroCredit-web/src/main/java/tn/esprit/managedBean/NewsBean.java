package tn.esprit.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.News;
import tn.esprit.PIIMicroCredit.service.NewsService;


@ManagedBean
@SessionScoped
public class NewsBean implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String description;
	private String title;
	private String photo;
	private Date dateCreation;
	private int score;
	private List <News> news= new ArrayList<>();
	private String test="jjjjjjjjjjjjjjjj";
	private News nw;
	
	@EJB
	NewsService newservice;
	
//	@EJB
//	NewsService ns;
//	@EJB
//	NewsService ns;
//	
	
	public List<News> showNewsClient() {
		System.out.println("+******///////////////////++"+news.size());
		for(News n : newservice.findNewsSorted())
			
		{
			if (n.getApproved()==1)
		news.add(n);	
		}
		
		return news;
		}
	public String displayNews(int id)
	{   System.out.println("Lalalalalaa");
		String navigateTo = "null";
		nw=newservice.getNewsById(id);
		if(nw!=null){
			navigateTo = "/xhtml/NewsDetail?faces-redirect=true";
		}
		System.out.println("Lalalalalaa/////////"+nw.getTitle());
		
		return navigateTo; 		
		/*this.setDescription(n.getDescription());
	this.setDateCreation(n.getDate_creation());
	this.setScore(n.getScore());
	this.setPhoto(n.getPhoto());
	this.setTitle(n.getTitle());*/
	}
	public News getNw() {
		return nw;
	}
	public void setNw(News nw) {
		this.nw = nw;
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
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	} 
	
	
	
	
}
