package com.kuro.hr_api.repository;

import org.springframework.data.repository.CrudRepository;
// CrudRepository est une interface fournie par Spring.
// Elle fournit des méthodes pour manipuler votre entité.
// Elle utilise la généricité pour que son code soit applicable à n’importe quelle entité, d’où la syntaxe “CrudRepository<Employee, Long>”
// La classe entité fournie doit être annotée @Entity, sinon Spring retournera une erreur.
import org.springframework.stereotype.Repository;

import com.kuro.hr_api.model.Employee;

@Repository // Annotation Spring qui indique que la classe est un bean, et que son rôle est de communiquer avec une source de données
            // On pourrait utiliser component mais c'est un peu plus précis sémantiquement
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}