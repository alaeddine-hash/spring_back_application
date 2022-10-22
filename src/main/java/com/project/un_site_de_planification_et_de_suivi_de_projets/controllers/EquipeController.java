package com.project.un_site_de_planification_et_de_suivi_de_projets.controllers;


import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Equipe;
import com.project.un_site_de_planification_et_de_suivi_de_projets.services.EquipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipe")
public class EquipeController {

    final
    EquipeService equipeService ;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @PostMapping("/add")
    @ResponseBody
    public Equipe add_New_Equipe(@RequestBody Equipe equipe) {
        return equipeService.addEquipe(equipe);
    }


    @GetMapping("/all")
    @ResponseBody
    public List<Equipe> all_equipes(){
        return equipeService.findAllEquipes();
    }


    @GetMapping("/id/{id}")
    @ResponseBody
    public Equipe equipe_id(@PathVariable("id") long id){
        return equipeService.findEquipeById(id);
    }


    @PutMapping("/update")
    @ResponseBody
    public void Mettre_A_jours_equipe(@RequestBody Equipe equipe){equipeService.updateEquipe(equipe); }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void supp_equipe(@PathVariable("id") long id){equipeService.deleteEquipe(id); }



}
