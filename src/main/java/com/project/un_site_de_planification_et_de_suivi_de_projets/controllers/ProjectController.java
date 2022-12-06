package com.project.un_site_de_planification_et_de_suivi_de_projets.controllers;

import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Project;
import com.project.un_site_de_planification_et_de_suivi_de_projets.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    final
    ProjectService projectService ;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    @ResponseBody
    public Project add_New_project(@RequestBody Project project) {
        return projectService.addProject(project);
    }


    @GetMapping("/all")
    @ResponseBody
    public List<Project> all_projects(){
        return projectService.findAllProjects();
    }



    @GetMapping("/id/{id}")
    @ResponseBody
    public List<Project> GetProjects(@PathVariable("id") String id){
        System.err.println(id);
        long idCast = Long.parseLong(id);
        return projectService.findProjectsByIdEmployee(idCast);
    }




    @PutMapping("/update")
    @ResponseBody
    public void Mettre_A_jours_project(@RequestBody Project project){projectService.updateProject(project); }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void supp_project(@PathVariable("id") long id){projectService.deleteProjct(id); }



}
