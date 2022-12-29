package com.mcp.demo.tdd.powermock.service;

import com.mcp.demo.tdd.powermock.dao.IEmployeeDao;
import com.mcp.demo.tdd.powermock.service.impl.EmployeeServiceImpl;
import com.mcp.test.domain.person.Employee;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年09月15日 9:10 PM
 * @modified by:
 */
public class EmployeeServiceTest {
    @Test
    public void testGetTotalEmployee() {
        // mock employee dao
        IEmployeeDao employeeDao = PowerMockito.mock(IEmployeeDao.class);
        // mock method
        PowerMockito.when(employeeDao.getTotal()).thenReturn(10);

        final IEmployeeService service = new EmployeeServiceImpl(employeeDao);
        int total = service.getTotalEmployeesNum();
        assertEquals(10, total);
    }

    @Test
    public void testCreateEmployee() {
        // mock employee dao
        IEmployeeDao employeeDao = PowerMockito.mock(IEmployeeDao.class);
        // mock employee entity
        Employee employee = PowerMockito.mock(Employee.class);

        // mock method
        PowerMockito.doNothing().when(employeeDao).addEmployee(employee);

        IEmployeeService service = new EmployeeServiceImpl(employeeDao);
        service.createEmployee(employee);

        // verify the method invocation
        Mockito.verify(employeeDao).addEmployee(employee);
    }
}
