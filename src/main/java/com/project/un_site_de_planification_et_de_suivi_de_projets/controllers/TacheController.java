package com.project.un_site_de_planification_et_de_suivi_de_projets.controllers;

import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Tache;
import com.project.un_site_de_planification_et_de_suivi_de_projets.services.ProjectService;
import com.project.un_site_de_planification_et_de_suivi_de_projets.services.TacheService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tache")
public class TacheController {
    final
    TacheService tacheService ;

    ProjectService projectService ;

    public TacheController(TacheService tacheService, ProjectService projectService) {
        this.tacheService = tacheService;
        this.projectService = projectService;
    }

    @PostMapping("/add")
    @ResponseBody
    public Tache add_New_tache(@RequestBody Tache tache) {
        return tacheService.addTache(tache);
    }


    @GetMapping("/all")
    @ResponseBody
    public List<Tache> all_taches(){
        return tacheService.findAllTaches();
    }


    @GetMapping("/id/{id}")
    @ResponseBody
    public Tache tache_id(@PathVariable("id") long id){
        return tacheService.findTacheById(id);
    }


    @PutMapping("/update")
    @ResponseBody
    public void Mettre_A_jours_tache(@RequestBody Tache tache){tacheService.updateTache(tache); }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void supp_tache(@PathVariable("id") long id){tacheService.deleteTache(id); }


    @PostMapping("/addToProject/id/{id}")
    @ResponseBody
    public void addTacheToProject(@RequestBody @PathVariable("id") long id,@RequestBody Tache tache){
        projectService.addTAcheToproject(id, tache);}
    @PostMapping("/addToEmployee/id/{id}")
    @ResponseBody
    public void addTacheToEmployee(@RequestBody @PathVariable("id") long id,@RequestBody Tache tache){
        projectService.addTAcheToEmployee(id, tache);}


    @GetMapping("/project/{id}")
    @ResponseBody
    public List<Tache> GetTachesByProject(@PathVariable("id") String id){
        System.err.println(id);
        long idCast = Long.parseLong(id);
        return tacheService.findTachesByIdProject(idCast);}

    @GetMapping("/user/{id}")
    @ResponseBody
    public List<Tache> GetTachesByEmployee(@PathVariable("id") String id){
        System.err.println(id);
        long idCast = Long.parseLong(id);
        return tacheService.findTachesByIdEmployee(idCast);}


    @PostMapping(value = "/addTache/id/{nameEmp}/{nameProj}")
    @ResponseBody
    public void addTacheToProject(@RequestBody @PathVariable("nameEmp") String nameEmp,@RequestBody @PathVariable("nameProj") String  nameProj, @RequestBody Tache tache){
        tacheService.addTAcheWithEmpAndProjectNames(nameEmp, nameProj, tache);}

}
