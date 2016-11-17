package com.tgt.controller;

import com.tgt.entity.Employee;
import com.tgt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by a522467 on 11/16/16.
 */
@org.springframework.web.bind.annotation.RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        System.out.println("EmployeeController()");
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    Employee create(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(value="/employee", method = RequestMethod.GET)
    List<Employee> findAll() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    Employee findById(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    Employee update(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}
