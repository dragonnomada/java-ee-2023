package com.example.jaxws.server.topdown;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(
  name = "EmployeeServiceTopDown", 
  endpointInterface = "com.example.jaxws.server.topdown.EmployeeServiceTopDown",
  targetNamespace = "http://topdown.server.jaxws.example.com/")
public class EmployeeServiceTopDownImpl 
  implements EmployeeServiceTopDown {
 
//    @Inject 
//    private EmployeeRepository employeeRepositoryImpl;
 
    @WebMethod
    public int countEmployees() {
        return 0;
    }
}