package tn.esprit.PIMicroCredit.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import tn.esprit.PIIMicroCredit.entity.Comment;
import tn.esprit.PIIMicroCredit.entity.Offer;
import tn.esprit.PIIMicroCredit.entity.Undercomment;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.entity.UserSubscribeOffer;
import tn.esprit.PIMicroCredit.interfacee.IOfferRemote;



/**
 * Entity implementation class for Entity: OfferService
 *
 */
@Stateless
@LocalBean

public class OfferService implements IOfferRemote {

	
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addOffer(Offer n) {
		em.persist(n);
		System.out.println("Out of addOfferr" + n.getId());
		return n.getId();
	}

	@Override
	public void removeOffer(int id) {
		System.out.println("In removeUser: ");
		em.remove(em.find(Offer.class, id));
		System.out.println("Out of removeNews: ");

	}

	@Override
	public void updateOffer(Offer n) {
		System.out.println("In updateUser: ");
		Offer offer = em.find(Offer.class, n.getId());
		offer.setTitle(n.getTitle());
		offer.setDescription(n.getDescription());
		offer.setStart_date(n.getStart_date());
		offer.setExpiry_date(n.getExpiry_date());
		offer.setPath(n.getPath());
	}

	@Override
	public Offer findOfferById(int id) {
		System.out.println("In findOfferById: ");
		Offer o = em.find(Offer.class, id);
		System.out.println("Out of findNewsById: ");
		return o;
	}

	@Override
	public List<Offer> findAllOffer() {
		System.out.println("In findAllNews: ");
		List<Offer> offers = em.createQuery("from Offer", Offer.class).getResultList();
		System.out.println("Out of findAllOffers: ");
		return offers;
	}
	@Override
	public void editoffer(Offer o){
		em.merge(o);
		
	}
	
	@Override
	public ArrayList<Offer> findAllOffers() {
		
		TypedQuery<Offer> A =  em.createQuery("select c from Offer c",Offer.class) ;
		ArrayList<Offer> O = (ArrayList<Offer>) A.getResultList() ;
		return O;
	
	}

	
	public void addViewsbyId(Offer e)
	{		
		em.merge(e);

	}
	
	
	///////////////////////////////////////////////
	
	@Override
	public int ajouterForum(Offer forum) {
	em.persist(forum);
		return forum.getId();
	}

	@Override
	public List<Offer> getAllForum() {
		List<Offer> Prods= em.createQuery("from Offer", Offer.class).getResultList();
		return Prods ;
	}

	@Override
	public long nbrCommentForm(int idforum) {
		Offer f = em.find(Offer.class, idforum) ;
		Query q = em.createQuery("select Count(c)  from Comment c  WHERE c.forumC=:f ") ;
		q.setParameter("f", f);
	    
		return (long) q.getSingleResult() ;
	
	}
	
	@Override
	public long nbrunnderCommentForm(){
		
		Query q = em.createQuery("select Count(c)  from underComment c ") ;
	
		return (long) q.getSingleResult() ;
		
	}


	@Override
	public long nbrComment() {
		Query q = em.createQuery("select Count(c)  from Comment c") ;
		return (long) q.getSingleResult() ;
	}

	@Override
	public List<Comment> getallCommentByForum(int idforum) {
		Offer f = em.find(Offer.class, idforum) ;
		TypedQuery<Comment> q = em.createQuery("select c from Comment c WHERE c.forumC=:f" , Comment.class ) ;
		q.setParameter("f", f);
		List <Comment> comments = q.getResultList() ;
		return comments;
	}

	@Override
	public List<Undercomment> getAllUnderCommentbyComment(int idcomment) {
		Comment c = em.find(Comment.class, idcomment) ;
		TypedQuery<Undercomment> q = em.createQuery("select uc from Undercomment uc WHERE uc.CommentUC=:c" , Undercomment.class ) ;
		q.setParameter("c", c);
		List <Undercomment> UnderComments = q.getResultList() ;
		
		return UnderComments;
	}

	@Override
	public int addComment(Comment c ) {
		
		
		em.persist(c);
		ResponseComment(c.getId()) ;


		return c.getId() ;
	}

	@Override
	public long addUnderComment(Undercomment uc) {
	
		em.persist(uc);
		return uc.getId() ;
	}

	@Override
	public Comment findCommentById(int idComment) {
		Comment c = em.find(Comment.class, idComment) ;
		return c;
	}

	@Override
	public void updateComment(Comment c) {
		em.merge(c) ;
		
	}

	@Override
	public Undercomment findUnderCommentById(long idComment) {
		Undercomment c = em.find(Undercomment.class, idComment) ;
		return c;
	}

	@Override
	public void updateUnderComment(Undercomment c) {
		em.merge(c) ;
		
	}

	@Override
	public List<Undercomment> getAllUnderCommentbyForm(int idforum) {
		Offer f = em.find(Offer.class, idforum) ;
        List<Comment> comments = getallCommentByForum(idforum);
        List<Undercomment> undercomments = new ArrayList<>() ;
        for (Comment c : comments){
        	undercomments.addAll(getAllUnderCommentbyComment(c.getId())) ;
        }
		return undercomments;
	}

	
	@Override
	public float NoteUnderComment(int idform) {
		Offer f = em.find(Offer.class, idform) ;
		List<Undercomment> ucomments =   getAllUnderCommentbyForm(idform);
		//List<Word> words =   getAllWord();
		//System.out.println(words.toString());
		   int x = 0 ;
		   int nbr = 0 ;
		   for (Undercomment ucc : ucomments ) {
			   Pattern p = Pattern.compile("[a-zA-Z]+");
		         
		        Matcher m1 = p.matcher(ucc.getComment());
		        
		   }
		
	
		 
				  if (x == 0){
					  return 0 ;
				  } else{
					  return (x/nbr);
				  }
			  
	}

	@Override
	public float NoteComment(int idform) {
		Offer f = em.find(Offer.class, idform) ;

		List<Comment> comments =   getallCommentByForum(idform);
		   int x = 0 ;
		   int nbr = 0 ;
		   for (Comment c : comments ) {
			   Pattern p = Pattern.compile("[a-zA-Z]+");
		        Matcher m1 = p.matcher(c.getComment());
		        
	} 
		   if (x==0){
			   return 0 ;
		   }
			   return (x/nbr);
	}
                                                    
                                                                          
	@Override                                                             
	public Offer findForumById(int idforum) {                             
		Offer f = em.find(Offer.class, idforum)    ;                       
                                                                          
		return f;                                                         
	}

	


	


	@Override
	public long nbrCompanyForum(int idforum) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void ResponseComment(int idcomment) {
		Comment comment = em.find(Comment.class, idcomment);   
		
		Pattern p = Pattern.compile("[a-zA-Z]+");
		
			
			 Matcher m1 = p.matcher(comment.getComment());
			 while (m1.find()) {
				 
				 if (m1.group().equals("products")){
					 Undercomment uc = new Undercomment("check out other product in Operator throught this link"
					 		+ "                                                                                                    "
					 		+ "http://localhost:18080/test-web/Topic.jsf",new Date(),comment);
					long x = addUnderComment(uc);
					 Undercomment uccc = em.find(Undercomment.class, x);   
				//	 Entities.User f = (Entities.User) em.find(Entities.User.class, (long)36);   
					 //uccc.setCompanyUC(f);
					 em.merge(uccc) ;
				   
				 }
			 }
		}
	
	
	
	
   
}
