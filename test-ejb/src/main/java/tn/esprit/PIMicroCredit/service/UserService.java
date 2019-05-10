package tn.esprit.PIMicroCredit.service;

import java.util.ArrayList;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIMicroCredit.interfacee.IUserRemote;
@Remote
@Stateless
public class UserService implements IUserRemote {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;
	@Override
	public ArrayList<User> findAllUser() {
		
		TypedQuery<User> A =  em.createQuery("select c from User c",User.class) ;
		ArrayList<User> O = (ArrayList<User>) A.getResultList() ;
		return O;
	
	}
}
