package ctr;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.infini.micro_credit.entities.Account;
import tn.esprit.infini.micro_credit.entities.CurrencyAccount;
import tn.esprit.infini.micro_credit.services.CardRequestServiceLocal;
import tn.esprit.infini.micro_credit.services.TransferServiceLocal;

@ManagedBean
@ViewScoped
public class AllowanceCtr {
	protected static Logger logger = Logger.getLogger("AllowanceCtr");
	private Double amoutToallowance;
	@ManagedProperty(value = "#{identityBean}")
	private IdentityBean identityBean;
	@EJB
	private CardRequestServiceLocal cardRequestServiceLocal;
	@EJB
	private TransferServiceLocal transferServiceLocal;

	@Init
	private void doInit() throws SecurityException, IOException {
		Handler fh = new FileHandler();
		logger.addHandler(fh);
	}

	public void doAllowance() {
		List<Account> accounts = cardRequestServiceLocal.findAllAccountsByCustomer(identityBean.getUser().getId());
		for (Account c : accounts) {
			FacesContext context = FacesContext.getCurrentInstance();

			if (c instanceof CurrencyAccount) {
				transferServiceLocal.allowanceToAccount(amoutToallowance, c);
				context.addMessage(null, new FacesMessage("Successful", "Your Request has been proceeded: "));
			} else {
				context.addMessage(null, new FacesMessage("Denied", "Your Request has been denied: "));
			}
		}

	}

	public Double getAmoutToallowance() {
		return amoutToallowance;
	}

	public void setAmoutToallowance(Double amoutToallowance) {
		this.amoutToallowance = amoutToallowance;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

}