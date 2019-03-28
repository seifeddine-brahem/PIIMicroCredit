/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.infini.micro_credit.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author elbrh
 */
@Entity
@Table(name = "UserSubscribeOffer")
public class UserSubscribeOffer implements  Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer_id;

    public UserSubscribeOffer() {
        this.user_id = new User();
        this.offer_id = new Offer();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Offer getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Offer offer_id) {
        this.offer_id = offer_id;
    }
    
    
    
    
    
}
