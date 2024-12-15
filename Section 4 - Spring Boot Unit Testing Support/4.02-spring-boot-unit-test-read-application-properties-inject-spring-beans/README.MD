mvn dependency:tree


<!-- Starter Includes a transitive dependency on JUnit 5 - We get it for free :-) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <!-- Set the scope to test, because we only want to use this given dependency when we're testing the application. -->
    <scope>test</scope>
</dependency>