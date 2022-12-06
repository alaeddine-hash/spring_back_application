package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Collection<Employe> employes;
    @JsonBackReference
    public Collection<Employe> getEmployees() {
        return employes;
    }

    public void setEmployees(Collection<Employe> employes) {
        this.employes = employes;
    }
}
