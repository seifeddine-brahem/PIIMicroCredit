package tn.esprit.test.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.Employe;
import tn.esprit.PIIMicroCredit.entity.Role;
import tn.esprit.PIMicroCredit.service.EmployeService;




@ManagedBean(name = "employeBean") 
@SessionScoped
public class EmployeBean implements Serializable {

private String login;
private String password;  private String email;
private Boolean isActif;  
private Role role;  
private List<Employe> employes;
private Integer employeIdToBeUpdated;
public Integer getEmployeIdToBeUpdated() {
	return employeIdToBeUpdated;
}


public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
	this.employeIdToBeUpdated = employeIdToBeUpdated;
}
@EJB
EmployeService employeService; 

public void addEmploye() {
employeService.ajouterEmploye(new Employe(login,  password, email, isActif, role)); }  


public String getLogin() {
	return login;
}

public Boolean getIsActif() {
	return isActif;
}


public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
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


public List<Employe> getEmployes() {
employes = employeService.getAllEmployes(); 
return employes;
} 

// EmployeService
public void removeEmploye(int employeId)
{
employeService.deleteEmployeById(employeId); 
}

public void modifier(Employe employe)
{this.setEmail(employe.getEmail());
this.setIsActif(employe.getIsActif());
this.setLogin(employe.getLogin());
this.setPassword(employe.getPassword());
this.setRole(employe.getRole());
	this.setEmployeIdToBeUpdated(employe.getId());
}
public void mettreAjourEmploye(){
	employeService.updateEmploye(new Employe(employeIdToBeUpdated, login,password,  email, isActif, role));
}




}