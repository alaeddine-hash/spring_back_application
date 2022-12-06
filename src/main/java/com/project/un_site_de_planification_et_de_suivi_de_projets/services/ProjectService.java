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
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ProjectService {

    private static ProjectRepository projectRepository;

    private static EmployeRepository employeRepository;

    private static TacheRepository tacheRepository ;


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ProjectService(EmployeRepository employeRepository, ProjectRepository projectRepository, TacheRepository tacheRepository, PasswordEncoder passwordEncoder) {
        this.projectRepository = projectRepository;

        this.employeRepository = employeRepository;

        this.tacheRepository = tacheRepository ;

        this.passwordEncoder = passwordEncoder;

    }

    public ProjectService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Project addProject(Project project) {

        return projectRepository.save(project);
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public  List<Project> findProjectsByIdEmployee(Long id) {
        return projectRepository.findByIdEmploye(id);
    }


    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    public Project findProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteProjct(Long id){
        projectRepository.deleteById(id);
    }

    public void addTAcheToproject(long id_project, Tache t) {

        Project project = projectRepository.findById(id_project).orElse(null);
        Tache tache = tacheRepository.save(t);
        Set<Tache> L = project.getTaches();
        L.add(tache);
        project.setTaches(L);
    }

    public void addTAcheToEmployee(long id, Tache t) {
        Employe employe = employeRepository.findById(id).orElse(null);
        Tache tache = tacheRepository.save(t);
        Set<Tache> L = employe.getTaches();
        L.add(tache);
        employe.setTaches(L);
    }
}
