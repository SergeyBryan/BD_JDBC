package com.example.bd_jdbc.dao;

import com.example.bd_jdbc.model.City;
import com.example.bd_jdbc.model.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {


    public EmployeeDaoImpl() {

    }

    @Override
    public void add(Employee employee) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Employee employee) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(employee));
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Employee employee, int id) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        employee.setId(id);
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Employee> readAllEmployees() {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee get(int id) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        return entityManager.find(Employee.class, id);
    }

    @Override
    public City readByCityId(int id) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        return entityManager.find(City.class, id);
    }

}
