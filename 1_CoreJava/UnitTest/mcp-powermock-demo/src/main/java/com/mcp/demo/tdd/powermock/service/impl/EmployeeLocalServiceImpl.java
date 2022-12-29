package com.mcp.demo.tdd.powermock.service.impl;

import com.mcp.demo.tdd.powermock.dao.IEmployeeDao;
import com.mcp.demo.tdd.powermock.dao.impl.EmployeeDaoImpl;
import com.mcp.demo.tdd.powermock.service.IEmployeeService;
import com.mcp.test.domain.person.Employee;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年09月16日 9:49 AM
 * @modified by:
 */
public class EmployeeLocalServiceImpl implements IEmployeeService {
    @Override
    public int getTotalEmployeesNum() {
        IEmployeeDao employeeDao = new EmployeeDaoImpl();

        return employeeDao.getTotal();
    }

    @Override
    public void createEmployee(Employee employee) {
        IEmployeeDao employeeDao = new EmployeeDaoImpl();

        employeeDao.addEmployee(employee);
    }
}

