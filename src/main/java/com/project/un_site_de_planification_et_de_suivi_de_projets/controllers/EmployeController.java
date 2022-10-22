package com.project.un_site_de_planification_et_de_suivi_de_projets.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Employe;
import com.project.un_site_de_planification_et_de_suivi_de_projets.services.EmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class EmployeController {
    final
    EmployeService employeService ;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping("/add")
    @ResponseBody
    public Employe add_New_Employe(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @JsonIgnore
    @GetMapping("/all")
    @ResponseBody
    public List<Employe> all_employees(){
        return employeService.findAllEmployes();
    }


    @GetMapping("/id/{id}")
    @ResponseBody
    public Employe employee_id(@PathVariable("id") long id){
        return employeService.findEmployeById(id);
    }


    @PutMapping("/update")
    @ResponseBody
    public void Mettre_A_jours_employee(@RequestBody Employe employe){employeService.updateEmploye(employe); }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void supp_employe(@PathVariable("id") long id){employeService.deleteEmploye(id); }



}
