/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name = "Transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date_transaction")
    private Date date_transaction;
    @Column(name = "amount")
    private double amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transaction_type;
    @Column(name = "check_number")
    private int check_number;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "sender")
    private User sender;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "receiver")
    private User receiver;

    public Transaction() {

    }

    
    public TransactionType getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(TransactionType transaction_type) {
        this.transaction_type = transaction_type;
    }

    public int getCheck_number() {
        return check_number;
    }

    public void setCheck_number(int check_number) {
        this.check_number = check_number;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_transaction() {
        return date_transaction;
    }

    public void setDate_transaction(Date date) {
        this.date_transaction = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    
    

}
