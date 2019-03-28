package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;

import tn.esprit.PIIMicroCredit.entity.Complaint;
import tn.esprit.PIIMicroCredit.entity.User;

public interface IComplaint {
	
	public int addComplaint(Complaint c);
	public void updateComplaint(Complaint c);
	public void removeComplaint(int id);
	public List<Complaint> findAllComplaints();
	public List<Complaint> findComplaintByOwner(User u);

}
