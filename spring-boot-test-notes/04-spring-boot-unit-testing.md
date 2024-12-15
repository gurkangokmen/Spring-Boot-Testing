# Spring Boot Test

## Table of Contents
* [Dependency](#dependency)
* [Annotations](#annotations)
* [JUnit and Mockito](#junit-and-mockito)


## Dependency
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <!-- Set the scope to test, because we only want to use this given dependency when we're testing the application. -->
    <scope>test</scope>
</dependency>
```


## Annotations

```java
// Due to Different Package Names → classes= MvcTestingExampleApplication.class
@SpringBootTest(classes= MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    @Test
    void basicTest(){

    }

}
```

## JUnit and Mockito

```
spring-boot-starter test includes junit and mockito.
```