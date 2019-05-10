package tn.esprit.PIMicroCredit.interfacee;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Employe;



@Remote
public interface EmployeServiceRemote{
	
	public int ajouterEmploye(Employe e);
	public Employe getEmployeByEmailAndPassword(String email, String password);
	public List<Employe> getAllEmployes();
	public void deleteEmployeById(int employeId);
	public void updateEmploye(Employe e);
}
