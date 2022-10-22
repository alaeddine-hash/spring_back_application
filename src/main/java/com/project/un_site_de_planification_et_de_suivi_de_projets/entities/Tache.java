package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Taches")
@Data
public class Tache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(nullable = false)
//    updatable = false
    private Long id_tache;
    private String intitulé_tache ;
    private String description_tache;

    @ManyToOne
    @JoinColumn(name="id_project", nullable=false)
    private Project project;

}
