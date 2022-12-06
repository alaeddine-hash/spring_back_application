package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Setter
@Getter
@ToString
@AllArgsConstructor
//@JsonIdentityInfo(property = "id_employe", generator = ObjectIdGenerators.IntSequenceGenerator.class)
public  class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id_employe;

    private String name ;

    // @Column(nullable = false)
    private String lastname ;

    //   @Column(nullable = false)
    private LocalDate birthday ;

    //  @Column(nullable = false)
    private String phone ;

    // @Column(nullable = false)
    private LocalDate hiring_date ;

    //  @Column(nullable = false)
    private LocalDate contract_end_date ;

    //  @Column(nullable = false)
    private String email ;

    //  @Column(nullable = false)
    private String username ;

    //  @Column(nullable = false)
    private String password ;

    private long salaire ;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "id_employe"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


   @OneToMany(mappedBy="sender")
     private Set<Message> message_one;

    @OneToMany(mappedBy="récipient")
    private Set<Message> message_two;

    @OneToMany(mappedBy="manager")
    private Set<Project> projects;

    @OneToMany(mappedBy="employe")
    private Set<Tache> taches;

    @ManyToOne
    @JoinColumn(name="id_project")
    private Project project;


    public Employe(String username,String name, String lastname,LocalDate birthday,String phone,LocalDate hiring_date,LocalDate
            contract_end_date,Long salaire, String email, String password ) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.phone = phone;
        this.hiring_date = hiring_date;
        this.contract_end_date = contract_end_date;
        this.salaire = salaire ;
        this.email = email;
        this.password = password;}


    public Employe() {

    }
    @JsonManagedReference
    public Set<Role> getRoles() {
        return roles;
    }
}
