package ru.zahaand.astontrainee.service;

import ru.zahaand.astontrainee.model.Employee;

import java.util.List;

public interface EmployeeService {
    void createOrUpdate(Employee employee);
    Employee read(int id);
    void delete(int id);
    List<Employee> getAllEmployees();
}
