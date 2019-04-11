package tn.esprit.PIIMicroCredit.service;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.PIIMicroCredit.Interface.ILegalInformation;
import tn.esprit.PIIMicroCredit.entity.LegalInformation;
import tn.esprit.PIIMicroCredit.entity.User;

@Stateless
@Remote
public class LegalInformationService implements ILegalInformation{
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addLegalInfo(LegalInformation C) {
		em.persist(C);
		System.out.println("Out of addLegalInfo" + C.getId());
		return C.getId();
	}

	@Override
	public void removeLegalInfo(int id) {
		// TODO Auto-generated method stub
		System.out.println("In removeLegalInfo: ");
		em.remove(em.find(LegalInformation.class, id));
		System.out.println("Out of removeLegalInfo: ");
	}

	@Override
	public void updateLegalInfo(LegalInformation C) {
		// TODO Auto-generated method stub
		System.out.println("In updateLegalInfo: ");
		LegalInformation legalInfo = em.find(LegalInformation.class, C.getId());
		legalInfo.setBirth_place(C.getBirth_place());
		legalInfo.setBirthday(C.getBirthday());
		legalInfo.setCin(C.getCin());
		legalInfo.setStatus(C.getStatus());
		legalInfo.setKids(C.getKids());
		legalInfo.setUser_id(C.getUser_id());
		legalInfo.setSalary(C.getSalary());
		legalInfo.setWork(C.getWork());
	}
	@Override 
	public LegalInformation FindLegalInfoById(int id)
	{
		System.out.println("In findLegalInfoById: ");
		LegalInformation d = em.find(LegalInformation.class, id);
		System.out.println("Out of findLegalInfoById: ");
		return d;
	}

	@Override
	public LegalInformation FindLegalInfoByUserId(User user) {
		Query query = em.createQuery("SELECT u FROM  LegalInformation u where u.user_id=:user");
		query.setParameter("user", user);
		try {
			return (LegalInformation) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	
}
