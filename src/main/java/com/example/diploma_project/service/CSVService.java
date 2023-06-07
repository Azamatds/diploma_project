package com.example.diploma_project.service;

import com.example.diploma_project.entity.Ontology;
import com.example.diploma_project.parser.CSVParsing;
import com.example.diploma_project.repository.OntologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    OntologyRepository ontologyRepository;

    public void save(MultipartFile file) {
        try {
            List<Ontology> ontologies = CSVParsing.csvToOntology(file.getInputStream());
            ontologyRepository.saveAll(ontologies);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }

    }

    public ByteArrayInputStream load() {
        List<Ontology> tutorials = ontologyRepository.findAll();

        ByteArrayInputStream in = CSVParsing.tutorialsToCSV(tutorials);
        return in;
    }

    public List<Ontology> getAllTutorials() {
        return ontologyRepository.findAll();
    }
}
