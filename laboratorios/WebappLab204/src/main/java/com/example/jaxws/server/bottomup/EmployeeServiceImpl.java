package com.example.jaxws.server.bottomup;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.example.jaxws.server.bottomup.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
 
	Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	
    @WebMethod
    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    @WebMethod
    public Employee updateEmployee(int id, String name) {
    	Employee employee = getEmployee(id);
    	if (employee == null) return null;
    	employee.setFirstName(name);
        return employee;
    }

    @WebMethod
    public boolean deleteEmployee(int id) {
    	Employee employee = getEmployee(id);
    	if (employee == null) return false;
        employees.remove(id);
        return true;
    }

    @WebMethod
    public Employee addEmployee(int id, String name) {
    	Employee employee = new Employee();
    	employee.setId(id);
    	employee.setFirstName(name);
    	employees.put(id, employee);
        return employee;
    }

    // ...
}
