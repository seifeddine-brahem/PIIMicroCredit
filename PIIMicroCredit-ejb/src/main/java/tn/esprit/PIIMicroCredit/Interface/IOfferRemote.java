package tn.esprit.PIMicroCredit.interfacee;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Offer;
@Remote
public interface IOfferRemote {
	public int addOffer(Offer n);
	public void removeOffer(int id);
	public void updateOffer(Offer n);
	public Offer findOfferById(int id);
	public List<Offer> findAllOffer();
	public void editoffer(Offer o);
	public ArrayList<Offer> findAllOffers();
}
