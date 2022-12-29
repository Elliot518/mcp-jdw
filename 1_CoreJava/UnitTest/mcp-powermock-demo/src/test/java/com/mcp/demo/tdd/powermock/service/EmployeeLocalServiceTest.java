package com.mcp.demo.tdd.powermock.service;

import com.mcp.demo.tdd.powermock.dao.IEmployeeDao;
import com.mcp.demo.tdd.powermock.dao.impl.EmployeeDaoImpl;
import com.mcp.demo.tdd.powermock.service.impl.EmployeeLocalServiceImpl;
import com.mcp.test.domain.person.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年09月16日 9:51 AM
 * @modified by:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeLocalServiceImpl.class)
public class EmployeeLocalServiceTest {
    @Test
    public void testGetTotalEmployeeWithMock() {
        // mock employee dao
        EmployeeDaoImpl employeeDao = PowerMockito.mock(EmployeeDaoImpl.class);

        try {
            // mock local variable
            PowerMockito.whenNew(EmployeeDaoImpl.class).withNoArguments().thenReturn(employeeDao);
            // mock method
            PowerMockito.when(employeeDao.getTotal()).thenReturn(10);

            IEmployeeService service = new EmployeeLocalServiceImpl();
            int total = service.getTotalEmployeesNum();
            assertEquals(10, total);
        } catch (Exception e) {
            fail("Test Fail!");
        }
    }

    @Test
    public void testCreateEmployeeWithMock() {
        // mock employee dao
        EmployeeDaoImpl employeeDao = PowerMockito.mock(EmployeeDaoImpl.class);

        try {
            // mock local variable
            PowerMockito.whenNew(EmployeeDaoImpl.class).withNoArguments().thenReturn(employeeDao);
            // mock employee entity
            Employee employee = PowerMockito.mock(Employee.class);

            IEmployeeService service = new EmployeeLocalServiceImpl();
            service.createEmployee(employee);

            // verify the method invocation
            Mockito.verify(employeeDao).addEmployee(employee);
        } catch (Exception e) {
            fail();
        }
    }
}

