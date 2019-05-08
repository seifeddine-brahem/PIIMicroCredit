package tn.esprit.ManagedBean;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.LoanInformation;
import tn.esprit.PIIMicroCredit.entity.LoanStatu;
import tn.esprit.PIIMicroCredit.entity.LoanType;
import tn.esprit.PIIMicroCredit.service.LoanService;
import tn.esprit.PIIMicroCredit.service.LoanTypeService;

@SessionScoped
@ManagedBean
public class LoanBean {

     Integer id;
     Date start_date;
     String payment_type;
     Float amount;
     Float remuneration;
     LoanStatu statu;
     LoanType loanType;
     Account account;
     LoanInformation folder;
     
     @EJB
     LoanService serviceloan;
     @EJB
     LoanTypeService serviceloanType;
     
     
     public LoanType newLoanDemand(int id){
    	 return serviceloanType.getLoan(id);
     }
}
