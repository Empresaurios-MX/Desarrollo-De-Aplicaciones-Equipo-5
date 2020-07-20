package com.dnieln7.bean;

import com.dnieln7.dto.Employee;
import com.dnieln7.java.generic.request.HttpSession;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author dnieln7
 */
@ManagedBean
@SessionScoped
public class EmployeeBean {

    private final String MAIN = "/pages/employee/listemployee";

    private HttpSession<Employee> session;
    private Employee employee;
    private List<Employee> employees;

    public EmployeeBean() {
        session = new HttpSession<Employee>("http://localhost:8081/employees");
        employee = new Employee();

        updateList();
    }

    private void updateList() {
        employees = session.get(Employee[].class);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee newEmployee() {
        return new Employee();
    }

    public String insert() {

        session.post(employee, Employee.class);
        
        updateList();

        return MAIN;
    }

    public String update() {

        session.put(String.valueOf(employee.getId()), employee, Employee.class);

        return MAIN;
    }

    public String delete(int id) {

        session.delete(String.valueOf(id));
        updateList();

        return MAIN;
    }
}
