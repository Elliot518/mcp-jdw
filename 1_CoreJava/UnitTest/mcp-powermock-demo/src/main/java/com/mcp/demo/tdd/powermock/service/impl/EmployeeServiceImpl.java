package com.mcp.demo.tdd.powermock.service.impl;

import com.mcp.demo.tdd.powermock.dao.IEmployeeDao;
import com.mcp.demo.tdd.powermock.service.IEmployeeService;
import com.mcp.test.domain.person.Employee;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年09月15日 9:08 PM
 * @modified by:
 */
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDao employeeDao;

    public EmployeeServiceImpl(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public int getTotalEmployeesNum() {
        return employeeDao.getTotal();
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }
}
