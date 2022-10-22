package com.project.un_site_de_planification_et_de_suivi_de_projets.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Employe;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    private String lastname;
    private LocalDate birthday;
    private String phone;
    private LocalDate hiring_date;
    private LocalDate fin_contract_date;
    private String email;

    private String username;
    @JsonIgnore
    private String password;

    private long salaire ;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String name, String lastname, LocalDate birthday, String phone, LocalDate hiring_date, LocalDate fin_contract_date, String username, String email, String password, Long salaire,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.phone = phone;
        this.hiring_date = hiring_date;
        this.fin_contract_date = fin_contract_date;
        this.salaire = salaire;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetails build(Employe user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId_employe(),
                user.getName(),
                user.getLastname(),
                user.getBirthday(),
                user.getPhone(),
                user.getHiring_date(),
                user.getContract_end_date(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getSalaire(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getHiring_date() {
        return hiring_date;
    }

    public LocalDate getFin_contract_date() {
        return fin_contract_date;
    }


    public String getEmail() {
        return email;
    }

    public Long getSalaire() {
        return salaire;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.getId());
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}