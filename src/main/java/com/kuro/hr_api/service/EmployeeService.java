package com.kuro.hr_api.service;

import com.kuro.hr_api.model.Employee;
import com.kuro.hr_api.repository.EmployeeRepository;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Ajoute seulement une interface qui pour chaque méthode a pour unique objectif d’appeler une méthode de l'employeeRepository.
 * Mais il pourrait y avoir des traitements supplémentaires. (exemple mettre en Maj ou min)
 */
@Data       // Annotation Lombok qui ajoute les getters et les setters tout seul.
@Service    // On pourrait utiliser component mais c'est un peu plus précis sémantiquement
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}