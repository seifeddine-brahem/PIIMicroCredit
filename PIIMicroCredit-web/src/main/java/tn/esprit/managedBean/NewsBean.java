package tn.esprit.managedBean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

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
	private List <News> stats= new ArrayList<>();
	private String test="jjjjjjjjjjjjjjjj";
	private News nw;
	private PieChartModel pieModel1;
	private LineChartModel animatedModel1;
	private BarChartModel animatedModel2;
	@EJB
	NewsService newservice;
	@EJB
	UserService userservice;
//	@EJB
//	NewsService ns;	
//	@EJB
//	NewsService ns;
//	
	public void listar(){
		
		stats=newservice.NewsStat();
		graphicar();
	}
	public void graphicar(){
		pieModel1= new PieChartModel();
		animatedModel1= new LineChartModel();
		animatedModel2= new BarChartModel();
		for(News n: newservice.NewsStat())
		{
			pieModel1.set(n.getTitle(),n.getNbrLike() );
		}
		animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Line Chart");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
        animatedModel1.setShowPointLabels(true);
        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        
        yAxis.setMin(0);
        yAxis.setMax(40);
       
		pieModel1.setTitle("Teeeeeeeeeeeessst");
		pieModel1.setLegendPosition("e");
		pieModel1.setFill(true);
		pieModel1.setShowDataLabels(true);
		
		
	}
	 private LineChartModel initLinearModel() {
	        LineChartModel model = new LineChartModel();
	 
	        LineChartSeries series1 = new LineChartSeries();
	        LineChartSeries series2 = new LineChartSeries();
	        series1.setLabel("Series 1");
	        series2.setLabel("Series 2");
	   	 
	        for(News n : newservice.findNewsSortedClient()){
	        	series1.set(n.getTitle(), n.getNbrLike());
	        	series2.set(n.getNbrClick(), n.getComments().size());
	        }
	    
	     
	 
	        model.addSeries(series1);
	        model.addSeries(series2);
	 
	        return model;
	    }
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
	
		public News displayTop1News() {
			
		return newservice.mostViewNews();
			}
		public List<News> displayPopularNews(){
			return newservice.popularNews();
		}
		public List<News> displayTop5News() {
		System.out.println("+++----sizeTop5"+newservice.top5News().size());
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
			System.out.println("+******/newsdaaaay////++"+(n.getDate_creation().getDay()));
			System.out.println("+******/dnewsyears////++"+(n.getDate_creation().getYear()) );
			System.out.println("+******/dnewsday////++"+((LocalDate.now().getYear()) == (n.getDate_creation().getYear()+1900) &&(LocalDate.now().getMonthValue())==(n.getDate_creation().getMonth()+1)&&(LocalDate.now().getDayOfMonth())-(n.getDate_creation().getDay()+7)<7 ));
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
	
	
	public LineChartModel getAnimatedModel1() {
		return animatedModel1;
	}
	public void setAnimatedModel1(LineChartModel animatedModel1) {
		this.animatedModel1 = animatedModel1;
	}
	public BarChartModel getAnimatedModel2() {
		return animatedModel2;
	}
	public void setAnimatedModel2(BarChartModel animatedModel2) {
		this.animatedModel2 = animatedModel2;
	}
	public List<News> getStats() {
		return stats;
	}
	public void setStats(List<News> stats) {
		this.stats = stats;
	}
	public PieChartModel getPieModel1() {
		return pieModel1;
	}
	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
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
