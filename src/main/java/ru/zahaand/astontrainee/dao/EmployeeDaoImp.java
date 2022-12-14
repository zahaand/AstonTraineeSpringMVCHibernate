package ru.zahaand.astontrainee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.zahaand.astontrainee.model.Employee;

import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createOrUpdate(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Employee read(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Employee.class, id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public List<Employee> getAllProjectEmployees(int projectId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery(
                "select e from Employee e inner join e.project where e.project.id = :projectId", Employee.class);
        query.setParameter(projectId, projectId);
        return query.getResultList();
    }
}
