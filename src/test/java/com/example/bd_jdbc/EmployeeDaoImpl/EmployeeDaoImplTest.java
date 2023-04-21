package com.example.bd_jdbc.EmployeeDaoImpl;

import com.example.bd_jdbc.dao.CityDaoImpl;
import com.example.bd_jdbc.model.City;
import com.example.bd_jdbc.model.Employee;
import com.example.bd_jdbc.dao.EmployeeDaoImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EmployeeDaoImplTest {
    private final EmployeeDaoImpl out = new EmployeeDaoImpl();
    private final CityDaoImpl cityDao = new CityDaoImpl();

    @AfterEach
    public void cleanUp() {
        cityDao.getAllCities().forEach(cityDao::deleteCity);
        assertTrue(cityDao.getAllCities().isEmpty());
        assertTrue(out.readAllEmployees().isEmpty());
    }


    @Test
    public void shouldSaveEmployee() {
        Employee employee = new Employee("Test", "Test", "m", 45, null);
        out.add(employee);
        assertTrue(out.readAllEmployees().contains(employee));
        out.delete(employee);
        assertFalse(out.readAllEmployees().contains(employee));
    }

    @Test
    public void shouldUpdateEmployee() {
        Employee employee = new Employee("Test", "Test", "m", 45, null);
        out.add(employee);
        assertTrue(out.readAllEmployees().contains(employee));
        employee.setFirstName("Ivan");
        out.update(employee, out.readAllEmployees().get(0).getId());
        assertTrue(out.readAllEmployees().contains(employee));
        out.delete(employee);
        assertFalse(out.readAllEmployees().contains(employee));
    }

    @Test
    public void shouldSaveTheCity() {
        City city = new City(8, "Omsk");
        cityDao.addCity(city);
        assertTrue(cityDao.getAllCities().contains(city));
    }

    @Test
    public void shouldUpdateCity() {
        City city = new City(8, "Omsk");
        City created = cityDao.addCity(city);
        assertTrue(cityDao.getAllCities().contains(city));
        created.setCityName("Tver");
        cityDao.updateCity(city);
    }

    @Test
    public void shouldCreateEmployeeWhenCityUpdate() {
        City city = new City("Kursk");
        cityDao.addCity(city);
        assertTrue(cityDao.getAllCities().contains(city));
        Employee employee = new Employee("Test", "Test", "m", 45, city);
        Employee employee1 = new Employee("Ivan", "Ivanov", "m", 30, city);
        city.setEmployeeList(List.of(employee, employee1));
        City updatedCity = cityDao.updateCity(city);
        assertTrue(out.readAllEmployees().containsAll(updatedCity.getEmployeeList()));
        cityDao.getCity(updatedCity.getCityId());
    }

}
