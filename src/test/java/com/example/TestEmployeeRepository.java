package com.example;

import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        return List.of(new Employee("1", 20000.0), new Employee("2", 30000.0));
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
