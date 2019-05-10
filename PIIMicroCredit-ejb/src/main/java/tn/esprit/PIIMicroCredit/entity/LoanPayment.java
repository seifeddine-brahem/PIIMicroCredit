/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name ="loanpayment")
public class LoanPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "amount")
    private float amount;
    @Column(name = "remuneration")
    private float remuneration;
    @ManyToOne
    @JoinColumn(name = "loan")
    private Loan loan;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date")
    private Date payment_date;
    
    public LoanPayment() {
    }

    public LoanPayment(float amount, float remuneration, Loan loan, Date payment_date) {
		super();
		this.amount = amount;
		this.remuneration = remuneration;
		this.loan = loan;
		this.payment_date = payment_date;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(float remuneration) {
		this.remuneration = remuneration;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	} 
	/*
	///////////////TAUX////////////////////////////////////////////////////
	public static Loan calculeTaux(String typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			int duree)
	{
		double taux = 0;
		
		if (typeCredit == "AMORTISSEMENT_CONSTANTS")
		{
			double amortissement = (montantEmprunte/duree);
			taux = ((annuiteMaximale-amortissement)/(montantEmprunte)*100);
			
			
		
		}
		return null;
	}
	////////////////////DUREE////////////////////////////////////////////
	public static Credit calculeDuree(int typeCredit, 
			double montantEmprunte, double annuiteMaximale,
			double taux)
	{
		if (typeCredit == AMORTISSEMENT_CONSTANTS)
		{
			double interet = montantEmprunte * (taux/100) ;
			double amortissement = annuiteMaximale - interet;
			int duree = (int)(montantEmprunte/amortissement);
			return new Credit (typeCredit, montantEmprunte, annuiteMaximale, taux, duree);
		}
		return null;
	}
	
	////////////////////MONTANT A EMPRUNTER//////////////////////////////////////
	public static Credit calculeMontantEmprunte(String typeCredit, 
			double annuiteMaximale,	double taux, int duree)
	{
		if(typeCredit == "AMORTISSEMENT_CONSTANTS")
		{
			double montantEmprunte = annuiteMaximale/((taux/100) + 1./duree);
			return new Credit (typeCredit, montantEmprunte, annuiteMaximale, taux, duree);
		}
		return null;
	}
	
	///////////////////////////ANNUITE MAX///////////////////////////
	public static Credit calculeAnuiteMaximale(String typeCredit, 
			double montantEmprunte,	double taux, int duree)
	{
		if (typeCredit == "AMORTISSEMENT_CONSTANTS")
		{
			double interet = montantEmprunte * (taux/100);
			double amortissement = montantEmprunte/duree;
			double annuiteMaximale = amortissement + interet;
			return new Credit (typeCredit, montantEmprunte, annuiteMaximale, taux, duree);
		}
		
		return null;
	}
	*/

	
	
	
	
	
	
	
	
	
    
    
}
