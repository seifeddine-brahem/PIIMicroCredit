package tn.esprit.test.managedbeans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.Comment;
import tn.esprit.PIIMicroCredit.entity.Offer;
import tn.esprit.PIIMicroCredit.entity.Undercomment;
import tn.esprit.PIMicroCredit.service.OfferService;



@ManagedBean(name = "offerBean") 
@SessionScoped
public class Offerbean implements Serializable {

@EJB
OfferService offersService;
private static final long serialVersionUID = 1L;

private int id;
private String title;
private String description;  
private Date expired_date;
private Date start_date;
private String path; 
private String comment; 
private String forum;

public String getForum() {
	return forum;
}


public void setForum(String forum) {
	this.forum = forum;
}


private Comment commentuc;

private List<Offer> items;
public Comment getCommentuc() {
	return commentuc;
}


public void setCommentuc(Comment commentuc) {
	this.commentuc = commentuc;
}


private String undercomment; 


private List<Offer> offers;
private Offer f = new Offer() ; 





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


public Date getExpired_date() {
	return expired_date;
}


public void setExpired_date(Date expired_date) {
	this.expired_date = expired_date;
}


public Date getStart_date() {
	return start_date;
}


public void setStart_date(Date start_date) {
	this.start_date = start_date;
}


public String getPath() {
	return path;
}


public void setPath(String path) {
	this.path = path;
}


public Offerbean() {
	super();
}





public List<Offer> getOffers() {
	 offers = offersService.findAllOffers(); 
	return offers;
	} 


public Offer findofferbyid(int newsId)
{
	Offer neww = offersService.findOfferById(newsId) ; 
	neww.setViews(neww.getViews()+1);
	offersService.addViewsbyId(neww);
	
	return neww;
			
}

public Offer findofferbyid1(int newsId)
{
	Offer neww = offersService.findOfferById(newsId) ; 


	
	return neww;
			
}

public String getComment() {
	return comment;
}


public void setComment(String comment) {
	this.comment = comment;
}


public String getUndercomment() {
	return undercomment;
}


public void setUndercomment(String undercomment) {
	this.undercomment = undercomment;
}





public List<Offer> getItems() {
	return items;
}


public void setItems(List<Offer> items) {
	this.items = items;
}


public Offer getF() {
	return f;
}


public void setF(Offer f) {
	this.f = f;
}


public void setOffers(List<Offer> offers) {
	this.offers = offers;
}


public void addRating(int newsId)
{
	Offer neww = offersService.findOfferById(newsId) ; 
	neww.setLikes(neww.getLikes()+1);
	offersService.addViewsbyId(neww);
			
}

public List<Offer> getMostViewedOffers() {
	List<Offer> tocs = offersService.findAllOffers();
	tocs.sort(new Comparator<Offer>() {
		@Override
		public int compare(Offer o1, Offer o2) {

			return o2.getViews() - o1.getViews();
		}
	});
	List<Offer> tocfiltred = new ArrayList<>();
	tocfiltred.add(tocs.get(0));
	tocfiltred.add(tocs.get(1));
	tocfiltred.add(tocs.get(2));
	
	

	return tocfiltred;
}

public long nbrComment(int idforum) {
	return	offersService.nbrCommentForm(idforum);	

}
public long totalComment() {
	return	offersService.nbrComment();	

}
public List<Comment> getCommentsByForum(int idforum){
	return offersService.getallCommentByForum(idforum);	
}
public List<Undercomment> getunderCommentByComment(int idcomment) {
	return offersService.getAllUnderCommentbyComment(idcomment);
}


public void doComment (){
	Comment c= new Comment() ;
	c.setComment(this.comment);
	Date d = new Date();
	c.setDatePost(d);
	if (!this.comment.equals("")){
	int x = offersService.addComment(c);
	Comment c1= new Comment() ;
	c1 =offersService.findCommentById(x);
	c1.setForumC(this.f);
	offersService.updateComment(c1);
	}
	this.comment = null ;

}
public void doUnderComment (int c){
	
	Comment comment1=	offersService.findCommentById(c);
	Undercomment c2= new Undercomment() ;
	c2.setComment(this.undercomment);
	c2.setDatePost(new Date());
	c2.setCommentUC(comment1);
	//c2.setCompanyUC((Company)identity.getUser());
	if (!this.undercomment.equals("")){
		long x = offersService.addUnderComment(c2);
	}
	
	this.undercomment = null ;

}

public OfferService getOffersService() {
	return offersService;
}


public void setOffersService(OfferService offersService) {
	this.offersService = offersService;
}
public List<Offer> ForumList() {
	 items =	offersService.getAllForum();	
	System.out.println("Ahmed");
	return items ;
}

public void addComment(int newsId) {
	
	Offer of=	offersService.findOfferById(newsId);
	Comment c2= new Comment() ;
	c2.setComment(this.comment);
	c2.setDatePost(new Date());
	c2.setForumC(of);
	//c2.setCompanyUC((Company)identity.getUser());
	if (!this.comment.equals("")){
		long x = offersService.addComment(c2);
	}
	
	this.comment = null ;

	
}


}