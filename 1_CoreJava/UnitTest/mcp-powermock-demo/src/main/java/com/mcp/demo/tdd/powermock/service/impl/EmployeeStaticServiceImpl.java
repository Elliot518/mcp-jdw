package com.mcp.demo.tdd.powermock.service.impl;

import com.mcp.demo.tdd.powermock.service.IEmployeeStaticService;
import com.mcp.demo.tdd.powermock.util.EmployeeUtils;
import com.mcp.test.domain.person.Employee;

/**
 * @author KG
 * @description
 * @date Created in 2021年10月17日 3:33 PM
 * @modified_by
 */
public class EmployeeStaticServiceImpl implements IEmployeeStaticService {
    @Override
    public int getEmployeeCount() {
        return EmployeeUtils.getEmployeeCount();
    }

    @Override
    public void createEmployee(Employee employee) {
        EmployeeUtils.persistenceEmployee(employee);
    }
}

