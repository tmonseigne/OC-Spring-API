package com.kuro.hr_api.controller;

import com.kuro.hr_api.model.Employee;
import com.kuro.hr_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Element qui communiquera avec les autres applications (interface de notre API)
 */
@RestController // Comme @Component, elle permet d’indiquer à Spring que cette classe est un bean.
// Elle indique à Spring d’insérer le retour de la méthode au format JSON dans le corps de la réponse HTTP.
// Grâce à ce deuxième point, les applications qui vont communiquer avec votre API accéderont
// au résultat de leur requête en parsant la réponse HTTP.
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;    // Injection d'une instance EmployeeService.
    // Cela permettra d’appeler les méthodes pour communiquer avec la base de données.

    /**
     * Read - Get all employees
     * les requêtes HTTP de type GET à l’URL /employees exécuteront le code de cette méthode.
     * Il appelle la méthode getEmployees() du service, qui appellera la méthode findAll() du repository
     * et nous obtiendrons tous les employés enregistrés en base de données.
     * @return - An Iterable object of Employee fulfilled
     */
    @GetMapping("/employees")   // Indique le lien de l'endpoint.
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object fulfilled
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.orElse(null);
    }

    /**
     * Create - Add a new employee
     * @param employee An object employee
     * @return The employee object saved
     */
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param employee - The employee object updated
     * @return An Employee object fulfilled
     */
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
        Optional<Employee> e = employeeService.getEmployee(id);
        if(e.isPresent()) {
            Employee currentEmployee = e.get();

            String firstName = employee.getFirstName();
            if(firstName != null) { currentEmployee.setFirstName(firstName); }
            String lastName = employee.getLastName();
            if(lastName != null) { currentEmployee.setLastName(lastName); }
            String mail = employee.getMail();
            if(mail != null) { currentEmployee.setMail(mail); }
            String password = employee.getPassword();
            if(password != null) { currentEmployee.setPassword(password); }
            employeeService.saveEmployee(currentEmployee);
            return currentEmployee;
        } else { return null; }
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployee(id);
    }

}