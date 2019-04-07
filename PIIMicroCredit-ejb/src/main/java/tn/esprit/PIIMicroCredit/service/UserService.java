package tn.esprit.PIIMicroCredit.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tn.esprit.PIIMicroCredit.Interface.IUser;
import tn.esprit.PIIMicroCredit.entity.User;
@Stateless
@Remote
public class UserService implements IUser{
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;
	@Override
	public User FindUserById(int id) {
		System.out.println("In findUserById: ");
		User d = em.find(User.class, id);
		System.out.println("Out of findUserById: ");
		return d;
	}
	@Override
	public List<User> FindAllUsers() {
		System.out.println("In findAllNews: ");
		List<User> users = em.createQuery("from User", User.class).getResultList();
		System.out.println("Out of findAllUsers: ");
		return users;
	}
	@Override
	public User FindUserByEmail(String mail) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT u FROM  User u where u.email=:mail");
		query.setParameter("mail", mail);
		try {
			return (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	@Override
	public User FindUserByEmailAndPsswd(String mail, String password) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT u FROM User u where u.email=:mail AND u.password =:password");
		query.setParameter("mail", mail);
		query.setParameter("password", password);
		try {
			return (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	@Override
	public void AddUser(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		em.merge(user);
	}
	@Override
	public void removeUser(int id) {
		
		System.out.println("In removeUser: ");
		em.remove(em.find(User.class, id));
		System.out.println("Out of removeUser: ");
		
}
	  @Override
	    public boolean login(String emailAddress, String pwd) {
	        Query query=em.createQuery("SELECT u FROM User u WHERE u.emailAddress = :email AND u.password = :pwd").setParameter("emailAddress", emailAddress).setParameter("pwd", pwd);
	        if(query.getResultList().size() == 0)
	            return false;
	        return true;

	    }
	@Override
	public String crypte(String password) {
		// TODO Auto-generated method stub
		String hashedpassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes(), 0, password.length());
			hashedpassword = new BigInteger(1, md.digest()).toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashedpassword;
		
	}
	
	
	

}
