package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PIIMicroCredit.Interface.INews;
import tn.esprit.PIIMicroCredit.entity.News;


@Remote
public class NewsService implements INews {
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addNews(News n) {
		em.persist(n);
		System.out.println("Out of addUser" + n.getId());
		return n.getId();
	}

	@Override
	public void removeNews(int id) {
		System.out.println("In removeUser: ");
		em.remove(em.find(News.class, id));
		System.out.println("Out of removeNews: ");

	}

	@Override
	public void updateNews(News n) {
		System.out.println("In updateUser: ");
		News news = em.find(News.class, n.getId());
		news.setTitle(n.getTitle());
		news.setPhoto(n.getPhoto());
		news.setDescription(n.getDescription());
		news.setDate_approved(n.getDate_approved());
		news.setDate_creation(n.getDate_creation());
		news.setApproved(n.getApproved());

	}

	@Override
	public News findNewsById(int id) {
		System.out.println("In findNewsById: ");
		News n = em.find(News.class, id);
		System.out.println("Out of findNewsById: ");
		return n;
	}

	@Override
	public List<News> findAllNews() {
		System.out.println("In findAllNews: ");
		List<News> news = em.createQuery("from News", News.class).getResultList();
		System.out.println("Out of findAllNews: ");
		return news;
	}

}
