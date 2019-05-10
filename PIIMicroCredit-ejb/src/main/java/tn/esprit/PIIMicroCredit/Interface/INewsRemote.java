package tn.esprit.PIIMicroCredit.Interface;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanPayment;
import tn.esprit.PIIMicroCredit.entity.LoanType;
import tn.esprit.PIIMicroCredit.entity.News;
import tn.esprit.PIIMicroCredit.entity.User;

@Remote
public interface INewsRemote {
	public int addNews(News n);
	public void removeNews(int id);
	public void updateNews(News n);
	public List<News> findNewsByTitle(String title) ;
	public List<News> findNewsByDate(String date) ;
	public List<News> findAllNews();
	public List<News> findNewsSorted();
	public List<News> findNewsSortedClient();
	public List<News> NewsStat();
	public List<News> favoriteNews(User u);
	public List<News> top5News();
	public News getNewsById(int id);
	public boolean findIfExist(String title);
	public List<Loan> findLoansRequests();
	public Date expirydate(Loan l);
	public LoanPayment FindAmountPaymentByLoan(Loan l);
	public List<LoanType> findLoanTypes();

}
