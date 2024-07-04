package com.kuro.hr_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data                       // Annotation Lombok qui ajoute les getters et les setters tout seul.
@Entity                     // Annotation qui indique que la classe correspond à une table de la base de données.
@Table(name = "employees")  // Nom de la table associée.
public class Employee {

    @Id // Annotation qui indique que c'est la clé primaire de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation qui indique que l'ID est auto-incrementé
    private Long id;

    @Column(name="first_name")  // Annotation qui indique le nom de la colonne (car nom différent)
    private String firstName;

    @Column(name="last_name")  // Annotation qui indique le nom de la colonne (car nom différent)
    private String lastName;

    private String mail;

    private String password;

}