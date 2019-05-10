package tn.esprit.managedBean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.News;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.service.NewsService;
import tn.esprit.PIIMicroCredit.service.UserService;


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
	private Date dateApproved;
	private int score;
	private int nbrClick;
	private int nbrLike;
	private int approved;
	private Integer newsIdToBeUpdated;
	private List <News> news= new ArrayList<>();
	private String test="jjjjjjjjjjjjjjjj";
	private News nw;
	
	@EJB
	NewsService newservice;
	@EJB
	UserService userservice;
//	@EJB
//	NewsService ns;	
//	@EJB
//	NewsService ns;
//	
	
	public List<News> showNewsClient() {
		
		System.out.println("+******///////////////////++"+news.size());
		for(News n : newservice.findNewsSortedClient())
			
		{
		
		news.add(n);	
		}
		
		return news;
		}

	public List<News> yourFavoriteNews() {
		
		User u= userservice.FindUserById(1);
		
		return newservice.favoriteNews(u);
		}
	
		public List<News> displayTop5News() {
		
		return newservice.top5News();
		}
		
		
		public List<News> slideShowClient() {
		List<News>slides= new ArrayList<>();
		System.out.println("+******/date/////++"+LocalDate.now() );
		System.out.println("+******/month////++"+(LocalDate.now().getMonthValue()));
		System.out.println("+******/year////++"+(LocalDate.now().getYear()));
		System.out.println("+******/day////++"+(LocalDate.now().getDayOfMonth()));
		for(News n : newservice.findNewsSortedClient())
			
		{
			
			System.out.println("+******/difffffffffffff////++"+(LocalDate.now().getMonthValue()-n.getDate_creation().getMonth()) );
			System.out.println("+******/newsmonth////++"+(n.getDate_creation().getMonth()));
			System.out.println("+******/dnewsyears////++"+(n.getDate_creation().getYear()) );
			System.out.println("+******/dnewsday////++"+((LocalDate.now().getYear()) == (n.getDate_creation().getYear()+1900) &&(LocalDate.now().getMonthValue())==(n.getDate_creation().getMonth()+1)&&(LocalDate.now().getDayOfMonth())-(n.getDate_creation().getDay())<7 ));
		if((LocalDate.now().getYear()) == (n.getDate_creation().getYear()+1900) &&(LocalDate.now().getMonthValue())==(n.getDate_creation().getMonth()+1)&&(LocalDate.now().getDayOfMonth())-(n.getDate_creation().getDay())<7 )
		slides.add(n);	
		}
		
		return slides;
		}
		public void displayTop(News news){
			this.setDateCreation(news.getDate_creation());
			this.setDescription(news.getDescription());
			this.setPhoto(news.getPhoto());
			this.setScore(news.getScore());
			this.setTitle(news.getTitle());
			this.setApproved(news.getApproved());
			this.setDateApproved(news.getDate_approved());
			this.setNbrClick(news.getNbrClick());
			this.setNbrLike(news.getNbrLike());
			this.setNewsIdToBeUpdated(news.getId());
			
		}
	public String displayNews(int id)
	{   System.out.println("Lalalalalaa");
		String navigateTo = "null";
		nw=newservice.getNewsById(id);
		if(nw!=null){
			nw.setNbrClick(nw.getNbrClick()+1);
			nw.setApproved(nw.getApproved());
			nw.setDate_approved(nw.getDate_approved());
			nw.setDate_creation(nw.getDate_creation());
			nw.setDescription(nw.getDescription());
			nw.setPhoto(nw.getPhoto());
			nw.setTitle(nw.getTitle());
			nw.setScore(nw.getScore());
			nw.setNbrLike(nw.getNbrLike());
			newservice.updateNews(nw);
			navigateTo = "/xhtml/NewsDetail?faces-redirect=true";
		}
		System.out.println("Lalalalalaa/////////"+nw.getTitle());
		System.out.println("NbrClick///"+nw.getNbrClick());	
		return navigateTo; 		
	
	}
	public void addToFavorite(News n){
		n.setNbrLike(n.getNbrLike()+1);
		newservice.updateNews(n);
		
	}
	
	public Date getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}

	public int getNbrClick() {
		return nbrClick;
	}

	public void setNbrClick(int nbrClick) {
		this.nbrClick = nbrClick;
	}

	public int getNbrLike() {
		return nbrLike;
	}

	public void setNbrLike(int nbrLike) {
		this.nbrLike = nbrLike;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public Integer getNewsIdToBeUpdated() {
		return newsIdToBeUpdated;
	}

	public void setNewsIdToBeUpdated(Integer newsIdToBeUpdated) {
		this.newsIdToBeUpdated = newsIdToBeUpdated;
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
