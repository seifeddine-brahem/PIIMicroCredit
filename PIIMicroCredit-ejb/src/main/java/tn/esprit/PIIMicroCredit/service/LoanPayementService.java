package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javafx.util.converter.LocalDateTimeStringConverter;
import tn.esprit.PIIMicroCredit.Interface.IComplaint;
import tn.esprit.PIIMicroCredit.Interface.ILoan;
import tn.esprit.PIIMicroCredit.Interface.ILoanPayment;
import tn.esprit.PIIMicroCredit.entity.Complaint;
import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanPayment;
import tn.esprit.PIIMicroCredit.entity.News;
import tn.esprit.PIIMicroCredit.entity.User;

@Stateless
@LocalBean
public class LoanPayementService implements ILoanPayment {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public LoanPayment addLoanPayment(LoanPayment lp) {
		System.err.println("================================== In addLoanPayment ==================================");
		em.persist(lp);
		System.err.println("================================== Out of addLoanPayment :" + lp.getId()+" ==================================");
		return lp;
	}

	@Override
	public void updateLoanPayment(LoanPayment c) {
		System.err.println("================================== In updateLoansPayment ==================================");
		LoanPayment cmp = em.find(LoanPayment.class, c.getId());
		//cmp.setPayment_date(new Date);
		System.err.println("================================== Out updateLoansPayment ==================================");

		
	}

	@Override
	public void removeLoanPayment(int id) {
		System.err.println("================================== In removeLoanPayment ==================================");
		em.remove(em.find(LoanPayment.class, id));
		System.err.println("================================== Out of removeLoanPayment ==================================");		
	}
	@Override
	public List<LoanPayment> findLoanPaymentByOwner(User u) {
		System.err.println("================================== In findLoanPaymentByOwner(User): ");
		List<LoanPayment> c = em.createQuery("select c from LoanPayment c where c.owner:= u", LoanPayment.class).getResultList();
		System.err.println("================================== Out of findLoantPaymentByOwner ==================================");
		return c;		
	}

	@Override
	public List<LoanPayment> findAllLoansPayment() {
		System.err.println("================================== In findAllLoansPayment ==================================");
		List<LoanPayment> loadpayment = em.createQuery("select c from LoanPayment c", LoanPayment.class).getResultList();
		System.err.println("================================== Out of findAllLoansPayment ==================================");
		return loadpayment;
	}

	@Override
	public LoanPayment getPayment(int id) {
		System.err.println("================================== In findLoanPaymentByOwner ======================================");
		LoanPayment loadpayment = em.createQuery("select c from LoanPayment c where c.id:= id", LoanPayment.class).getSingleResult();
		System.err.println("================================== Out of findLoantPaymentByOwner ==================================");
		return loadpayment;
	}
	
	public List<LoanPayment> Annuites() {
		System.err.println("================================== In findAllLoansPayment ==================================");
		List<LoanPayment> loadpayment = em.createQuery("select c from LoanPayment c", LoanPayment.class).getResultList();
		System.err.println("================================== Out of findAllLoansPayment ==================================");
		return loadpayment;
	}
	
	
}
