package tn.esprit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//import tn.esprit.PIIMicroCredit.Interface.INewsRemote;
import tn.esprit.PIIMicroCredit.entity.News;

public class ClientService {
	/**
	 * public static void main(String[] args) throws NamingException{
	
		String jndiName= "PIIMicroCredit-ear/PIIMicroCredit-ejb/NewsService!tn.esprit.PIIMicroCredit.Interface.INewsRemote";
		Context context= new InitialContext(); 
		INewsRemote proxy= (INewsRemote) context.lookup(jndiName);
		News nw = new News();
		nw.setDescription("Deschh");
		nw.setTitle("TimeNews");
		nw.setPhoto("shdjsd");
		nw.setApproved(1);
		nw.setDate_approved(LocalDateTime.of(LocalDate.of(2014, Month.JANUARY, 1), LocalTime.of(12,20,25,40)));
		nw.setDate_creation(LocalDateTime.of(LocalDate.of(2014, Month.JANUARY, 1), LocalTime.of(12,20,25,40)));
		//proxy.addNews(nw);
		System.out.println("Ajout effectu�");
		System.out.println("News"+nw.getDescription());
		News nw1 = new News();
		nw1.setDescription("Dehfdsschh");
		nw1.setTitle("FinanceNews");
		nw1.setPhoto("shdjsd");
		nw1.setApproved(1);
		nw1.setDate_approved(LocalDateTime.of(LocalDate.of(2014, Month.JANUARY, 1), LocalTime.of(12,20,25,40)));
		nw1.setDate_creation(LocalDateTime.of(LocalDate.of(2014, Month.JANUARY, 1), LocalTime.of(12,20,25,40)));
	//	proxy.addNews(nw1);
	//	System.out.println("Ajout effectu�");
	//	System.out.println("News"+nw1.getDescription());
	//	System.out.println(proxy.findAllNews());
	//	proxy.removeNews(2);
		News nw2 = new News();
		nw2=proxy.findNewsById(1);
		nw2.setTitle("Test");
		proxy.updateNews(nw2);
	}
	
	 */
}
