package com.example.diploma_project.repository;

import com.example.diploma_project.entity.Ontology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OntologyRepository extends JpaRepository<Ontology,Long> {

}
