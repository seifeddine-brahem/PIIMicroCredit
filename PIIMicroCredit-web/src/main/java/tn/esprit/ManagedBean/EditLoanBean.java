package tn.esprit.ManagedBean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.SlideEndEvent;

import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanInformation;
import tn.esprit.PIIMicroCredit.entity.LoanStatu;
import tn.esprit.PIIMicroCredit.entity.LoanType;
import tn.esprit.PIIMicroCredit.service.AccountService;
import tn.esprit.PIIMicroCredit.service.LoanService;
import tn.esprit.PIIMicroCredit.service.LoanTypeService;
import tn.esprit.PIIMicroCredit.service.UserService;

@ManagedBean
@SessionScoped
public class EditLoanBean {

	Integer id;
	Date start_date;
	String payment_type;
	Float amount;
	Float remuneration;
	LoanStatu statu;
	Integer loanType_id;
	Integer account_id;
	Account acc;
	LoanInformation folder;
	Float minValue, maxValue, interest = 0.0f;
	LoanType ll;

	@EJB
	LoanService serviceloan;
	@EJB
	LoanTypeService serviceloanType;
	@EJB
	AccountService servceAccount;
	@EJB
	UserService serviveUser;
	/*
	 * Actions
	 */
	Integer duree;

	public void handleKeyEvent() {
		 ll = serviceloanType.getLoan(loanType_id);
		interest = ll.getInterest();
		maxValue = ll.getMaxValue();
		minValue = ll.getMinValue();
		duree = ll.getDuree();
		calculRemuniration();
	}

	public void onSlideEnd(SlideEndEvent event) {
		amount = (float) event.getValue();
		calculRemuniration();
	}

	

	public void calculRemuniration() {
		remuneration = serviceloan.calculRemuniration(ll, amount, payment_type);
	}
	
	public String HandleEdit(){
		l.setLoanType(serviceloanType.getLoan(loanType_id));
		l.setAmount(amount);
		l.setPayment_type(payment_type);
		l.setRemuneration(remuneration);
		l.setStatu(LoanStatu.demand);
		serviceloan.updateLoan(l);
		String navigateto;
		navigateto = "/xhtml/MyLoans?faces-redirect=true";
		return navigateto;
	}
	Loan l;
	public String showEditLoan(int id) {
		 l = serviceloan.findLoan(id);
		 if(l.getStatu().name().equals(LoanStatu.accepted.name())){
			 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Can't Edit This Loan, Reason : Loan Already Accepted",null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				return "";
		 }else{
				amount = l.getAmount();
				ll = l.getLoanType();
				loanType_id = ll.getId();
				payment_type = l.getPayment_type();
				acc = l.getAccount();
				interest = ll.getInterest();
				maxValue = ll.getMaxValue();
				minValue = ll.getMinValue();
				duree = ll.getDuree();
				calculRemuniration();
				String navigateto;
				navigateto = "/xhtml/EditLoan?faces-redirect=true";
				return navigateto; 
		 }

	}

	/*
	 * Getters & Setters
	 */

	public Integer getId() {
		return id;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
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

	public Integer getLoanType_id() {
		return loanType_id;
	}

	public void setLoanType_id(Integer loanType_id) {
		this.loanType_id = loanType_id;
	}

	public Integer getAccount() {
		return account_id;
	}

	public void setAccount(Integer account) {
		this.account_id = account;
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

	public LoanType getLl() {
		return ll;
	}

	public void setLl(LoanType ll) {
		this.ll = ll;
	}

	public UserService getServiveUser() {
		return serviveUser;
	}

	public void setServiveUser(UserService serviveUser) {
		this.serviveUser = serviveUser;
	}

}
