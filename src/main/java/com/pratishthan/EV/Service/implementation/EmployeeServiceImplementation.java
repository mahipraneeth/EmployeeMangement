package com.pratishthan.EV.Service.implementation;

import com.pratishthan.EV.Exception.ResourceNotFoundException;
import com.pratishthan.EV.Model.Employee;
import com.pratishthan.EV.Repository.EmployeeRepository;
import com.pratishthan.EV.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    /*constructor based dependency injection  and since we are using one constructor no need to give @Autowired*/
    private EmployeeRepository employeeRepository;
    //constructor
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","ID",id));
    }

    @Override
    public List<Employee> getEmployeeBYOrganisation(String organisation) {
        return employeeRepository.findByOrganisation(organisation);
    }


    @Override
    public Employee updateEmployee(Employee employee,long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","ID",id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEMail(employee.getEMail());
        existingEmployee.setOrganisation(employee.getOrganisation());
        employeeRepository.save(existingEmployee);
        return existingEmployee;

    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","ID",id));
        employeeRepository.deleteById(id);

    }


}
