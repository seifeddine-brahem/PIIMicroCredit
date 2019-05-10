package tn.esprit.PIIMicroCredit.Interface;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PIIMicroCredit.entity.Comments;
import tn.esprit.PIIMicroCredit.entity.News;



@Remote
public interface ICommentsRemote {
	public int addComment(Comments c);
	public List<Comments> findCommentsByNews(News n);
}
