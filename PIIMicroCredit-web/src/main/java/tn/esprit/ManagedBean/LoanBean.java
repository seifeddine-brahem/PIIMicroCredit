package tn.esprit.ManagedBean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SlideEndEvent;
import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanInformation;
import tn.esprit.PIIMicroCredit.entity.LoanStatu;
import tn.esprit.PIIMicroCredit.entity.LoanType;
import tn.esprit.PIIMicroCredit.service.AccountService;
import tn.esprit.PIIMicroCredit.service.LoanService;
import tn.esprit.PIIMicroCredit.service.LoanTypeService;

@ManagedBean
@ViewScoped
public class LoanBean {

	Integer id;
	Date start_date;
	String payment_type;
	Float amount;
	Float remuneration;
	LoanStatu statu;
	Integer loanType_id;
	Integer account;
	LoanInformation folder;
	Float minValue, maxValue, interest = 0.0f;
	LoanType ll;
	int duree;
	@EJB
	LoanService serviceloan;
	@EJB
	LoanTypeService serviceloanType;
	@EJB
	AccountService servceAccount;

	public void handleKeyEvent() {
		LoanType ll = serviceloanType.getLoan(loanType_id);
		this.interest = ll.getInterest();
		this.maxValue = ll.getMaxValue();
		this.minValue = ll.getMinValue();
		this.duree = ll.getDuree();
		float i = this.interest ;
		int n = this.duree ;
		this.ll = ll;
		double D = (Math.pow((1 + i), n) - 1) / (i * Math.pow((1 + i), n));
		this.remuneration =(float)(this.minValue / D);
		
	}
	
	 public void onSlideEnd(SlideEndEvent event) {
		 	amount = (float) event.getValue();
		 	calculRemuniration();
	    }

	public void onInputChanged(ValueChangeEvent event) {
		FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	public void calculRemuniration(){
		remuneration = serviceloan.calculRemuniration(ll, amount, payment_type);
	}
	
	@PostConstruct
    public void init() {
		LoanType ll =  serviceloanType.findAllLoansTypes().get(0);
		interest = ll.getInterest();
		maxValue = ll.getMaxValue();
		minValue = ll.getMinValue();
		duree = ll.getDuree();
		amount = 0f ;
		this.ll = ll;
		payment_type= "Monthly";
		float i = interest ;
		int n = duree ;
		double D = (Math.pow((1 + i), n) - 1) / (i * Math.pow((1 + i), n));
	    remuneration =(float)(minValue / D);
	}
	
	public String redirectToAddLoan(){
		return "/xhtml/NewLoan?faces-redirect=true";
	}
	
	public String addloan(){
		Loan l = new Loan();
		l.setAccount(servceAccount.findAccountById(account));
		l.setAmount(amount);
		l.setPayment_type(payment_type);
		l.setStatu(LoanStatu.processing);
		l.setRemuneration(remuneration);
		l.setLoanType(serviceloanType.getLoan(loanType_id));
		serviceloan.addLoan(l);
		return "/xhtml/index?faces-redirect=true";
	}
	
	/*
	 * Getter and Setters
	 */

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LoanStatu getStatu() {
		return statu;
	}

	public void setStatu(LoanStatu statu) {
		this.statu = statu;
	}

	public Integer getLoanType() {
		return loanType_id;
	}

	public void setLoanType(Integer loanType) {
		this.loanType_id = loanType;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public LoanInformation getFolder() {
		return folder;
	}

	public void setFolder(LoanInformation folder) {
		this.folder = folder;
	}

	public Float getMinValue() {
		return minValue;
	}

	public void setMinValue(Float minValue) {
		this.minValue = minValue;
	}

	public Float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Float maxValue) {
		this.maxValue = maxValue;
	}

	public Float getInterest() {
		return interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

}
