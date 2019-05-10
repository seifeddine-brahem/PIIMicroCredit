package tn.esprit.PIMicroCredit.interfacee;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Offer;
import tn.esprit.PIIMicroCredit.entity.User;
@Remote


public interface IUserRemote {
	ArrayList<User> findAllUser();

}
