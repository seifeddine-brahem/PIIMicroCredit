package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Complaint;
import tn.esprit.PIIMicroCredit.entity.User;
@Remote
public interface IComplaint {
	
	public int addComplaint(Complaint c);
	public void updateComplaint(Complaint c);
	public void removeComplaint(int id);
	public List<Complaint> findAllComplaints();
	public List<Complaint> findComplaintByOwner(User u);
	public List<Complaint> advancedSearch(String key);
	public List<Complaint> findComplaintsByType(int type);

}