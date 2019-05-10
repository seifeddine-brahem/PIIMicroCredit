package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Enumerated;

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "adress")
    private String adress;
    @Column(name = "grade")
    private String grade;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "departement")
    Department departement;
    
    @OneToMany(mappedBy="owner",fetch=FetchType.EAGER)
    private List<Account> accounts= new ArrayList<>();
    
    @OneToMany(mappedBy="sender",fetch=FetchType.EAGER)
    private List<Transaction> transactionSender = new ArrayList<>();
    @OneToMany(mappedBy="receiver",fetch=FetchType.EAGER)
    private List<Transaction> transactionReceiver = new ArrayList<>();

    //Constructor
    public User() {
        this.departement = new Department();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartement() {
        return departement;
    }

    public void setDepartement(Department departement) {
        this.departement = departement;
    }

	public List<Transaction> getTransactionSender() {
		return transactionSender;
	}

	public void setTransactionSender(List<Transaction> transactionSender) {
		this.transactionSender = transactionSender;
	}

	public List<Transaction> getTransactionReceiver() {
		return transactionReceiver;
	}

	public void setTransactionReceiver(List<Transaction> transactionReceiver) {
		this.transactionReceiver = transactionReceiver;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Override
	public String toString() {
		return first_name + " " + last_name;
	}

}
