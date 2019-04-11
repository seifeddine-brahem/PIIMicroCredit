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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name ="loan")
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;
    @Column(name = "payment_type")
    private String payment_type;
    @Column(name = "amount")
    private Float amount;
    @Column(name = "remuneration")
    private Float remuneration;
    @Enumerated(EnumType.STRING)
    @Column(name = "statu")
    private LoanStatu statu;
    @ManyToOne
    @JoinColumn(name="loanType")
    private LoanType loanType;
    @OneToOne
    @JoinColumn(name = "account")
    private Account account;
    @OneToOne
    @JoinColumn(name = "folder")
    private LoanInformation folder;
    
    public Loan() {
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }


    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public LoanStatu getStatu() {
        return statu;
    }

    public void setStatu(LoanStatu statu) {
        this.statu = statu;
    }

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(Float remuneration) {
		this.remuneration = remuneration;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public LoanInformation getFolder() {
		return folder;
	}

	public void setFolder(LoanInformation folder) {
		this.folder = folder;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	} 
	
	
    
    
    
}
