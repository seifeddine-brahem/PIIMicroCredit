package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employe implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String login;
	
	private String password;
	private String email;
	private Boolean isActif; 
	@Enumerated(EnumType.STRING)
	//@NotNull
	private Role role;
	
	public Employe(int id, String login, String password, String email, Boolean isActif, Role role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.isActif = isActif;
		this.role = role;
	}


	public Employe(String login, String password, String email, Boolean isActif, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.isActif = isActif;
		this.role = role;
	}


	public Boolean getIsActif() {
		return isActif;
	}


	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Employe(String login, String password, String email, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	public Employe() {
		super();
	}


	public Employe(String login, String password, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}



	
	
	
	
	
	
}
