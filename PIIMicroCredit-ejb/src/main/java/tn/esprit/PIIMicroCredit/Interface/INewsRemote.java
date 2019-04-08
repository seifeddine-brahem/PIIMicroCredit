package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.News;

@Remote
public interface INews {
	public int addNews(News n);
	public void removeNews(int id);
	public void updateNews(News n);
	public News findNewsById(int id);
	public List<News> findAllNews();
}
