package ru.zahaand.astontrainee.dao;

import ru.zahaand.astontrainee.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void createOrUpdate(Employee employee);
    Employee read(int id);
    void delete(int id);
    List<Employee> getAllEmployees();
    List<Employee> getAllProjectEmployees(int projectId);
}
