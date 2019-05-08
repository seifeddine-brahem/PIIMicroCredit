package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PIIMicroCredit.Interface.INotification;
import tn.esprit.PIIMicroCredit.entity.News;
import tn.esprit.PIIMicroCredit.entity.Notification;
@Stateless
@Remote
public class NotificationService implements INotification{
	
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;


	@Override
	public List<Notification> findUnopenedNotifications() {
		System.out.println("In findUnopenedNotifications");
		List<Notification> n = em.createQuery("select n from Notification n where n.opened=false ", Notification.class).getResultList();
		System.out.println("findUnopenedNotifications ");
		return n;	
	}


	@Override
	public int addNotification(Notification n) {
		System.out.println("In addNotificationt: ");
		em.persist(n);
		System.out.println("Out of addNotification" + n.getId());
		return n.getId();
	}


	@Override
	public void updateNotification(Notification n) {

		System.out.println("In updateNotif: ");
		Notification notif = em.find(Notification.class, n.getId());
		notif.setOpened(true);
		

	}
	}


	



