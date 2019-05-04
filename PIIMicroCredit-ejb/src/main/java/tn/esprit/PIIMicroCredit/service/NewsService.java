package tn.esprit.PIIMicroCredit.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.PIIMicroCredit.Interface.INewsRemote;
import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanPayment;
import tn.esprit.PIIMicroCredit.entity.LoanStatu;
import tn.esprit.PIIMicroCredit.entity.LoanType;
import tn.esprit.PIIMicroCredit.entity.News;


@Stateless
@LocalBean
public class NewsService implements INewsRemote {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addNews(News n) {
		em.persist(n);
		System.out.println("Out of addUser" + n.getId());
		return n.getId();
	}
	@Override
	public News getNewsById(int id) {
		News news = em.find(News.class, id);
		return news;
	}
	@Override
	public void removeNews(int id) {
		System.out.println("In removeUser: ");
		em.remove(em.find(News.class, id));
		System.out.println("Out of removeNews: ");

	}

	@Override
	public void updateNews(News n) {
		System.out.println("In updateUser: ");
		News news = em.find(News.class, n.getId());
		news.setTitle(n.getTitle());
		news.setPhoto(n.getPhoto());
		news.setDescription(n.getDescription());
		news.setDate_approved(n.getDate_approved());
		news.setDate_creation(n.getDate_creation());
		news.setApproved(n.getApproved());
		news.setScore(n.getScore());

	}

	@Override
	public List<News> findNewsByTitle(String title) {
		System.out.println("In findNewsById: ");
		List<News> news = em.createQuery("from News where approved =1 and title=:t", News.class).setParameter( "t", title ) .getResultList();
		System.out.println("Out of findNewsById: ");
		return news;
	}
	@Override
	public boolean findIfExist(String title){
		
		List<News> news = em.createQuery("from News where approved =0 and title=:t", News.class).setParameter( "t", title ) .getResultList();
		
		return news.isEmpty();
	}
	@Override
	public List<News> findAllNews() {
		System.out.println("In findAllNews: ");
		List<News> news = em.createQuery("from News", News.class).getResultList();
		
		System.out.println("Out of findAllNews: ");
		return news;
	}
	@Override
	public List<News> findNewsSorted(){
		

		List<News> news  = em.createQuery("from News order by date_creation desc, score desc",News.class).getResultList();
		 
		  System.out.println("Out of findAllNews: ");
		return news;
	}

	@Override
	public List<News> findNewsByDate(String date) {
		List<News> news = em.createQuery("from News where approved =1 and DATE_FORMAT(date_creation,'%Y-%m-%d')=:t", News.class).setParameter( "t",date ) .getResultList();

		System.out.println("Out of findNewsById: ");
		return news;
	}
	@Override
	public List<News> NewsStat(){
		

		List<News> news  = em.createQuery("from News where approved =1 order by score desc ", News.class).getResultList();
		 
		  System.out.println("Out of findAllNews: ");
		return news;
	}
	@Override
	public List<Loan> findLoansRequests() {
		
		String string2="processing";
		List<Loan> loans = em.createQuery("select l from Loan l where l.statu=:t or l.statu=:t2", Loan.class).setParameter("t",LoanStatu.valueOf("demand")).setParameter("t2",LoanStatu.valueOf("processing")).getResultList();
		
		return loans;
	}
	@Override
	public List<LoanType> findLoanTypes() {
		System.out.println("In findAllNews: ");
		List<LoanType> loans = em.createQuery("from LoanType", LoanType.class).getResultList();
		
		return loans;
	}
	@Override
	public LoanPayment FindAmountPaymentByLoan(Loan l){
		LoanPayment LP= em.createQuery("from LoanPayment where loan=:t",LoanPayment.class).setParameter("t", l).getSingleResult();
		return LP;
	}
	@Override
	public Date expirydate(Loan l){ 
	 double months=0;
	 double NYears=0;
	 Date expiryDate = l.getStart_date();
	 float Min=l.getLoanType().getMinValue();
	 float Max=l.getLoanType().getMaxValue();
	 double monthlyIR=l.getLoanType().getInterest()/12;
	 LoanPayment LP= FindAmountPaymentByLoan(l);
	 if(Min<l.getAmount()  && l.getAmount()<Max){
		 double PMT= LP.getAmount();
		 double numerator=1-(l.getAmount()*monthlyIR)/PMT;
		 months= - (Math.log (numerator) ) / Math.log (1 + monthlyIR);
		 NYears=(int) ((Math.ceil(months))/12);
		 System.out.println("NYears"+NYears);
		 l.getLoanType().setDuree((int) NYears);
		 int NBRYears=(int)(NYears);
		 expiryDate.setYear(expiryDate.getYear()+NBRYears);
		
	 }
	 else{
		 System.out.println("Not valid Ammount");
	 }
	 return expiryDate;
	}

}
