package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "rib")
	private String rib;
	@Column(name = "solde")
	private String solde;
	@Column(name = "openning_date")
	private LocalDateTime openning_date;
	@Column(name = "account_type")
	private AccountType account_type;
	
	public Account(){
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRib() {
		return rib;
	}
	public void setRib(String rib) {
		this.rib = rib;
	}
	public String getSolde() {
		return solde;
	}
	public void setSolde(String solde) {
		this.solde = solde;
	}
	public LocalDateTime getOpenning_date() {
		return openning_date;
	}
	public void setOpenning_date(LocalDateTime openning_date) {
		this.openning_date = openning_date;
	}
	public AccountType getAccount_type() {
		return account_type;
	}
	public void setAccount_type(AccountType account_type) {
		this.account_type = account_type;
	}
	
	
	
}
