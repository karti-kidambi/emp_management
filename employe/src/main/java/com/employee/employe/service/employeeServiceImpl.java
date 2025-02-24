package com.employee.employe.service;

import com.employee.employe.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.employe.repository.EmployeeRepository;

import java.util.Objects;


@Service
public class employeeServiceImpl implements employeeService{
    @Autowired
    private EmployeeRepository employeerepository;

    @Override
    public Employee saveEmployee(Employee employee) {
       return employeerepository.save(employee);
    }

    @Override
    public Iterable<Employee> getEmployeeList() {
        return employeerepository.findAll();
    }

    @Override
    public void deleteEmployee(long id) {
        employeerepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
       Employee emp = employeerepository.findById(id).get();
      if(Objects.nonNull(employee.getFirstName())&&!"".equalsIgnoreCase(employee.getFirstName())){
          emp.setFirstName(employee.getFirstName());
      }
      if(Objects.nonNull(employee.getLastName())&&!"".equalsIgnoreCase(employee.getLastName())){
          emp.setLastName(employee.getLastName());
      }
      if(Objects.nonNull(employee.getExperience())&&!"".equalsIgnoreCase(employee.getExperience())){
          emp.setExperience(employee.getExperience());
      }
      if(Objects.nonNull(employee.getPhoneNumber())&&!"".equalsIgnoreCase(employee.getPhoneNumber())){
          emp.setPhoneNumber(employee.getPhoneNumber());
      }
      return employeerepository.save(emp);

    }
}
