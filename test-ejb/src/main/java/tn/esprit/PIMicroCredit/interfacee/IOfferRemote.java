package tn.esprit.PIMicroCredit.interfacee;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Comment;
import tn.esprit.PIIMicroCredit.entity.Offer;
import tn.esprit.PIIMicroCredit.entity.Undercomment;
import tn.esprit.PIIMicroCredit.entity.User;
@Remote
public interface IOfferRemote {
	public int addOffer(Offer n);
	public void removeOffer(int id);
	public void updateOffer(Offer n);
	public Offer findOfferById(int id);
	public List<Offer> findAllOffer();
	public void editoffer(Offer o);
	public ArrayList<Offer> findAllOffers();
	public void addViewsbyId(Offer e);

	//public ArrayList<User> findtopUser();
	
	public int ajouterForum(Offer forum);
	public Offer findForumById (int idforum);
    public List<Offer> getAllForum () ;
    public long nbrComment () ;
    public long nbrCommentForm (int idforum) ;
    public long nbrCompanyForum (int idforum) ;
    public long nbrunnderCommentForm();
    /////////////////Comment/////////////////////////
    public List<Comment> getallCommentByForum (int idforum) ;
    public int addComment (Comment c) ;
    public Comment findCommentById (int idComment) ;
    public void updateComment(Comment c);
    
    //////////////////UnderCOmment///////////////////
    public Undercomment findUnderCommentById (long idComment) ;
    public void updateUnderComment(Undercomment c);
    public long addUnderComment (Undercomment uc );
    public List<Undercomment> getAllUnderCommentbyComment(int idcomment);
    public List<Undercomment> getAllUnderCommentbyForm(int idForm);
    ///////////////////////IA///////////////////////////
    
    public float NoteUnderComment(int idform) ;
    public float NoteComment(int idform) ;
   // public List<Produit> getRecommandation(int idForum) ;
	//List<Company> findCompanyBysynonyme(String r);
    public void ResponseComment(int idcomment);
	
	
}
