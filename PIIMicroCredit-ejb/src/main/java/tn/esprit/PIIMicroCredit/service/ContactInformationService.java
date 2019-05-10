package tn.esprit.PIIMicroCredit.service;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.PIIMicroCredit.Interface.IContactInformation;
import tn.esprit.PIIMicroCredit.entity.ContactInformation;
import tn.esprit.PIIMicroCredit.entity.LegalInformation;
import tn.esprit.PIIMicroCredit.entity.User;

@Stateless
@LocalBean
public class ContactInformationService implements IContactInformation{
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addContactInfo(ContactInformation C) {
		em.persist(C);
		System.out.println("Out of addContactInfo" + C.getId());
		return C.getId();
	}

	@Override
	public void removeContactInfo(int id) {
		// TODO Auto-generated method stub
		System.out.println("In removeContactInfo: ");
		em.remove(em.find(ContactInformation.class, id));
		System.out.println("Out of removeContactInfo: ");
	}

	@Override
	public void updateContactInfo(ContactInformation C) {
		// TODO Auto-generated method stub
		System.out.println("In updateContactInfo: ");
		ContactInformation contactInfo = em.find(ContactInformation.class, C.getId());
		contactInfo.setContry(C.getContry());
		contactInfo.setPhone_number(C.getPhone_number());
		contactInfo.setState(C.getState());
		contactInfo.setUser_id(C.getUser_id());
		contactInfo.setZip_code(C.getZip_code());
		
	}

	@Override
	public ContactInformation FindLegalInfoByUserId(User user) {
		
		Query query = em.createQuery("SELECT u FROM  ContactInformation u where u.user_id=:user");
		query.setParameter("user", user);
		try {
			return (ContactInformation) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}


	
	
}
