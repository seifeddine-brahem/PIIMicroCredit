package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;
import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanPayment;
import tn.esprit.PIIMicroCredit.entity.User;
@Remote
public interface ILoanPayment {

	public LoanPayment addLoanPayment(LoanPayment c);
	public void updateLoanPayment(LoanPayment c);
	public void removeLoanPayment(int id);
	public LoanPayment getPayment(int id);
	public List<LoanPayment> findAllLoansPayment();
	public List<LoanPayment> findLoanPaymentByOwner(User u);
}
