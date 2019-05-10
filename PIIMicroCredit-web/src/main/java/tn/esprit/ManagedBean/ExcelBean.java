package tn.esprit.ManagedBean;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.PIIMicroCredit.entity.Loan;
import tn.esprit.PIIMicroCredit.entity.LoanPayment;

@ManagedBean
@ApplicationScoped
	public class ExcelBean {
	
	     
	    private final static String[] colors;
	     
	    private final static String[] brands;
	     
	    static {
	        colors = new String[10];
	        colors[0] = "Black";
	        colors[1] = "White";
	        colors[2] = "Green";
	        colors[3] = "Red";
	        colors[4] = "Blue";
	        colors[5] = "Orange";
	        colors[6] = "Silver";
	        colors[7] = "Yellow";
	        colors[8] = "Brown";
	        colors[9] = "Maroon";
	         
	        brands = new String[10];
	        brands[0] = "BMW";
	        brands[1] = "Mercedes";
	        brands[2] = "Volvo";
	        brands[3] = "Audi";
	        brands[4] = "Renault";
	        brands[5] = "Fiat";
	        brands[6] = "Volkswagen";
	        brands[7] = "Honda";
	        brands[8] = "Jaguar";
	        brands[9] = "Ford";
	    }
	     
	    public List<LoanPayment> create(int size) {
	        List<LoanPayment> list = new ArrayList<LoanPayment>();
	        for(int i = 0 ; i < size ; i++) {
	            list.add(new LoanPayment(20000, 10000, new Loan(),Date.from(Instant.now())));
	        }
	         
	        return list;
	    }
	     
	
	
}
