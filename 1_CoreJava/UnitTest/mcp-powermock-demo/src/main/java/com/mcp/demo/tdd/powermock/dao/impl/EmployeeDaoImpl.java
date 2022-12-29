package com.mcp.demo.tdd.powermock.dao.impl;

import com.mcp.demo.tdd.powermock.dao.IEmployeeDao;
import com.mcp.test.domain.person.Employee;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年09月15日 9:01 PM
 * @modified by:
 */
public class EmployeeDaoImpl implements IEmployeeDao {
    @Override
    public int getTotal() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addEmployee(Employee employee) {
        throw new UnsupportedOperationException();
    }
}
