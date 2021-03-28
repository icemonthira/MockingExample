package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {


    @Test
    void payEmployees() {
        EmployeeRepository employeeRepository = new TestEmployeeRepository();
        BankService bankService = new TestBankService();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        int payments = employeeManager.payEmployees();

        assertEquals(employeeRepository.findAll().size(),payments);

    }
}