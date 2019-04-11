package tn.esprit.PIIMicroCredit.service;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import tn.esprit.PIIMicroCredit.entity.Offer;
import tn.esprit.PIIMicroCredit.Interface.IOfferRemote;

/**
 * Entity implementation class for Entity: OfferService
 *
 */
@Stateless

public class OfferService implements IOfferRemote {

	
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addOffer(Offer n) {
		em.persist(n);
		System.out.println("Out of addOfferr" + n.getId());
		return n.getId();
	}

	@Override
	public void removeOffer(int id) {
		System.out.println("In removeUser: ");
		em.remove(em.find(Offer.class, id));
		System.out.println("Out of removeNews: ");

	}

	@Override
	public void updateOffer(Offer n) {
		System.out.println("In updateUser: ");
		Offer offer = em.find(Offer.class, n.getId());
		offer.setTitle(n.getTitle());
		offer.setDescription(n.getDescription());
		offer.setStart_date(n.getStart_date());
		offer.setExpiry_date(n.getExpiry_date());
		offer.setPath(n.getPath());
	}

	@Override
	public Offer findOfferById(int id) {
		System.out.println("In findOfferById: ");
		Offer o = em.find(Offer.class, id);
		System.out.println("Out of findNewsById: ");
		return o;
	}

	@Override
	public List<Offer> findAllOffer() {
		System.out.println("In findAllNews: ");
		List<Offer> offers = em.createQuery("from Offer", Offer.class).getResultList();
		System.out.println("Out of findAllOffers: ");
		return offers;
	}
	@Override
	public void editoffer(Offer o){
		em.merge(o);
		
	}
	
	@Override
	public ArrayList<Offer> findAllOffers() {
		
		TypedQuery<Offer> A =  em.createQuery("select c from Offer c",Offer.class) ;
		ArrayList<Offer> O = (ArrayList<Offer>) A.getResultList() ;
		return O;
	
	}
	
	
   
}
