package tn.esprit.infini.micro_credit.services;

import javax.ejb.Local;

import tn.esprit.infini.micro_credit.entities.User;

@Local
public interface IdentityServiceLocal {
	User login(String login, String password);
}
