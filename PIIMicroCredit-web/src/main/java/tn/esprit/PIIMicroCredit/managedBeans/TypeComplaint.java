package tn.esprit.PIIMicroCredit.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import tn.esprit.PIIMicroCredit.entity.ComplaintType;
@ManagedBean(name = "typeComplaint")
@ApplicationScoped
public class TypeComplaint implements Serializable {
	private static final long serialVersionUID = 1L;
	public ComplaintType[] getTypes() 
	{ return ComplaintType.values();}
}
