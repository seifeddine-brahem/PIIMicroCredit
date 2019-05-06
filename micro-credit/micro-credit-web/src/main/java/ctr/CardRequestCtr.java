package ctr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CardRequest;
import tn.esprit.infini.micro_credit.services.CardRequestServiceLocal;

@ManagedBean
@ViewScoped
public class CardRequestCtr {
	private List<CardRequest> cardRequests = new ArrayList<>();
	private CardRequest selectedRequest = new CardRequest();
	private List<Account> accounts = new ArrayList<>();
	private Account selectedAccount=new Account();
	@EJB
	private CardRequestServiceLocal cardRequestServiceLocal;
	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;

	@PostConstruct
	private void init() {
		cardRequests = cardRequestServiceLocal.findAllRequests();
		accounts = cardRequestServiceLocal.findAllAccountsByCustomer(identityBean.getUser().getId());
	}
	public void doAddRequest() {
		selectedRequest.setAccount(selectedAccount);
		cardRequestServiceLocal.addCardRequest(selectedRequest);
	}
	public void doAcceptRequest() {
		cardRequestServiceLocal.processCardRequest(selectedRequest, true, new Date());
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

}
