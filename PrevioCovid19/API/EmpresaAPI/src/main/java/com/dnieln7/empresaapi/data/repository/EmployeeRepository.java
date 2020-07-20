package com.dnieln7.empresaapi.data.repository;

import com.dnieln7.empresaapi.data.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
