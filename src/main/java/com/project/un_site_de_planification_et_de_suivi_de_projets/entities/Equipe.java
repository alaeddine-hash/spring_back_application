package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "Equipe")
@Data
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(nullable = false)
//    updatable = false
    private Long id_equipe;

    private String nom_equipe;

    private String disponibilite;



    @OneToMany(mappedBy="equipe")
    private Set<Project> projects;



    @ManyToMany(mappedBy = "equipes")
    private Collection<Employe> employes;

    public Collection<Employe> getEmployees() {
        return employes;
    }

    public void setEmployees(Collection<Employe> employes) {
        this.employes = employes;
    }





}
