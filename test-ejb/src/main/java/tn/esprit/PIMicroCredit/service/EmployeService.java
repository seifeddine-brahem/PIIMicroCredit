package tn.esprit.PIMicroCredit.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import tn.esprit.PIIMicroCredit.entity.Employe;
import tn.esprit.PIMicroCredit.interfacee.EmployeServiceRemote;








@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote {

@PersistenceContext(unitName = "PIIMicroCredit-ejb")
EntityManager em;
public int ajouterEmploye(Employe e){
	//Role r=null;
	//Employe e=new Employe("Mohamed","Ali","Med@esprit.tn",r.ADMINISTRATEUR);
	em.persist(e);
	return 1;
}
public Employe getEmployeByEmailAndPassword(String email, String password) {
	
TypedQuery<Employe> query = em.createQuery("select e from Employe e where e.email=:email AND e.password=:password", Employe.class); 

query.setParameter("email", email); 
query.setParameter("password", password); 

Employe employe = null; 
try { employe = query.getSingleResult(); }
catch (Exception e) { System.out.println("Erreur : " + e); }

return employe;
} 
public List<Employe> getAllEmployes() {
List<Employe> emp = em.createQuery("Select e from Employe e", Employe.class).getResultList();
return emp;
}

public void deleteEmployeById(int employeId)
{Employe e = em.find(Employe.class,employeId);

	em.remove(e);
}
public void updateEmploye(Employe e)
{
	//Employe a = em.find( Employe.class, e.getId() );
System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+e.getLogin());
 
	em.merge(e);

}
}
