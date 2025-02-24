package com.employee.employe.service;

import com.employee.employe.entity.Employee;

public interface employeeService {
    Employee saveEmployee(Employee employee);

    Iterable<Employee> getEmployeeList();

    void deleteEmployee(long id);

    Employee updateEmployee(long id, Employee employee);
}
