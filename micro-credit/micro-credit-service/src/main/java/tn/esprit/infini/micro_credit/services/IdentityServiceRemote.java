package tn.esprit.infini.micro_credit.services;

import javax.ejb.Remote;

import tn.esprit.infini.micro_credit.entities.User;

@Remote
public interface IdentityServiceRemote {
	User login(String login, String password);
}
