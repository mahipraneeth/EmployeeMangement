package com.pratishthan.EV.Service;

import com.pratishthan.EV.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    List<Employee> getEmployeeBYOrganisation(String organisation);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);

}
