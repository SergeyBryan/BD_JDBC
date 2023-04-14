package com.example.bd_jdbc.dao;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {


    public EmployeeDaoImpl() {

    }

    @Override
    public void create(Employee employee) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Employee employee, int id) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        employee.setId(id);
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(employee));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateAgeById(Employee employee, int id) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        employee.setId(id);
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Employee> readAll() {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee readById(int id) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        return entityManager.find(Employee.class, id);
    }

}
