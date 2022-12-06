package com.project.un_site_de_planification_et_de_suivi_de_projets.repos;


import com.project.un_site_de_planification_et_de_suivi_de_projets.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {

    @Query(
            value = "SELECT * FROM Taches t WHERE t.id_project = :id_project ",
            nativeQuery = true)
    List<Tache> findByIdProject(@Param("id_project") long idCast);

    @Query(
            value = "SELECT * FROM  Taches t  WHERE t.id_Employe = :id_Employe ",
            nativeQuery = true)
    List<Tache> findByIdEmployee(@Param("id_Employe") long idCast);
}
