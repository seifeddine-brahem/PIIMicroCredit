package tn.esprit.PIIMicroCredit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Complaint")
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "decription")
    private String description;
    @Column(name = "publishing_date")
    private LocalDateTime publishing_date;
    @Column(name = "complaint_type")
    private AccountType complaint_type;
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

}
