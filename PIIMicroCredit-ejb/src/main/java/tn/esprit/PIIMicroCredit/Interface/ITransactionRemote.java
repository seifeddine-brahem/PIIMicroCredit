package tn.esprit.PIMicroCredit.interfacee;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Account;
import tn.esprit.PIIMicroCredit.entity.Offer;
import tn.esprit.PIIMicroCredit.entity.Transaction;
@Remote 
public interface ITransactionRemote {
	
	public Account consultercompte(int id);
	public void retirer(double montant,int id,int User_ID);
	public List<Transaction> consulterTransaction (int id);
	public void UpdateSolde(int id, double solde);
	public ArrayList<Transaction> findAllTransaction();
	public void addTransaction (Transaction op);
	public int add(Transaction n);
	public void UpdateBalanceplus(int id, double balance);
	public Long nbTransaction();
	
}
