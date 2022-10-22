package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Projects")
@Data
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(nullable = false)
//    updatable = false
    private Long id_project;

    private String nom_projet;
    private LocalDate date_debut;
    private LocalDate date_fin;
    private String technologie ;
    private String situation ;

    @ManyToOne
    @JoinColumn(name="id_equipe", nullable=false)
    private Equipe equipe;


    @OneToMany(mappedBy="project")
    private Set<Tache> taches;

}
