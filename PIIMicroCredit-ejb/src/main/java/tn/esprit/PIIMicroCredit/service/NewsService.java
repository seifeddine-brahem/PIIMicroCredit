package tn.esprit.PIIMicroCredit.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.PIIMicroCredit.Interface.INewsRemote;
import tn.esprit.PIIMicroCredit.entity.News;

@Stateless
public class NewsService implements INewsRemote {
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
		news.setScore(n.getScore());

	}

	@Override
	public List<News> findNewsByTitle(String title) {
		System.out.println("In findNewsById: ");
		List<News> news = em.createQuery("from News where approved =1 and title=:t", News.class).setParameter( "t", title ) .getResultList();
		System.out.println("Out of findNewsById: ");
		return news;
	}

	@Override
	public List<News> findAllNews() {
		System.out.println("In findAllNews: ");
		List<News> news = em.createQuery("from News", News.class).getResultList();
		
		System.out.println("Out of findAllNews: ");
		return news;
	}
	@Override
	public List<News> findNewsSorted(){
		

		List<News> news  = em.createQuery("from News order by date_creation desc, score desc",News.class).getResultList();
		 
		  System.out.println("Out of findAllNews: ");
		return news;
	}

	@Override
	public List<News> findNewsByDate(String date) {
		List<News> news = em.createQuery("from News where approved =1 and DATE_FORMAT(date_creation, '%Y-%m-%d')=:t", News.class).setParameter( "t",date ) .getResultList();

		System.out.println("Out of findNewsById: ");
		return news;
	}
	@Override
	public List<News> NewsStat(){
		

		List<News> news  = em.createQuery("from News where approved =1 order by score desc ", News.class).getResultList();
		 
		  System.out.println("Out of findAllNews: ");
		return news;
	}

}
