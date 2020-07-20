package com.dnieln7.empresaapi.controller;

import com.dnieln7.empresaapi.controller.response.DeleteResponse;
import com.dnieln7.empresaapi.data.dto.EmployeeDTO;
import com.dnieln7.empresaapi.data.model.Employee;
import com.dnieln7.empresaapi.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeRepository.save(new Employee(
                0,
                employeeDTO.getName(),
                employeeDTO.getAddress(),
                employeeDTO.getPhone()
        ));
    }

    @PutMapping("/employees/{id}")
    public Employee putEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeRepository.save(new Employee(
                id,
                employeeDTO.getName(),
                employeeDTO.getAddress(),
                employeeDTO.getPhone()
        ));
    }

    @DeleteMapping("/employees/{id}")
    public DeleteResponse deleteEmployee(@PathVariable int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            return new DeleteResponse(1, "Not found!");
        }

        employeeRepository.delete(employee);

        return new DeleteResponse(1, "Deleted!");
    }
}
