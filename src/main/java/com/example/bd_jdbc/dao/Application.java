package com.example.bd_jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) throws SQLException {
        final String name = "postgres";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        final String password = "54155415";
        final Connection connection = DriverManager.getConnection(url, name, password);


//        Задание 1
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)");
        statement.setInt(1, 2);
        final ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String gender = resultSet.getString("gender");
            int age = resultSet.getInt("age");
            int city_id = resultSet.getInt("city_id");

            System.out.println("Id сотрудника: " + id);
            System.out.println("Имя сотрудника: " + first_name);
            System.out.println("Фамилия сотрудника: " + last_name);
            System.out.println("Пол сотрудника: " + gender);
            System.out.println("Возвраст сотрудника: " + age);
            System.out.println("Город сотрудника: " + city_id + '\n');
        }
        //Задание 2
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl(connection);
        Employee employee = new Employee("Margarita", "Ivanova", "f", 20, 1);
//        employeeDao.create(employee);
        employeeDao.delete(20);
        employeeDao.updateAgeById(17, 21);
        List<Employee> employeeList = new ArrayList<>(employeeDao.readAll());
        for (Employee employee1 : employeeList) {
            System.out.println(employee1);
        }
        System.out.println(employeeDao.readById(2));

    }


}
