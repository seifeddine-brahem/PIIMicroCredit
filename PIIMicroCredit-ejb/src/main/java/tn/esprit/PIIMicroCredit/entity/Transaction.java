/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private LocalDateTime date_transaction;
    @Column(name = "amount")
    private String amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transaction_type;
    @Column(name = "check_number")
    private int check_number;

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

    public LocalDateTime getDate_transaction() {
        return date_transaction;
    }

    public void setDate_transaction(LocalDateTime date_transaction) {
        this.date_transaction = date_transaction;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
