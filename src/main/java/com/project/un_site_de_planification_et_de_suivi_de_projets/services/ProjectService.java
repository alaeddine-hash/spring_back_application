package com.project.un_site_de_planification_et_de_suivi_de_projets.services;

import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Project;
import com.project.un_site_de_planification_et_de_suivi_de_projets.exception.UserNotFoundException;
import com.project.un_site_de_planification_et_de_suivi_de_projets.repos.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    private static ProjectRepository projectRepository;


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, PasswordEncoder passwordEncoder) {
        this.projectRepository = projectRepository;

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

}
