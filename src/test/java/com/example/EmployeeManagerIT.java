package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerIT {

    @Test
    void findAll() {
        List<Employee> employees = List.of(new Employee("1", 20000.0),
                new Employee("2", 30000.0));

        EmployeeRepository employeeRepository = new InMemoryEmployeeRepository(employees);

        assertEquals(employees, employeeRepository.findAll());
    }

    @Test
    void save() {
        List<Employee> employees = List.of(new Employee("1", 20000.0),
                new Employee("2", 30000.0));

        EmployeeRepository employeeRepository = new InMemoryEmployeeRepository(employees);
        Employee thirdEmployee = new Employee("3", 40000.0);

        employeeRepository.save(thirdEmployee);

        assertTrue(employeeRepository.findAll().contains(thirdEmployee));

        Employee substitute = new Employee("3", 50000.0);

        employeeRepository.save(substitute);

        assertEquals(3, employeeRepository.findAll().size());
        assertTrue(employeeRepository.findAll().contains(substitute));
        assertFalse(employeeRepository.findAll().contains(thirdEmployee));
    }
}