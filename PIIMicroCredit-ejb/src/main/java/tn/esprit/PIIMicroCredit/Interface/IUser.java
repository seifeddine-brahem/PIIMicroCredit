package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.ContactInformation;
import tn.esprit.PIIMicroCredit.entity.LegalInformation;
import tn.esprit.PIIMicroCredit.entity.Role;
import tn.esprit.PIIMicroCredit.entity.User;



@Remote
public interface IUser {
	public User AddUser(User user);
	public void updateUser(User user);
	public List<User> FindAllUsers();
	public User FindUserByEmail(String text); 
	public User FindUserByEmailAndPsswd(String mail,String password);
	public void removeUser(int id);
	public User FindUserById(int id);
	public boolean login(String emailAddress, String pwd);
	String crypte(String password);
	public User FindUserByLogin(String mail);
	public boolean loginLog(String emailAddress, String pwd);
	//public void sendMailPassword(String mail, String contenu);
  // public ContactInformation findContactInfoId(int id);
	
}
