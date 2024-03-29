package tn.esprit.PIIMicroCredit.service;

import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.PIIMicroCredit.Interface.ILoan;
import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanStatu;
import tn.esprit.PIIMicroCredit.entity.User;

@Stateless
@LocalBean
public class LoanService implements ILoan {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addLoan(Loan c) {
		System.out.println("================================== In addLoan ==================================");
		c.setStatu(LoanStatu.demand);
		em.persist(c);
		System.out.println("================================== Out of addLoan :" + c.getId()+" ==================================");
		return c.getId();
	}

	@Override
	public void updateLoan(Loan c) {
		System.out.println("================================== In updateLoans ==================================");
		Loan cmp = em.find(Loan.class, c.getId());
		cmp.setAmount(c.getAmount());
		cmp.setPayment_type(c.getPayment_type());
		cmp.setLoanType(c.getLoanType());
		cmp.setRemuneration(c.getRemuneration());
		cmp.setFolder(c.getFolder());
		System.out.println("================================== Out updateLoans ==================================");	
	}

	@Override
	public void removeLoan(int id) {
		System.out.println("================================== In removeLoan ==================================");
		em.remove(em.find(Loan.class, id));
		System.out.println("================================== Out of removeLoan ==================================");		
	}

	@Override
	public List<Loan> findLoanByOwner(User u) {
		System.out.println("================================== In findLoanByOwner(User): ");
		List<Loan> c = em.createQuery("select COUNT(l) from Loan l where l.account.owner:= u", Loan.class).getResultList();
		System.out.println("================================== Out of findLoantByOwner ==================================");
		return c;	}

	@Override
	public List<Loan> findAllLoans() {
		System.out.println("================================== In findAllLoans ==================================");
		List<Loan> complaints = em.createQuery("select c from Loan c", Loan.class).getResultList();
		System.out.println("================================== Out of findAllLoans ==================================");
		return complaints;
	}

	@Override
	public void acceptLoan(Loan c) {
		System.out.println("================================== In acceptLoan ==================================");
		Loan cmp = em.find(Loan.class, c.getId());
		cmp.setStatu(LoanStatu.accepted);;
		System.out.println("================================== Out acceptLoan ==================================");

		
	}

	@Override
	public void declineLoan(Loan c) {
		System.out.println("================================== In declineLoan ==================================");
		Loan cmp = em.find(Loan.class, c.getId());
		cmp.setStatu(LoanStatu.refused);;
		System.out.println("================================== Out declineLoan ==================================");

		
	}

	@Override
	public void PreprocecingLoan(Loan c) {
		System.out.println("================================== In PreprocecingLoan ==================================");
		Loan cmp = em.find(Loan.class, c.getId());
		cmp.setStatu(LoanStatu.processing);;
		System.out.println("================================== Out PreprocecingLoan ==================================");

		
	}

	@Override
	public Integer nbrOfAccounts(User u) {
		System.out.println("================================== In nbrOfAccounts(User): ");
		Integer c = em.createQuery("select COUNT(c)  from Account c where c.owner:= u",Integer.class).getSingleResult();
		System.out.println("================================== Out of nbrOfAccounts ==================================");
		return c;	
	}

	@Override
	public Integer nbrOfLoans(User u) {
		System.out.println("================================== In nbrOfLoans(User): ");
		Integer c = em.createQuery("select COUNT(c) from Account c where c.owner:= u",Integer.class).getSingleResult();
		System.out.println("================================== Out of nbrOfLoans ==================================");
		return c;	
	}
	@Override
	public float CalculerPrix (Date start_date, int nb_mois, float ctn, float taux) {
        float x=0;
        int i;
        System.out.println("nb mois : "+nb_mois+" ctn : "+ctn+" taux :"+taux);
        for(i=1;i<=nb_mois;i++)
        {
        	x=ctn*taux*nb_mois/12;
        	ctn=ctn+x;
        	System.err.println("new x : "+x);
        	System.out.println("new ctn : "+ctn);
        	
        }
        return x;
        }

	
	
	
	
	
	
	
	
}
