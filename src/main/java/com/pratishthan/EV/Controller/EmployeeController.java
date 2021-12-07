package com.pratishthan.EV.Controller;

import com.pratishthan.EV.Model.Employee;
import com.pratishthan.EV.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    @PostMapping("/Post")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/hi")
    public String hell(){
        return "hello world";
    }
    @GetMapping("/All")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long eid){
        employeeService.deleteEmployee(eid);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }
    @GetMapping("/organisation1/organisation")
    public ResponseEntity<List<Employee>> getEmployeeByOrganisation(@RequestParam String organisation){
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeeBYOrganisation(organisation),HttpStatus.OK);
    }

}
