package com.mcp.demo.tdd.powermock.service;

import com.mcp.demo.tdd.powermock.service.impl.EmployeeStaticServiceImpl;
import com.mcp.demo.tdd.powermock.util.EmployeeUtils;
import com.mcp.test.domain.person.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author KG
 * @description
 * @date Created in 2021年10月17日 3:37 PM
 * @modified_by
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeUtils.class)
public class EmployeeStaticServiceImplTest {
    @Test
    public void testGetEmployeeCountWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);

        final IEmployeeStaticService employeeService = new EmployeeStaticServiceImpl();
        int count = employeeService.getEmployeeCount();

        assertEquals(10, count);
    }

    @Test
    public void testCreateEmployeeWithMock() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        PowerMockito.doNothing().when(EmployeeUtils.class);

        final IEmployeeStaticService employeeService = new EmployeeStaticServiceImpl();
        Employee employee = new Employee("David", 30000);
        employeeService.createEmployee(employee);

        PowerMockito.verifyStatic(EmployeeUtils.class);
    }
}

