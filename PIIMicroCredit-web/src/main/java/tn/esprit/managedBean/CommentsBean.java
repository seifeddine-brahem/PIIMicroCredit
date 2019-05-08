package tn.esprit.managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PIIMicroCredit.entity.Comments;
import tn.esprit.PIIMicroCredit.entity.News;
import tn.esprit.PIIMicroCredit.entity.User;
import tn.esprit.PIIMicroCredit.service.CommentsService;
import tn.esprit.PIIMicroCredit.service.UserService;

@ManagedBean
@SessionScoped
public class CommentsBean {
	private String description;
@EJB
CommentsService commentservice;
@EJB
UserService userservice;
public String addComments(News n){
	User u= userservice.FindUserById(1);
	commentservice.addComment( new Comments(description,n,u));
	return  "/xhtml/NewsClient?faces-redirect=true";
}
public List<Comments> showCommentsByNews(News n){
	return commentservice.findCommentsByNews(n);
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}







}
