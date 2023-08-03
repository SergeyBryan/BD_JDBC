package com.example.bd_jdbc.EmployeeDaoImpl;

import com.example.bd_jdbc.dao.Employee;
import com.example.bd_jdbc.dao.EmployeeDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmployeeDaoImplTest {
    private final EmployeeDaoImpl out = new EmployeeDaoImpl();
    final Employee ivan = new Employee("Test", "Ivanov", "m", 22, 2);

    final Employee EXIST_EMPLOYEE = new Employee(2, "Marina", "Portnova", "f", 24, 2);


    @Test
    public void ShouldReturnResult() {
        Assertions.assertNotNull(out.readAll());
    }

    @Test
    public void ShouldReturnEmployeeById() {
        Assertions.assertEquals(out.readById(2), EXIST_EMPLOYEE);
    }

    @Test
    public void ShouldCreateNewEmployee() {
        out.create((ivan));
        Assertions.assertTrue(out.readAll().contains(ivan));
    }

    @Test
    public void ShouldDeleteEmployee() {
        ivan.setId(out.readAll().stream().filter(x -> x.getFirstName().equals(ivan.getFirstName())).findFirst().get().getId());
        out.delete(ivan, ivan.getId());
        Assertions.assertTrue(out.readAll().stream().filter(x -> x.getFirstName().equals(ivan.getFirstName())).findFirst().isEmpty());
    }

    @Test
    public void ShouldUpdateEmployee() {
        Employee test = new Employee("Ivan", "Ivanov", "m", 22, 5);
        Employee employee = out.readAll().stream().filter(x -> x.getLastName().equals(ivan.getLastName())).findFirst().get();
        out.updateAgeById(test, employee.getId());
        Assertions.assertEquals(test.getFirstName(), employee.getFirstName());
    }

}
