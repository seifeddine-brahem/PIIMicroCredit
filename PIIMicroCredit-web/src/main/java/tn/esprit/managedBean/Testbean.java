package tn.esprit.managedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Testbean implements Serializable {
	
	
	private String test;
	
	@PostConstruct
	public void init()
	{
		System.out.println("HEEEEEEEEEEEEEEEEELLLLLLLLLLLLLLLLLOOOOOOOOO");
	}


	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}
	
	
	
	

}
