package tn.esprit.PIIMicroCredit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PIIMicroCredit.Interface.ICommentsRemote;
import tn.esprit.PIIMicroCredit.entity.Comments;
import tn.esprit.PIIMicroCredit.entity.News;

@Stateless
@LocalBean
public class CommentsService implements ICommentsRemote{
	@PersistenceContext(unitName = "PIIMicroCredit-ejb")
	EntityManager em;

	@Override
	public int addComment(Comments c) {
		em.persist(c);
		System.out.println("Out of addUser" + c.getId());
		return c.getId();
	}
	@Override
	public List<Comments> findCommentsByNews(News n){
		List<Comments>comments= em.createQuery("from Comments where news=:t", Comments.class).setParameter( "t", n ) .getResultList();
		return comments;
	}
	

}
