package com.project.un_site_de_planification_et_de_suivi_de_projets.repos;

import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(
            value = "SELECT * FROM Projects p WHERE p.id_employe = :idEmployer ",
            nativeQuery = true)
    List<Project> findByIdEmploye(@Param("idEmployer")Long idEmployer);


    // @Query(
    //       value = "INSERT INTO Projects" +
    //            "VALUES (, value2, value3, ...);",
    //    nativeQuery = true)
   // List<Project> putProjectWithManagerId(@Param("idEmployer")Long idEmployer, @Param("project") Project project);
    @Query(
            value = "SELECT * FROM  Projects p  WHERE p.nom_projet = :name ",
            nativeQuery = true)
    Optional<Project> findByNom_projet(@Param("name") String name);
}
