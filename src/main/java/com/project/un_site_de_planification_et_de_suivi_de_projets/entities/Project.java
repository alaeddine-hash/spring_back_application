package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Projects")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(property = "id_project", generator = ObjectIdGenerators.IntSequenceGenerator.class)
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_employe")
    private Employe manager;


    @OneToMany(mappedBy="project")
    private Set<Tache> taches;

    @JsonIgnore
    @OneToMany(mappedBy="project")
    private Set<Employe> membres;


}
