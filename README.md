# Scheduling Tasks

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Io Guides](https://spring.io/guides/gs/scheduling-tasks/)
* [Specifying the Startup Port for a SPring App](https://www.baeldung.com/spring-boot-change-port)

**janejazzy.springschedulledtasks** ---> is calling postman echo on port 9090
**janejazzy.springschedulledtasks** ---> is printing out the time and calling postman echo too (fixed and delayed schedulling)

Note, the **@Scheduled** annotation defines when a particular method runs.
          
This example uses **fixedRate**, which specifies the interval between method invocations, measured from the start time of each invocation. 
There are other options, such as **fixedDelay**, which specifies the interval between invocations measured from the completion of the task. 
You can also use **@Scheduled(cron=". . .")** expressions for more sophisticated task scheduling.

NOTE:- Package everything in a single, executable JAR file, driven by a good old Java main() method

The **@EnableScheduling** annotation ensures that a background task executor is created. Without it, nothing gets scheduled.

####To run 2 SPring APps with Diff Ports
Just implement the below th WebServerFactoryCustomizer interface:
```
@Component
public class ServerPortCustomizer 
  implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
  
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8086);
    }
}
```

Dont forget the below for REst Consumption (using WebCLient and Mono)
```$xslt
<!--    FOR REST CONSUMPTION    -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectreactor</groupId>
            <artifactId>reactor-spring</artifactId>
            <version>1.0.1.RELEASE</version>
        </dependency>
        <!--    FOR REST CONSUMPTION    -->
```