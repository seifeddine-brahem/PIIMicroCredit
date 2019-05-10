package tn.esprit.ManagedBean;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanPayment;
import tn.esprit.PIIMicroCredit.service.LoanPayementService;
import tn.esprit.PIIMicroCredit.service.LoanService;

@SessionScoped
@ManagedBean
public class AnnuitesBean implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private double amortissement;
	private float montant;
	private double taux;
	private float annuite;
	private double taux_interet;
	private int nbre_annuites;
	private double valeur_nette;
	private double emprunt;
	private Date date_deb;
	private Date date_fin;
	private String year;
	

	// duree en annees
	private int duree;
	private Loan loan;
	@EJB
	LoanPayementService lp;
	@EJB
	LoanService ls;

	
	public double getAmortissement() {
		return amortissement;
	}

	public void setAmortissement(double amortissement) {
		this.amortissement = amortissement;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getAnnuite() {
		return annuite;
	}

	public void setAnnuite(float annuite) {
		this.annuite = annuite;
	}

	public double getTaux_interet() {
		return taux_interet;
	}

	public void setTaux_interet(double taux_interet) {
		this.taux_interet = taux_interet;
	}

	public int getNbre_annuites() {
		return nbre_annuites;
	}

	public void setNbre_annuites(int nbre_annuites) {
		this.nbre_annuites = nbre_annuites;
	}

	public double getValeur_nette() {
		return valeur_nette;
	}

	public void setValeur_nette(double valeur_nette) {
		this.valeur_nette = valeur_nette;
	}

	public double getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(double emprunt) {
		this.emprunt = emprunt;
	}

	public Date getDate_deb() {
		return date_deb;
	}

	public void setDate_deb(Date date_deb) {
		this.date_deb = date_deb;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public LoanPayementService getLp() {
		return lp;
	}

	public void setLp(LoanPayementService lp) {
		this.lp = lp;
	}

	public AnnuitesBean() {
		super();

	}

	public LoanService getLs() {
		return ls;
	}

	public void setLs(LoanService ls) {
		this.ls = ls;
	}
    
	public List<LoanPayment> AnnuitesDegressives() {
		System.out.println("wouhouw");
		Loan l = new Loan();
		int s=1;
		///zedtha
		
        //taux_interet=0.05;
		//montant = 20000;
		//nbre_annuites = 4;
		date_deb = Date.from(Instant.now());
		date_fin = new Date(2021, 6, 19);
		//nbre_annuites = date_fin.getYear() - date_deb.getYear();
		List <LoanPayment> list = new ArrayList <LoanPayment>();

		amortissement = montant / nbre_annuites;
		
		for (int i=nbre_annuites; i> 0; i--) {
			
			
			taux = montant * taux_interet;
			annuite = (float) (amortissement + taux);
			l.setAmount((float)amortissement);
			valeur_nette = montant-amortissement;
			
			
			l.setRemuneration((float)valeur_nette);
		   
			list.add(new LoanPayment(montant, annuite,l, date_fin));
			
			
		    montant =(float) (montant - amortissement);
		   
			
            
		
		
		}
/*
		lp.addLoanPayment(new LoanPayment(montant, annuite, l, date_fin));
		l.setAmount(montant);

		ls.addLoan(l);
		*/
		System.out.println("MONTANT:" + montant + "NBRE ANNUITES:" + nbre_annuites + "ANNUITE" + annuite);

		return list;

	}
	
	 
	  public void AnnuitesConstantes()
	  { 
		 annuite = (float) (emprunt +
	  (taux_interet / Math.pow(taux_interet + 1, -nbre_annuites)));
	  taux_interet= montant*taux;
	  
	  //valeur_nette=montant_periode-amortissement_annee; }
	  }
	  
	  public String redirect()
	  {
		  String navigateTo="/xhtml/annuites?faces-redirect=true";
		  return navigateTo;
	  }
	  
	  public String path()
	  {
		  String navigateTo="/xhtml/choix_annuite?faces-redirect=true";
		  return navigateTo;
	  }
	  public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}
		
	

}