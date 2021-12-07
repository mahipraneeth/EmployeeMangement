package com.pratishthan.EV.Repository;

import com.pratishthan.EV.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//no need to give @Repository because spring data jpa take cares
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByOrganisation(String organisation);
}
