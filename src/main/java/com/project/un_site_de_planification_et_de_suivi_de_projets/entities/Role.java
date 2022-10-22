package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @ManyToMany(mappedBy = "roles")
    private Collection<Employe> employes;

    public Collection<Employe> getEmployees() {
        return employes;
    }

    public void setEmployees(Collection<Employe> employes) {
        this.employes = employes;
    }
}
