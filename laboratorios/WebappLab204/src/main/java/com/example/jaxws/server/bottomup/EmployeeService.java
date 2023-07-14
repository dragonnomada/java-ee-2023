package com.example.jaxws.server.bottomup;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface EmployeeService {
    @WebMethod
    Employee getEmployee(int id);

    @WebMethod
    Employee updateEmployee(int id, String name);

    @WebMethod
    boolean deleteEmployee(int id);

    @WebMethod
    Employee addEmployee(int id, String name);

    // ...
}