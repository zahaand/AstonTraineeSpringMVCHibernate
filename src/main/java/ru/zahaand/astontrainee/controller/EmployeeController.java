package ru.zahaand.astontrainee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zahaand.astontrainee.model.Employee;
import ru.zahaand.astontrainee.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createEmployee(@RequestBody Employee employee) {
        employeeService.createOrUpdate(employee);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public Employee readEmployee(@PathVariable int id) {
        return employeeService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/project/{id}")
    List<Employee> getAllProjectEmployees(@PathVariable int id) {
        return employeeService.getAllProjectEmployees(id);
    }
}
