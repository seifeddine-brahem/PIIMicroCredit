package tn.esprit.test.managedbeans;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.PIIMicroCredit.entity.Role;




@ManagedBean(name = "data") 
@ApplicationScoped
public class Data implements Serializable {
private static final long serialVersionUID = 1L;
public Role[] getRoles() 
{ return Role.values(); }}
