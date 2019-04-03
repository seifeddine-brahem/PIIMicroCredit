package tn.esprit.PIIMicroCredit.Interface;
import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.ContactInformation;


@Remote
public interface IContactInformation {
	public int addContactInfo(ContactInformation C);
	public void removeContactInfo(int id);
	public void updateContactInfo(ContactInformation C);
	
	}
