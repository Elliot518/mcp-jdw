package com.mcp.demo.tdd.powermock.service;

import com.mcp.test.domain.person.Employee;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年09月15日 9:06 PM
 * @modified by:
 */
public interface IEmployeeService {
    /**
     * get total number of all employees
     * @author KG
     * @date 2021/9/15 9:07 PM
     * @return int
     */
    int getTotalEmployeesNum();

    /**
     * create new employee
     * @author KG
     * @date 2021/9/15 9:30 PM
     * @param employee input employee
     */
    void createEmployee(Employee employee);
}
