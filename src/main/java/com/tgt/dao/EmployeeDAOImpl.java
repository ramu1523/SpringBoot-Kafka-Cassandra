package com.tgt.dao;

import com.tgt.entity.Employee;
import com.tgt.util.MyCassandraTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by a522467 on 11/16/16.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private MyCassandraTemplate myCassandraTemplate;

    @Override
    public Employee createEmployee(Employee employee) {
        return myCassandraTemplate.create(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return myCassandraTemplate.findById(id, Employee.class);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return myCassandraTemplate.update(employee, Employee.class);
    }

    @Override
    public void deleteEmployee(int id) {
        myCassandraTemplate.deleteById(id, Employee.class);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return myCassandraTemplate.findAll(Employee.class);
    }
}
