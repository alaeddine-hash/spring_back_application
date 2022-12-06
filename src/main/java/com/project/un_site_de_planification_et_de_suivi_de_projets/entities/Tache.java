package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Taches")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(property = "id_tache", generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Tache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(nullable = false)
//    updatable = false
    private Long id_tache;
    private String intitule_tache;
    private String description_tache;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_project")
    private Project project;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_employe")
    private Employe employe;

}
