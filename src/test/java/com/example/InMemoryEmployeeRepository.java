package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class InMemoryEmployeeRepository implements EmployeeRepository {
    private List<Employee> employees;

    public InMemoryEmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        this.employees = employees.stream()
                .filter(emp -> !emp.getId().equals(e.getId()))
                .collect(Collectors.toList());
        employees.add(e);
        return e;
    }
}
