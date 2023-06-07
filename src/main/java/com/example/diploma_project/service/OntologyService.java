package com.example.diploma_project.service;

import com.example.diploma_project.entity.Ontology;
import com.example.diploma_project.repository.OntologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OntologyService {
    private final OntologyRepository ontologyRepository;

    public List<Ontology> getOntology(){
        return ontologyRepository.findAll();
    }

    @Transactional
    public void syncDataFromProtege(Ontology ontology){
        ontologyRepository.save(ontology);
    }


}
