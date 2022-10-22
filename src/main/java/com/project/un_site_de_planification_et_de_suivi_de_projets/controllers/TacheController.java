package com.project.un_site_de_planification_et_de_suivi_de_projets.controllers;

import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Project;
import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Tache;
import com.project.un_site_de_planification_et_de_suivi_de_projets.services.ProjectService;
import com.project.un_site_de_planification_et_de_suivi_de_projets.services.TacheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tache")
public class TacheController {
    final
    TacheService tacheService ;

    public TacheController(TacheService tacheService) {
        this.tacheService = tacheService;
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


}
