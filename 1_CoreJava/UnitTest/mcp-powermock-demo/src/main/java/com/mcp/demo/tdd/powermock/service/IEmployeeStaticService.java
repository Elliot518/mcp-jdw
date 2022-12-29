package com.mcp.demo.tdd.powermock.service;

import com.mcp.test.domain.person.Employee;

/**
 * @author KG
 * @description
 * @date Created in 2021年10月17日 3:29 PM
 * @modified_by
 */
public interface IEmployeeStaticService {
    int getEmployeeCount();

    void createEmployee(Employee employee);
}


