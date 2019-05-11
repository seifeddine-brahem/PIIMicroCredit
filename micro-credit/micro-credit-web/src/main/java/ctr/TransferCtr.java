package ctr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.services.CardRequestServiceLocal;
import tn.esprit.infini.micro_credit.services.TransferServiceLocal;

@ManagedBean
@ViewScoped
public class TransferCtr {
	private Double amount;

	@EJB
	private TransferServiceLocal transferServiceLocal;
	@EJB
	private CardRequestServiceLocal cardRequestServiceLocal;
	@ManagedProperty(value = "#{cardRequestCtr}")
	private CardRequestCtr cardRequestCtr;

	public void doTransfer() {
		Account accountFrom = cardRequestServiceLocal.findAccountById(cardRequestCtr.getSelectedAccountId());
		Account accountTo = cardRequestServiceLocal.findAccountById(cardRequestCtr.getSelectedAccountToId());
		;
		transferServiceLocal.transferToAccount(amount, accountFrom, accountTo);
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransferServiceLocal getTransferServiceLocal() {
		return transferServiceLocal;
	}

	public void setTransferServiceLocal(TransferServiceLocal transferServiceLocal) {
		this.transferServiceLocal = transferServiceLocal;
	}

	public CardRequestServiceLocal getCardRequestServiceLocal() {
		return cardRequestServiceLocal;
	}

	public void setCardRequestServiceLocal(CardRequestServiceLocal cardRequestServiceLocal) {
		this.cardRequestServiceLocal = cardRequestServiceLocal;
	}

	public CardRequestCtr getCardRequestCtr() {
		return cardRequestCtr;
	}

	public void setCardRequestCtr(CardRequestCtr cardRequestCtr) {
		this.cardRequestCtr = cardRequestCtr;
	}
	
}
