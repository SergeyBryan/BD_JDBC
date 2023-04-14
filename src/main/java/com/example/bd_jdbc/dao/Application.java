package com.example.bd_jdbc.dao;

import java.util.List;

public class Application {


    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee("Maria", "Koroleva", "f", 20, 1);
        Employee employeeNew = new Employee("Maria", "Koroleva", "f", 30, 2);
        employeeDao.create(employee);
        employeeDao.updateAgeById(employeeNew, 44);
        employeeDao.delete(employeeNew, 44);
        System.out.println(employeeDao.readById(2));
        List<?> list = employeeDao.readAll();
        for (Object object : list) {
            System.out.println(object);
        }
    }


}
