package com.employee.employe.controller;

import com.employee.employe.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.employee.employe.service.employeeService;


@RestController
    public class employeeController {
        @Autowired
        private employeeService employeeservice;

        //insert
        @PostMapping("/emp")
        public Employee saveEmployee(@RequestBody Employee employee) {
            return employeeservice.saveEmployee(employee);
        }

        //retrieve
        @GetMapping("/emp")
        public Iterable<Employee> getEmployeeList() {
            return employeeservice.getEmployeeList();
        }

        //delete
        @DeleteMapping("/emp/{id}")
        public String deleteEmployee(@PathVariable("id")long id) {
             employeeservice.deleteEmployee(id);
             return "employee deleted";

        }

        //update
        @PostMapping("/emp/{id}")
        public Employee updateEmployee(@PathVariable("id")long id,@RequestBody Employee employee) {
            return employeeservice.updateEmployee(id,employee);

        }

}
