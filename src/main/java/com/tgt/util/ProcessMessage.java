package com.tgt.util;

import com.tgt.entity.Employee;
import com.tgt.service.EmployeeService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by a522467 on 11/17/16.
 */
@Component
public class ProcessMessage {
    Logger LOGGER = LoggerFactory.getLogger(ProcessMessage.class);

    @Autowired
    EmployeeService employeeService;

    public boolean procesMessage(String message)
    {
        LOGGER.info("inside Process Messge class");
        boolean flag = false;
        try {
            JSONObject jsonObject = new JSONObject(message);
            Employee employee = new Employee();
            LOGGER.info("jsonObject="+jsonObject);
            LOGGER.info("id...."+(Integer)jsonObject.get("id"));
            employee.setId((Integer) jsonObject.get("id"));
            LOGGER.info("name...."+(String)jsonObject.get("name"));
            employee.setName((String)jsonObject.get("name"));
            LOGGER.info("age...."+(Integer)jsonObject.get("age"));
            employee.setAge((Integer)jsonObject.get("age"));
            LOGGER.info("salary...."+(Double)jsonObject.get("salary"));
            employee.setSalary((Double)jsonObject.get("salary"));
            LOGGER.info("Employee...."+employee);
            employeeService.createEmployee(employee);
            flag =  true;
        }catch (Exception e)
        {
            LOGGER.info(e.getMessage());
            flag =  false;
        }
        return  flag;
    }

}
