package com.example.bd_jdbc.dao;

import java.util.List;

public interface EmployeeDAO {

    void create(Employee employee);

    void delete(int id);

    void updateAgeById(int age, int id);

    List<Employee> readAll();

    Employee readById(int id);

}
