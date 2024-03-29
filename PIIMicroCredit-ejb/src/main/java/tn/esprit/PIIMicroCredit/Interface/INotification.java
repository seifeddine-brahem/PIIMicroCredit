package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;
import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.News;
import tn.esprit.PIIMicroCredit.entity.Notification;



@Remote
public interface INotification {
	public List<Notification> findUnopenedNotifications();
	public int addNotification(Notification n);
	public void updateNotification(Notification n);

}
