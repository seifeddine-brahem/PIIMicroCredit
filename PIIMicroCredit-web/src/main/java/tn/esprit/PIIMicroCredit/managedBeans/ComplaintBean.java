package tn.esprit.PIIMicroCredit.managedBeans;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.Complaint;
import tn.esprit.PIIMicroCredit.entity.ComplaintType;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.service.ComplaintService;


@ManagedBean(name = "complaintBean")
@SessionScoped 
public class ComplaintBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title; 
	private String description; 
	private ComplaintType type;

	@EJB
	ComplaintService cs;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ComplaintType getType() {
		return type;
	}

	public void setType(ComplaintType type) {
		this.type = type;
	}

	public ComplaintService getCs() {
		return cs;
	}

	public void setCs(ComplaintService cs) {
		this.cs = cs;
	}

	public String addComplaint() {
		String navigateTo="/xhtml/index?faces-redirect=true";
		User u = new User();
		u.setId(1);
		cs.addComplaint(new Complaint(title,description,new Date(),type,u));
		System.out.println("aaaa");
		return navigateTo;
	}
	private List<Complaint> complaints;

	public List<Complaint> getComplaints() {
		complaints = cs.findAllComplaints();
		return complaints;
	}
	public void removeComplaint(int id)
	{
		System.out.println("aaaaa");
		cs.removeComplaint(id);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ComplaintBean() {
		super();

		// TODO Auto-generated constructor stub
	}

}