package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PIIMicroCredit.Interface.IComplaint;
import tn.esprit.PIIMicroCredit.entity.Complaint;
import tn.esprit.PIIMicroCredit.entity.News;
import tn.esprit.PIIMicroCredit.entity.User;

public class ComplaintService implements IComplaint {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addComplaint(Complaint c) {
		System.out.println("In addComplaint: ");
		em.persist(c);
		System.out.println("Out of addComplaint" + c.getId());
		return c.getId();
	}

	@Override
	public void updateComplaint(Complaint c) {
		System.out.println("In updateComplaint: ");
		Complaint cmp = em.find(Complaint.class, c.getId());
		cmp.setDescription(c.getDescription());
		cmp.setTitle(c.getTitle());
		cmp.setPublishing_date(c.getPublishing_date());
		cmp.setComplaint_type(c.getComplaint_type());
		
	}

	@Override
	public void removeComplaint(int id) {
		System.out.println("In removeComplainte : ");
		em.remove(em.find(Complaint.class, id));
		System.out.println("Out of removeComplaint : ");		
	}

	@Override
	public List<Complaint> findComplaintByOwner(User u) {
		System.out.println("In findComplaintByOwner(User): ");
		List<Complaint> c = em.createQuery("select c from Complaint c where c.owner:= u", Complaint.class).getResultList();
		System.out.println("Out of findComplaintByOwner: ");
		return c;	}

	@Override
	public List<Complaint> findAllComplaints() {
		System.out.println("In findAllComplaints : ");
		List<Complaint> complaints = em.createQuery("select c from Complaint c", Complaint.class).getResultList();
		System.out.println("Out of findAllComplaints : ");
		return complaints;
	}

}
