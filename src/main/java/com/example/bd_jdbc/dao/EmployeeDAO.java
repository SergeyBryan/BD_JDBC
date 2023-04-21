package com.example.bd_jdbc.dao;

import com.example.bd_jdbc.model.City;
import com.example.bd_jdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    void add(Employee employee);

    void delete(Employee employee);

    void update(Employee employee, int id);

    List<Employee> readAllEmployees();

    Employee get(int id);

    City readByCityId(int id);
}
