package tn.esprit.ManagedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.LoanType;
import tn.esprit.PIIMicroCredit.service.LoanTypeService;

@SessionScoped
@ManagedBean
public class LoanTypeBean {

    Integer id;
    String name;
    String description;
    Float minValue;
    Float maxValue;
    Float interest;
    Integer duree;
    
    @EJB
    LoanTypeService serviceloantype;
    
    public List<LoanType> showAll(){
    	
    	return serviceloantype.findAllLoansTypes();
    }
}
