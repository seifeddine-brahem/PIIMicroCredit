package tn.esprit.PIIMicroCredit.Interface;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.User;
@Remote
public interface ILoan {

	public int addLoan(Loan c);
	public void updateLoan(Loan c);
	public void acceptLoan(Loan c);
	public void declineLoan(Loan c);
	public void PreprocecingLoan(Loan c);
	public void removeLoan(int id);
	public Integer nbrOfAccounts(User c);
	public Integer nbrOfLoans(User c);
	public List<Loan> findAllLoans();
	public List<Loan> findLoanByOwner(User u);
	public float CalculerPrix (Date start_date, int nb_mois, float ctn, float taux);
}
