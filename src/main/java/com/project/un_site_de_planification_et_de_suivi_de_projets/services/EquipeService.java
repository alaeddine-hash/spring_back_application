package com.project.un_site_de_planification_et_de_suivi_de_projets.services;

import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Equipe;
import com.project.un_site_de_planification_et_de_suivi_de_projets.exception.UserNotFoundException;
import com.project.un_site_de_planification_et_de_suivi_de_projets.repos.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EquipeService {


    private static EquipeRepository equipeRepository;


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EquipeService(EquipeRepository equipeRepository, PasswordEncoder passwordEncoder) {
        this.equipeRepository = equipeRepository;

        this.passwordEncoder = passwordEncoder;

    }

    public EquipeService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Equipe addEquipe(Equipe equipe) {

        return equipeRepository.save(equipe);
    }

    public List<Equipe> findAllEquipes() {
        return equipeRepository.findAll();
    }

    public Equipe updateEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe findEquipeById(Long id) {
        return equipeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEquipe(Long id){
        equipeRepository.deleteById(id);
    }


}
