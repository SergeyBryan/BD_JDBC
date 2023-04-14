package com.example.bd_jdbc.dao;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    void delete(Employee employee, int id);

    void updateAgeById(Employee employee, int id);

    List<Employee> readAll();

    Employee readById(int id);

}
