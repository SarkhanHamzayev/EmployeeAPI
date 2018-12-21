package com.employee.dao;

import com.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Employee> getEmployeeList() {
        return jdbcTemplate.query("select * from employee" , new MailRowMapper() );

    }
    class MailRowMapper implements RowMapper< Employee > {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee =new Employee();
            employee.setName(rs.getString("name"));
            employee.setSurname(rs.getString("surname"));
            employee.setAge(rs.getInt("age"));
            employee.setCity(rs.getString("city"));
            employee.setJobTitle(rs.getString("jobtitle"));
            employee.setExperience(rs.getString("experience"));
            employee.setImagePath(rs.getString("imagepath"));

            return employee;
        }
    }

    public Employee getEmployeeById(int id) {
        return jdbcTemplate.queryForObject("select * from employee where id=?", new Object[] { id},
                new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public int deleteEmployeeById(int id) {
        return jdbcTemplate.update("delete from employee where id=?", new Object[]{
                id
        });

    }

    public int updateEmployee(Employee employee) {
        System.out.println(employee);
        return jdbcTemplate.update("UPDATE `employee` SET `name`=?,`surname`=?,`age`=?,`jobtitle`=?,`city`=?,`experience`=?,`imagepath`=? WHERE `id`=?",
                new Object[]{
                        employee.getName(),employee.getSurname(),employee.getAge(),employee.getJobTitle(),employee.getCity(),employee.getExperience(),employee.getImagePath(),employee.getId()
                });
    }


    public int insertEmployee(Employee employee) {
        System.out.println(employee);
        return jdbcTemplate.update("INSERT INTO `employee`(`name`, `surname`, `age`, `jobtitle`, `city`, `experience`, `imagepath`) VALUES (?,?,?,?,?,?,?)",
                new Object[]{
                        employee.getName(),employee.getSurname(),employee.getAge(),employee.getJobTitle(),employee.getCity(),employee.getExperience(),employee.getImagePath()
                });
 }   }