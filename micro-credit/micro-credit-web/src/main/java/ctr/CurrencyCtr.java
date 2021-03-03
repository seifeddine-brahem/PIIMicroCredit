package ctr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.infini.micro_credit.entities.Currency;
import tn.esprit.infini.micro_credit.services.CurrencyServiceLocal;

@ManagedBean
@ViewScoped
public class CurrencyCtr {
	private List<String> listCurrencyFrom = new ArrayList<>();
	private List<String> listCurrencyTo = new ArrayList<>();
	private String currencyFromSelected;
	private String currencyToSelected;
	private Double amount;
	private Double amountReturns;
	@EJB
	private CurrencyServiceLocal currencyServiceLocal;

	@PostConstruct
	private void init() {
		for (Currency c : Currency.values()) {
			listCurrencyFrom.add(c.toString());
			listCurrencyTo.add(c.toString());
		}
	}

	public void doConvert() {
		amountReturns = 0D;
		amountReturns = currencyServiceLocal.convertToCurrency(doFindCurrency(currencyFromSelected), doFindCurrency(currencyToSelected), amount);
	}

	private Currency doFindCurrency(String currency) {
		if (currency.equals("USD")) {
			return Currency.USD;

		} else if (currency.equals("EUR")) {
			return Currency.EUR;
		} else if (currency.equals("DT")) {
			return Currency.DT;
		} else {
			return null;
		}
	}

	public List<String> getListCurrencyFrom() {
		return listCurrencyFrom;
	}

	public void setListCurrencyFrom(List<String> listCurrencyFrom) {
		this.listCurrencyFrom = listCurrencyFrom;
	}

	public List<String> getListCurrencyTo() {
		return listCurrencyTo;
	}

	public void setListCurrencyTo(List<String> listCurrencyTo) {
		this.listCurrencyTo = listCurrencyTo;
	}

	public String getCurrencyFromSelected() {
		return currencyFromSelected;
	}

	public void setCurrencyFromSelected(String currencyFromSelected) {
		this.currencyFromSelected = currencyFromSelected;
	}

	public String getCurrencyToSelected() {
		return currencyToSelected;
	}

	public void setCurrencyToSelected(String currencyToSelected) {
		this.currencyToSelected = currencyToSelected;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmountReturns() {
		return amountReturns;
	}

	public void setAmountReturns(Double amountReturns) {
		this.amountReturns = amountReturns;
	}

}
