package com.project.un_site_de_planification_et_de_suivi_de_projets.services;

import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Employe;
import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Project;
import com.project.un_site_de_planification_et_de_suivi_de_projets.exception.UserNotFoundException;
import com.project.un_site_de_planification_et_de_suivi_de_projets.repos.EmployeRepository;
import com.project.un_site_de_planification_et_de_suivi_de_projets.repos.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class EmployeService implements UserDetailsService {
    private static EmployeRepository employeRepo;
    private static ProjectRepository projectRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeService(EmployeRepository employeRepo, PasswordEncoder passwordEncoder, ProjectRepository projectRepository) {
        this.employeRepo = employeRepo;

        this.passwordEncoder = passwordEncoder;
        this.projectRepository = projectRepository;

    }

    public Employe addEmploye(Employe employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeRepo.save(employee);
    }

    public List<Employe> findAllEmployes() {
        return employeRepo.findAll();
    }

    public Employe updateEmploye(Employe employee) {
        return employeRepo.save(employee);
    }

    public Employe findEmployeById(Long id) {
        return employeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmploye(Long id) {
        employeRepo.deleteById(id);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employe user = employeRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    public void addProjectToemployee(long id_employee, Project p) {

        Employe employe = employeRepo.findById(id_employee).orElse(null);
        p.setManager(employe);
        Project project = projectRepository.save(p);
        Set<Project> L = employe.getProjects();
        L.add(project);
        employe.setProjects(L);
    }
}
