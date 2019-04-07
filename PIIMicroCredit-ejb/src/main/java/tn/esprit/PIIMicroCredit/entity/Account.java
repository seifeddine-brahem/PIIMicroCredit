package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "rib")
    private String rib;
    @Column(name = "solde")
    private Float solde;
    @Column(name = "openning_date")
    private LocalDateTime openning_date;
    @Column(name = "account_type")
    private AccountType account_type;
    @Column(name = "state")
    private Boolean state;
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Account() {
        //this.owner = new User();
    	this.state=true;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Float getSolde() {
        return solde;
    }
    

    public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public void setSolde(Float solde) {
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

	public Account(String rib, Float solde, LocalDateTime openning_date, AccountType account_type, User owner) {
		super();
		this.rib = rib;
		this.solde = solde;
		this.openning_date = LocalDateTime.now();
		this.account_type = account_type;
		this.owner = owner;
		this.state=true;
		
		
	}
	
    
    

}
