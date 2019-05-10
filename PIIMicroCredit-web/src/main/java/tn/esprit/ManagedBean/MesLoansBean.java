package tn.esprit.ManagedBean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanInformation;
import tn.esprit.PIIMicroCredit.entity.LoanStatu;
import tn.esprit.PIIMicroCredit.entity.LoanType;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.service.AccountService;
import tn.esprit.PIIMicroCredit.service.LoanService;
import tn.esprit.PIIMicroCredit.service.LoanTypeService;
import tn.esprit.PIIMicroCredit.service.UserService;

@ManagedBean
public class MesLoansBean {

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
	List<Loan> data ;
	LoanType ll;
	int duree;
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
	
	public String edit(int id){
		return "";
	}
	
	public void delete(int id){
		Loan l = serviceloan.findLoan(id);
		if(l.getStatu().name().equals(LoanStatu.demand.name())){
			serviceloan.removeLoan(id);
			data.remove(l);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Loan Demand deleted", null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Can't Delete this Loan Demand", null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}	
	}
	
	@PostConstruct
	public void init(){
		User u = serviveUser.FindUserById(2);
		data = serviceloan.findLoanByOwner(2); 
	}
	
	
	
	/*
	 * Getters & Setters
	 */
	
	
	
	public Integer getId() {
		return id;
	}
	public List<Loan> getData() {
		return data;
	}



	public void setData(List<Loan> data) {
		this.data = data;
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
	public LoanType getLl() {
		return ll;
	}
	public void setLl(LoanType ll) {
		this.ll = ll;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	/*
	 * End Getters & Setters
	 */
	
	
	
	
	
}
