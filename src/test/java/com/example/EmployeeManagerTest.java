package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {


    @Test
    void payEmployeesWithTestDoubleClass() {
        EmployeeRepository employeeRepository = new TestEmployeeRepository();
        BankService bankService = new TestBankService();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        int payments = employeeManager.payEmployees();

        assertEquals(employeeRepository.findAll().size(),payments);

    }

    @Test
    void payEmployeesWithMock() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        when(employeeRepository.findAll())
                .thenReturn(List.of(new Employee("1", 20000.0),
                        new Employee("2", 30000.0)));
        BankService bankService = mock(BankService.class);
        doThrow(new RuntimeException()).when(bankService).pay(anyString(), anyDouble());

        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        int payments = employeeManager.payEmployees();

        assertEquals(0,payments);

    }

}