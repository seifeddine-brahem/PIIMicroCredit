package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	@Column(name = "state")
	private Boolean state;
	@Column(name = "adress")
	private String adress;
	@Column(name = "image")
	private String image;
	@Column(name = "grade")
	private String grade;
	@Enumerated(EnumType.STRING)
	private Role role;
	@ManyToOne
	@JoinColumn(name = "departement")
	Department departement;
	@OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
	private List<Transaction> transactionSender = new ArrayList<>();
	@OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER)
	private List<Transaction> transactionReceiver = new ArrayList<>();
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Comments> comments = new ArrayList<>();

	// Constructor
	public User() {
		this.departement = new Department();
		this.state = true;

	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
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

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
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

	public User(String first_name, String last_name, String email, String password, String adress, String grade,
			Role role, String login, Department department) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.adress = adress;
		this.grade = grade;
		this.role = role;
		this.state = true;
		this.login = login;
		this.departement = department;
	}
	public User( String first_name, String last_name, String email, String login, String password, Boolean state,
			String adress, String grade, Role role, Department departement) {
		super();
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.login = login;
		this.password = password;
		this.state = state;
		this.adress = adress;
		this.grade = grade;
		this.role = role;
		this.departement = departement;
	}

	public User(String first_name, String last_name, String email, String password, String adress, String grade,
			Role role,String login,Department department,String image) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.adress = adress;
		this.grade = grade;
		this.role = role;
		this.state=true;
		this.login=login;
		this.departement=department;
		this.image=image;
		
		
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return first_name + " " + last_name;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
