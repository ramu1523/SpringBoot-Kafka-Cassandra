package com.tgt.service;

import com.tgt.entity.Employee;

import java.util.List;

/**
 * Created by a522467 on 11/16/16.
 */
public interface EmployeeService {

    /**
     * Used to Create the Employee Information
     * @param employee
     * @return {@link Employee}
     */
    public Employee createEmployee(Employee employee);

    /**
     * Getting the Employee Information using Id
     * @param id
     * @return {@link Employee}
     */
    public Employee getEmployee(int id);

    /**
     * Used to Update the Employee Information
     * @param employee
     * @return {@link Employee}
     */

    public Employee updateEmployee(Employee employee);

    /**
     * Deleting the Employee Information using Id
     * @param id
     */
    public void deleteEmployee(int id);

    /**
     * Getting the All Employees information
     * @return
     */
    public List<Employee> getAllEmployees();
}
