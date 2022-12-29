###1. PowerMock 介绍

>PowerMock不同于EasyMock，JMock，Mockito这些Mock框架。
> 
>它解决了上述三种框架根本没有办法完成的工作(eg: Mock一个Static方法等)。
> 
>我们可以把PowerMock理解为对现有Mock框架的扩展。

&nbsp;

###2. 安装PowerMock

- Maven依赖
```xml
<project>
    <properties> 
        <powermock.version>2.0.9</powermock.version>
    </properties>
    
    <dependencies>
        <!-- power mock -->
        <dependency>
            <groupId>org.powermock</groupId>
            <artifactId>powermock-module-junit4</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.powermock</groupId>
            <artifactId>powermock-api-mockito2</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

&nbsp;

###3. Mock普通类

####3-1) 带返回值方法

Code Snippet:
```java
public class EmployeeServiceTest {
    @Test
    public void testGetTotalEmployee() {
        // mock class
        IEmployeeDao employeeDao = PowerMockito.mock(IEmployeeDao.class);
        // mock class method
        PowerMockito.when(employeeDao.getTotal()).thenReturn(10);

        //  use the mock class
        final IEmployeeService service = new EmployeeServiceImpl(employeeDao);
        // here will call the mock class method
        int total = service.getTotalEmployeesNum();

        // assert
        assertEquals(10, total);
    }
}
```

<hr />

####3-2) 无返回值方法

>PowerMockito.doNothing()用来mock无返回值的方法。
> 
>使用Mockito.verify来校验被mock出来的对象中的某个方法是否被调用。
> 
>(ps: 当我们测试一个 void 方法的时候，没有办法去验证一个 mock 对象所执行后的结果，唯一的方法就是检查方法是否被调用)

Code Snippet:
```java
public class EmployeeServiceTest {
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

        // verify the method invocation.
        Mockito.verify(employeeDao).addEmployee(employee);
    }
}
```

<hr />

&nbsp;

###4. Mock局部变量

####4-1) 带返回值方法

Code Snippet:
```java
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
}
```

<hr />

####4-2) 无返回值方法

Code Snippet:
```java
@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeLocalServiceImpl.class)
public class EmployeeLocalServiceTest {
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
```

<hr />

####代码讲解

- @RunWith注解

> 作用:
> 
> 显式的告诉Jnit使用某个指定的Runner来运行Test Case。
> 
> (eg: 使用PowerMockRunner替代了默认的JUnit Runner)。

- @PrepareForTest注解

> 作用:
> 
> 告诉PowerMock为我提前准备一个特定的class。
> 
> 根据我测试预期的行为去准备。

&nbsp;

###5. Mock静态方法

- 关键代码
```
@RunWith(PowerMockRunner.class) 
@PrepareForTest(StaticClass.class)

PowerMockito.mockStatic(StaticClass.class);
```

>关键在于需要先PrepareForTest静态方法类。
>然后，再使用PowerMockito.mockStatic方法来模拟静态类。





