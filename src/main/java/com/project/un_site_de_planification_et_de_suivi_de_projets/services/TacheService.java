package com.project.un_site_de_planification_et_de_suivi_de_projets.services;

import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Employe;
import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Project;
import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Tache;
import com.project.un_site_de_planification_et_de_suivi_de_projets.exception.UserNotFoundException;
import com.project.un_site_de_planification_et_de_suivi_de_projets.repos.EmployeRepository;
import com.project.un_site_de_planification_et_de_suivi_de_projets.repos.ProjectRepository;
import com.project.un_site_de_planification_et_de_suivi_de_projets.repos.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TacheService {
    private static TacheRepository tacheRepository;
    private EmployeRepository employeRepository ;
    private ProjectRepository projectRepository;


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TacheService(TacheRepository tacheRepository, PasswordEncoder passwordEncoder, EmployeRepository employeRepository, ProjectRepository projectRepository ) {
        this.tacheRepository = tacheRepository;
        this.employeRepository = employeRepository;
        this.projectRepository = projectRepository;

        this.passwordEncoder = passwordEncoder;

    }

    public TacheService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Tache addTache(Tache tache) {

        return tacheRepository.save(tache);
    }

    public List<Tache> findAllTaches() {
        return tacheRepository.findAll();
    }

    public Tache updateTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public Tache findTacheById(Long id) {
        return tacheRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteTache(Long id){
        tacheRepository.deleteById(id);
    }

    public List<Tache> findTachesByIdProject(long idCast) {

            return tacheRepository.findByIdProject(idCast);


    }

    public List<Tache> findTachesByIdEmployee(long idCast) {
        return tacheRepository.findByIdEmployee(idCast);
    }

    public Tache addTAcheWithEmpAndProjectNames(String nameEmp, String nameProj, Tache tache) {

        Employe employe = employeRepository.findByName(nameEmp).orElse(null);
        Project project = projectRepository.findByNom_projet(nameProj).orElse(null);
        tache.setEmploye(employe);
        tache.setProject(project);
         return tacheRepository.save(tache);
    }
}
