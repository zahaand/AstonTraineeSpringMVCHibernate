package ru.zahaand.astontrainee.service;

import org.springframework.stereotype.Service;
import ru.zahaand.astontrainee.dao.EmployeeDao;
import ru.zahaand.astontrainee.model.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImp(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void createOrUpdate(Employee employee) {
        employeeDao.createOrUpdate(employee);
    }

    @Override
    @Transactional
    public Employee read(int id) {
        return employeeDao.read(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDao.delete(id);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public List<Employee> getAllProjectEmployees(int projectId) {
        return employeeDao.getAllProjectEmployees(projectId);
    }
}
