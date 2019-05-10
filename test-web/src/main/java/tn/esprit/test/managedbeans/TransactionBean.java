package tn.esprit.test.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.Transaction;
import tn.esprit.PIIMicroCredit.entity.TransactionType;
import tn.esprit.PIMicroCredit.service.OfferService;
import tn.esprit.PIMicroCredit.service.TransactionService;

@ManagedBean(name = "TransactionBean") 
@SessionScoped
public class TransactionBean implements Serializable{

	/**
	 * 
	 */
	@EJB
	TransactionService transactionservice;
	private static final long serialVersionUID = 1L;
	
	
    private TransactionType transaction_type;
	
	
	
	private List<Transaction> Pro11;
	public  List<Transaction> getTablet() {
		Pro11 = transactionservice.findtransfer() ;
		
		return Pro11;
		}
		
		
	public  List<Transaction> getSmartPhone() {
		Pro11 = transactionservice.findwithdrawal() ;
		
		return Pro11;
		}

}
