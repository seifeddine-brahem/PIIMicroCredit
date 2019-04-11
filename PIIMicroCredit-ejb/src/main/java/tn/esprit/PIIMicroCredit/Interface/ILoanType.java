package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;
import javax.ejb.Remote;
import tn.esprit.PIIMicroCredit.entity.LoanType;
import tn.esprit.PIIMicroCredit.entity.User;

@Remote
public interface ILoanType {

	public LoanType addLoanType(LoanType c);
	public void updateLoanType(LoanType c);
	public void removeLoanType(int id);
	public LoanType getLoan(int id);
	public List<LoanType> findAllLoansTypes();
}
