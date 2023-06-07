package com.example.diploma_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name = "ontology_table_final")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ontology {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "my_seq", allocationSize = 1)
    private Long id;

    @Column(name = "instance")
    private String instance;

    @Column(name = "class")
    private String onto_class;

    @Column(name = "data_property_name")
    private String data_property_name;

    @Column(name = "data_property_value")
    private String data_property_value;

    @Column(name = "object_property_name")
    private String object_property_name;

    @Column(name = "object_property_value")
    private String object_property_value;



}
