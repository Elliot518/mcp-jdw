###1. ThreadPoolTaskExecutor

>Spring Boot对ThreadPoolExecutor封装的线程池ThreadPoolTaskExecutor。

####配置步骤:

1. 创建一个线程池的配置
    ```
    使用@Configuration和@EnableAsync这两个注解。
    (见AsyncConfig.java)
   
    application配置文件中配置各项参数。
    (见application-local.properties)
    ```
   <hr />

2. 创建一个异步线程的Service接口
   ```
   @Async注解的方法是异步方法。
   
   @Async("asyncServiceExecutor")
   注意: 注解中是前面ExecutorConfig.java中的方法名,
   表明异步方法进入的线程池是asyncServiceExecutor方法创建的。
   ```


