package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.util.ImagePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController{

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/qqq", method = RequestMethod.GET)
    public String testA(){
        return "Sarkhan Hamzayev";
    }


    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public List<Employee> getEmployeeList()throws Exception {
        return employeeService.getEmployeeList();
    }

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public  int insertEmployee(@RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("jobTitle") String jobTitle,
                               @RequestParam("homeCity") String homeCity,
                               @RequestParam("experience") String experience,
                               @RequestParam("image") MultipartFile image,
                               @RequestParam("age") String age) throws IOException {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setJobTitle(jobTitle);
        employee.setCity(homeCity);
        employee.setExperience(experience);
        employee.setAge(Integer.parseInt(age));
        employee.setImage(image);

        if(image !=null) {
            employee.setImagePath(ImagePath.deploy(image));
        }
        System.out.println(employee);
        return employeeService.insertEmployee(employee);
    }

    @RequestMapping(value = "/list/{id}",method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public int deleteEmployeeById(@PathVariable("id") int id){
        return  employeeService.deleteEmployeeById(id);
    }

    @RequestMapping (value = "/update",method = RequestMethod.POST)
    public int updateEmployee(@RequestParam("name") String name,
                              @RequestParam("id") String id,
                              @RequestParam("surname") String surname,
                              @RequestParam("jobTitle") String jobTitle,
                              @RequestParam("homeCity") String homeCity,
                              @RequestParam("experience") String experience,
                              @RequestParam("image") MultipartFile image,
                              @RequestParam("age") String age){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setJobTitle(jobTitle);
        employee.setCity(homeCity);
        employee.setExperience(experience);
        employee.setAge(Integer.parseInt(age));
        employee.setId(Integer.parseInt(id));
        employee.setImage(image);
        employee.setImagePath("asd");
        System.out.println(employee);
        return employeeService.updateEmployee(employee);
    }


}
