/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.infini.micro_credit.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author elbrh
 */
@Entity
@Table(name = "Cards")
public class Cards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private String rib;
    @Column(name = "code_atm")
    private String code_atm;
    @Column(name = "code_web")
    private String code_web;
    @Column(name = "expiry_date")
    private LocalDateTime expiry_date;
    @Column(name = "state")
    private String state;
    @Column(name = "type")
    private String type;
    @OneToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Cards() {
        this.owner = new User();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getCode_atm() {
        return code_atm;
    }

    public void setCode_atm(String code_atm) {
        this.code_atm = code_atm;
    }

    public String getCode_web() {
        return code_web;
    }

    public void setCode_web(String code_web) {
        this.code_web = code_web;
    }

    public LocalDateTime getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDateTime expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    
    

}
