package com.employee.service;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;


    public List<Employee> getEmployeeList(){
        return employeeDAO.getEmployeeList();
    }

    public  int insertEmployee(Employee employee){
        return employeeDAO.insertEmployee(employee);
    }

    public  Employee getEmployeeById(int id){
        return employeeDAO.getEmployeeById(id);
    }

    public int deleteEmployeeById(int id) {
        return employeeDAO.deleteEmployeeById(id);
    }

   public int updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }
}
