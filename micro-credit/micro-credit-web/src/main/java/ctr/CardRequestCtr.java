package ctr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CardRequest;
import tn.esprit.infini.micro_credit.services.CardRequestServiceLocal;
import tn.esprit.infini.micro_credit.services.ClaimServiceLocal;

@ManagedBean
@ViewScoped
public class CardRequestCtr {
	private List<CardRequest> cardRequests = new ArrayList<>();
	private CardRequest selectedRequest = new CardRequest();
	private List<Account> accounts = new ArrayList<>();
	private Account selectedAccount = new Account();
	private Integer selectedAccountId;
	@EJB
	private CardRequestServiceLocal cardRequestServiceLocal;
	@EJB
	private ClaimServiceLocal claimServiceLocal;
	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;
	@ManagedProperty(value = "#{offerCtr}")
	private OfferCtr offerCtr;

	@PostConstruct
	private void init() {
		cardRequests = cardRequestServiceLocal.findAllRequests();
		accounts = cardRequestServiceLocal.findAllAccountsByCustomer(identityBean.getUser().getId());
	}

	public void doAddRequest() {

		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Successful", "Your Request has been sent: "));
		context.addMessage(null, new FacesMessage(" Message", "you will reseve un email soon"));
		selectedRequest.setAccount(cardRequestServiceLocal.findAccountById(selectedAccountId));
		selectedRequest.setCardOffer(offerCtr.getSelectedOffer());
		selectedRequest.setCreationDate(new Date());
		selectedRequest.setStatus(false);
		cardRequestServiceLocal.addCardRequest(selectedRequest);
	}

	public void doAcceptRequest() {
		cardRequestServiceLocal.processCardRequest(selectedRequest, true, new Date());
	}

	public void doClaimAccount() {
		claimServiceLocal.unboundCard(selectedAccount.getId());
	}

	public void doRefuseRequest() {
		cardRequestServiceLocal.processCardRequest(selectedRequest, false, new Date());
	}

	public List<CardRequest> getCardRequests() {
		return cardRequests;
	}

	public void setCardRequests(List<CardRequest> cardRequests) {
		this.cardRequests = cardRequests;
	}

	public CardRequest getSelectedRequest() {
		return selectedRequest;
	}

	public void setSelectedRequest(CardRequest selectedRequest) {
		this.selectedRequest = selectedRequest;
	}

	public List<Account> getAccounts() {
		accounts = cardRequestServiceLocal.findAllAccountsByCustomer(identityBean.getUser().getId());
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public CardRequestServiceLocal getCardRequestServiceLocal() {
		return cardRequestServiceLocal;
	}

	public void setCardRequestServiceLocal(CardRequestServiceLocal cardRequestServiceLocal) {
		this.cardRequestServiceLocal = cardRequestServiceLocal;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	public Account getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(Account selectedAccount) {
		this.selectedAccount = selectedAccount;
	}

	public Integer getSelectedAccountId() {
		return selectedAccountId;
	}

	public void setSelectedAccountId(Integer selectedAccountId) {
		this.selectedAccountId = selectedAccountId;
	}

	public OfferCtr getOfferCtr() {
		return offerCtr;
	}

	public void setOfferCtr(OfferCtr offerCtr) {
		this.offerCtr = offerCtr;
	}

}
