package com.example.bd_jdbc.dao;

import com.example.bd_jdbc.model.City;

import javax.persistence.EntityManager;
import java.util.List;

public class CityDaoImpl implements CityDAO {
    public CityDaoImpl() {
    }

    @Override
    public City addCity(City city) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        return city;
    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(city));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public City updateCity(City city) {
        City updated;
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        updated = entityManager.merge(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updated;
    }

    @Override
    public List<City> getAllCities() {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT c FROM City c").getResultList();
    }

    @Override
    public City getCity(int id) {
        EntityManager entityManager = PersistenceReader.entityManagerFactory.createEntityManager();
        City city1 = entityManager.find(City.class, id);
        entityManager.close();
        return city1;
    }
}
