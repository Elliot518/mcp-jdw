package com.mcp.demo.tdd.powermock.dao;

import com.mcp.test.domain.person.Employee;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年09月15日 9:03 PM
 * @modified by:
 */
public interface IEmployeeDao {
    /**
     * get total employees number
     * @author KG
     * @date 2021/9/15 9:29 PM
     * @return int
     */
    int getTotal();

    /**
     * add new employee
     * @author KG
     * @date 2021/9/15 9:28 PM
     * @param employee input employee
     */
    void addEmployee(Employee employee);
}
