package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "messages")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private  long msg_id;

    private String object ;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="sender_id", nullable=false)
    private Employe sender;

    @ManyToOne
    @JoinColumn(name="récipient_id", nullable=false)
    private Employe récipient;
}
