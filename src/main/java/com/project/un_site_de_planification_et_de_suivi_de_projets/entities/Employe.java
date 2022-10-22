package com.project.un_site_de_planification_et_de_suivi_de_projets.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Data
public  class Employe {
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
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_equipes",
            joinColumns = @JoinColumn(name = "id_employe"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id"))
    private Set<Equipe> equipes = new HashSet<>();

   @OneToMany(mappedBy="sender")
     private Set<Message> message_one;

    @OneToMany(mappedBy="récipient")
    private Set<Message> message_two;


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
}
