package ctr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.infini.micro_credit.entities.CardOffer;
import tn.esprit.infini.micro_credit.services.CardOfferServiceLocal;

@ManagedBean
@ViewScoped
public class OfferCtr {
	private CardOffer cardOffer = new CardOffer();
	private CardOffer selectedOffer = new CardOffer();
	private List<CardOffer> cardOffers = new ArrayList<>();
	@EJB
	private CardOfferServiceLocal cardOfferServiceLocal;

	@PostConstruct
	private void init() {
		cardOffers = cardOfferServiceLocal.findAllCardOffers();
	}

	public void doAddCardOffer() {
		cardOfferServiceLocal.addCardOffer(cardOffer);
	}

	public void doDeleteCardOffer() {
		cardOfferServiceLocal.deleteCardOffer(selectedOffer);
	}

	public CardOffer getCardOffer() {
		return cardOffer;
	}

	public void setCardOffer(CardOffer cardOffer) {
		this.cardOffer = cardOffer;
	}

	public List<CardOffer> getCardOffers() {
		return cardOffers;
	}

	public void setCardOffers(List<CardOffer> cardOffers) {
		this.cardOffers = cardOffers;
	}

	public CardOffer getSelectedOffer() {
		return selectedOffer;
	}

	public void setSelectedOffer(CardOffer selectedOffer) {
		this.selectedOffer = selectedOffer;
	}

}
