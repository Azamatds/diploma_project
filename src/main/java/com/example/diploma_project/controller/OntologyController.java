package com.example.diploma_project.controller;

import com.example.diploma_project.entity.Ontology;
import com.example.diploma_project.service.OntologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/onto")
@RequiredArgsConstructor
public class OntologyController {
    private final OntologyService ontologyService;

    @GetMapping()
    public ResponseEntity<?> getOnto(){
        return new ResponseEntity<>(ontologyService.getOntology(), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> syncData(@RequestBody Ontology ontology){
        ontologyService.syncDataFromProtege(ontology);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
