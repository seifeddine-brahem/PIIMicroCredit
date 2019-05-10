package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.PIIMicroCredit.Interface.ILoanType;
import tn.esprit.PIIMicroCredit.entity.LoanType;

@Stateless
@LocalBean
public class LoanTypeService implements ILoanType {
	
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public LoanType addLoanType(LoanType lt) {
		System.out.println("================================== In addLoanType ==================================");
		em.persist(lt);
		System.out.println("================================== Out of addLoanType :" + lt.getId()+" ==================================");
		return lt;
	}

	@Override
	public void updateLoanType(LoanType c) {
		System.out.println("================================== In updateLoansType ======================================");
		LoanType loan = em.find(LoanType.class, c.getId());
		loan.setDescription(c.getDescription());
		loan.setDuree(c.getDuree());
		loan.setInterest(c.getInterest());
		loan.setMinValue(c.getMinValue());
		loan.setMaxValue(c.getMaxValue());
		loan.setName(c.getName());
		System.out.println("================================== Out updateLoansType ======================================");

		
	}

	@Override
	public void removeLoanType(int id) {
		System.out.println("================================== In removeLoanType =====================================");
		em.remove(em.find(LoanType.class, id));
		System.out.println("================================== Out of removeLoanType ==================================");		
	}



	@Override
	public List<LoanType> findAllLoansTypes() {
		System.out.println("================================== In findAllLoansType ======================================");
		List<LoanType> complaints = em.createQuery("select c from LoanType c", LoanType.class).getResultList();
		System.out.println("================================== Out of findAllLoansType ==================================");
		return complaints;
	}

	@Override
	public LoanType getLoan(int id) {
		System.err.println("================================== In findLoanTypeById");
		LoanType loadpayment = em.find(LoanType.class, id);
		System.err.println("================================== Out of findLoanTypeById ==================================");
		return loadpayment;
	}
}
