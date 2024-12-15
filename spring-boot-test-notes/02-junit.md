# JUnit

## Table of Contents

* [Test Methods](#test-methods)
    * [Assert Equals](#assert-equals)
    * [Assert Not Equals](#assert-not-equals)
    * [Assert Null](#assert-null)
    * [Assert Not Null](#assert-not-null)
    * [Assert Same](#assert-same)
    * [Assert Not Same](#assert-not-same)
    * [Assert True](#assert-true)
    * [Assert False](#assert-false)
    * [Assert Array Equals](#assert-array-equals)
    * [Assert Iterable Equals](#assert-iterable-equals)
    * [Assert Lines Match](#assert-lines-match)
    * [Assert Throws](#assert-throws)
    * [Assert Does Not Throw](#assert-does-not-throw)
    * [Assert Timeout Preemptively](#assert-timeout-preemptively)
* [Test Lifecycle](#test-lifecycle)
* [JUnit Custom Display Names](#junit-custom-display-names)
    * [@DisplayName](#displayname)
    * [@DisplayNameGeneration](#displaynamegeneration)
* [Order (@TestMethodOrder)](#order-testmethodorder)
* [Code Coverage](#code-coverage)
    * [Intellij](#intellij)
    * [Apache Maven](#apache-maven)
        * [Part 1](#part-1)
        * [Part 2](#part-2)
        * [Part 3](#part-3)
        * [Part 4](#part-4)
        * [Part 5](#part-5)
* [Conditional Test](#code-coverage)
    * [@Disabled](#disabled)
    * [@EnabledOnOs(OS.WINDOWS)](#enabledonososwindows)
    * [@EnabledOnOs(OS.MAC)](#enabledonososmac)
    * [@EnabledOnOs({OS.MAC, OS.WINDOWS})](#enabledonososmac-oswindows)
    * [@EnabledOnOs(OS.LINUX)](#enabledonososlinux)
    * [@EnabledOnJre(JRE.JAVA_17)](#enabledonjrejrejava_17)
    * [@EnabledForJreRange(min=JRE.JAVA_13, max=JRE.JAVA_18)](#enabledforjrerangeminjrejava_13-maxjrejava_18)
    * [@EnabledForJreRange(min=JRE.JAVA_11)](#enabledforjrerangeminjrejava_11)
    * [@EnabledIfEnvironmentVariable(named="LUV2CODE_ENV", matches="DEV")](#enabledifenvironmentvariablenamedluv2code_env-matchesdev)
    * [@EnabledIfSystemProperty(named="LUV2CODE_SYS_PROP", matches="CI_CD_DEPLOY")](#enabledifsystempropertynamedluv2code_sys_prop-matchesci_cd_deploy)


## Test Methods

### Assert Equals

```java
assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
```

### Assert Not Equals

```java
assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
```

### Assert Null

```java
assertNull(demoUtils.checkNull(str1), "Object should be null");
```

### Assert Not Null

```java
assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
```

### Assert Same

```java

...
private String academy = "Luv2Code Academy";
private String academyDuplicate = academy;
...

assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
```

### Assert Not Same

```java

...

String str = "luv2code";
private String academy = "Luv2Code Academy";
...

assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
```


### Assert True

```java
int gradeOne = 10;
int gradeTwo = 5;

assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
```

### Assert False

```java
int gradeOne = 10;
int gradeTwo = 5;

assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
```

### Assert Array Equals

```java
String[] stringArray = {"A", "B", "C"};

assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
```

### Assert Iterable Equals

```java
List<String> theList = List.of("luv", "2", "code");

assertIterableEquals(theList, demoUtils.getAcademyInList(), "Expected list should be same as actual list");
```

### Assert Lines Match

`Regex`
`https://www.udemy.com/course/spring-boot-unit-testing/learn/lecture/30016322#questions/18459552`
```java
List<String> theList = List.of("luv", "2", "code");
assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");
```

### Assert Throws

```java
assertThrows(Exception.class, () -> { demoUtils.throwException(-1); }, "Should throw exception");
```
### Assert Does Not Throw

```java
assertDoesNotThrow(() -> { demoUtils.throwException(5); }, "Should not throw exception");
```

### Assert Timeout Preemptively

```java
// Assert that an executable completes
// before given timeout is exceeded
assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout(); },
                "Method should execute in 3 seconds");
```

## Test Lifecycle

```java
@BeforeEach → Run before each test (should be non-static)
@AfterEach → Run after each test (should be non-static)
@BeforeAll → Run once before all test (By default, methods must be static)
@AfterAll → Run once after all test (By default, methods must be static)
```

```java
package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    //
    // Run before each test
    //
    @BeforeEach
    void setupBeforeEach() {
        //
        // Create object before each test
        //

        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
    }

    //
    // Run after each test
    //
    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @AfterEach");
        System.out.println();
    }

    //
    // Run once before all test
    // By default, methods must be static
    //
    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }

    //
    // Run once after all test
    // By default, methods must be static
    //
    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }


    @Test
    void testEqualsAndNotEquals() {

        System.out.println("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    void testNullAndNotNull() {

        System.out.println("Running test: testNullAndNotNull");

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

    }

}
```

## JUnit Custom Display Names

### @DisplayName

```java
Note: If you use both of them (@DisplayNameGeneration and @DisplayName), @DisplayName is dominant
```

```java
@Test
@DisplayName("Equals and Not Equals!")
void testEqualsAndNotEquals() {

    assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
    assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
}
```


### @DisplayNameGeneration

```java
Note: If you use both of them (@DisplayNameGeneration and @DisplayName), @DisplayName is dominant
```

```java
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // Replaces underscores in test method name with spaces
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class) // Removes trailing parentheses from test method name
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class) // Generate sentence based on test class name and test method name
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    
    void testEqualsAndNotEquals() {

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }
}
```

## Order (@TestMethodOrder)

| Name         | Description                    | 
| --------------- | ------------------------------ |
| `MethodOrderer.DisplayName`   | Sorts test methods alphanumerically based on display names   |
| `MethodOrderer.MethodName`   | Sorts test methods alphanumerically based on method names   |
| `MethodOrderer.Random`   | Pseudo-random order based on method names   |
| `MethodOrderer.OrderAnnotation`   | Sorts test methods numerically based on @Order annotation   |

## Code Coverage

### Intellij

![Screenshot 2024-10-22 174827](https://github.com/user-attachments/assets/ed0f16f8-57f4-4b1a-a0cf-f334cc964a40)


### Apache Maven

#### Part 1 
```
Apache Maven Version: 3.9.8 (https://downloads.apache.org/maven/maven-3/3.9.8/binaries/ https://www.youtube.com/watch?v=YTvlb6eny_0)
Java version: 21
```

Command: clean the project (delete the target directory) and then run the tests in the project
```
mvn clean test
```
The Maven Surefire plugin is included with Maven by default.


```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.luv2code</groupId>
    <artifactId>junitdemo</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

</project>
```
![Screenshot 2024-10-22 174418](https://github.com/user-attachments/assets/7a7d1e30-f829-467a-8377-73116ab2d5e0)

The Maven Surefire plugin is added manually!
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.luv2code</groupId>
    <artifactId>junitdemo</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
            </plugin>
        </plugins>
    </build>


</project>
```
![Screenshot 2024-03-08 123613](https://github.com/gurkangokmen/algorithms/assets/122023578/e165c7ec-ff73-470d-a18f-c9ed756deda1)

#### Part 2

The Maven Surefire report plugin is added.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.luv2code</groupId>
    <artifactId>junitdemo</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-report-plugin</artifactId>
                <version>3.0.0-M5</version>


                <executions>

                    <!-- During Maven's test phase,-->
                    <!-- execute the plugin goal -->
                    <!-- maven-surefire-report-plugin:report-->
                    <execution>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>

                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>

```
![Screenshot 2024-07-25 075601](https://github.com/user-attachments/assets/adb2c667-1c14-476f-826b-d86bb72c32f3)
![Screenshot 2024-07-25 075915](https://github.com/user-attachments/assets/e763b551-244b-4915-94d2-51c4b27650ca)
![Screenshot 2024-07-25 075930](https://github.com/user-attachments/assets/268eb4e5-6340-482f-bc72-850b17217a22)


#### Part 3

By default, Maven Surefire plugin will NOT generate reports if tests fail

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.luv2code</groupId>
    <artifactId>junitdemo</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <!-- By default, Maven Surefire plugin will NOT generate reports if tests fail -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>

                <!-- Generate Reports if tests pass or fail-->
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-report-plugin</artifactId>
                <version>3.0.0-M5</version>


                <executions>

                    <!-- During Maven's test phase,-->
                    <!-- execute the plugin goal -->
                    <!-- maven-surefire-report-plugin:report-->
                    <execution>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>

                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

![Screenshot 2024-07-25 185443](https://github.com/user-attachments/assets/4bfb2c50-93e6-4922-b8dc-3d799a414634)
![Screenshot 2024-07-25 185456](https://github.com/user-attachments/assets/74fd00b6-1cea-459b-99db-59a15f46fdbc)


#### Part 4

By default, Maven Surefire plugin will NOT show @DisplayName in reports

https://maven.apache.org/surefire/maven-surefire-plugin/examples/junit-platform.html

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.luv2code</groupId>
    <artifactId>junitdemo</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <!-- By default, Maven Surefire plugin will NOT generate reports if tests fail -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>

                <!-- Generate Reports if tests pass or fail-->
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>

                    <!-- By default, Maven Surefire plugin will NOT show @DisplayName in reports -->
                    <statelessTestsetReporter implementation="org.apache.maven.plugin.surefire.extensions.junit5.JUnit5Xml30StatelessReporter">
                        <usePhrasedTestCaseMethodName>true</usePhrasedTestCaseMethodName> <!-- true: Show @DisplayName -->
                    </statelessTestsetReporter>


                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-report-plugin</artifactId>
                <version>3.0.0-M5</version>


                <executions>

                    <!-- During Maven's test phase,-->
                    <!-- execute the plugin goal -->
                    <!-- maven-surefire-report-plugin:report-->
                    <execution>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>

                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

![Screenshot 2024-07-26 071543](https://github.com/user-attachments/assets/d45f82f1-440a-48f0-8c56-ed7e0cc729ff)
![Screenshot 2024-07-26 071558](https://github.com/user-attachments/assets/a46cd0cb-27c3-4256-897e-7dbf11bafc5e)

#### Part 5

JaCoCo provides a Maven plugin to generate code coverage reports

File: target/site/jacoco/index.html

```
mvn clean test //RUN THIS ONLY ON TERMINAL OR COMMAND PROMPT
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.luv2code</groupId>
    <artifactId>junitdemo</artifactId>
    <version>1.0</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <!-- By default, Maven Surefire plugin will NOT generate reports if tests fail -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>

                <!-- Generate Reports if tests pass or fail-->
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>

                    <!-- By default, Maven Surefire plugin will NOT show @DisplayName in reports -->
                    <statelessTestsetReporter implementation="org.apache.maven.plugin.surefire.extensions.junit5.JUnit5Xml30StatelessReporter">
                        <usePhrasedTestCaseMethodName>true</usePhrasedTestCaseMethodName> <!-- true: Show @DisplayName -->
                    </statelessTestsetReporter>


                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-report-plugin</artifactId>
                <version>3.0.0-M5</version>


                <executions>

                    <!-- During Maven's test phase,-->
                    <!-- execute the plugin goal -->
                    <!-- maven-surefire-report-plugin:report-->
                    <execution>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>

                    </execution>
                </executions>
            </plugin>




            <!-- JaCoCo is a free code coverage library -->
            <!-- Ja: Java -->
            <!-- Co: Code -->
            <!-- Co: Coverage -->


            <!-- JaCoCo provides a Maven plugin to generate code coverage reports -->

            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.7</version>

                <executions>
                    <execution>
                        <id>jacoco-prepare</id>
                        <goals>
                            <!-- Prepare JaCoCo agent -->
                            <!-- This goal is bound by default to Maven's initialize phase -->
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>


                    <!-- During Maven's test phase -->
                    <!-- execute the plugin goal -->
                    <!-- jacoco-maven-plugin:report -->
                    <execution>
                        <id>jacoco-report</id>
                        <phase>test</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>


</project>
```
![Screenshot 2024-07-26 072122](https://github.com/user-attachments/assets/2bc10370-0ce7-453c-8db0-b5e1ff134b1d)
![Screenshot 2024-07-26 072131](https://github.com/user-attachments/assets/7d6ac8f3-80ee-477a-812c-afb0f1167cb6)
![Screenshot 2024-07-26 072147](https://github.com/user-attachments/assets/13db7981-4d1a-4112-9a67-bd0e28692cde)
![Screenshot 2024-07-26 072208](https://github.com/user-attachments/assets/4153138b-0e46-4a93-8cd1-551d63e0c9ff)
![Screenshot 2024-07-26 072358](https://github.com/user-attachments/assets/ef4dfe23-73ce-4467-b60b-151dac4c940b)

## Conditional Test

### @Disabled

```java
@Test
@Disabled("Don't run until JIRA #123 is resolved")
void basicTest() {
    // execute method and perform asserts
}
```

### @EnabledOnOs(OS.WINDOWS)

```java
@Test
@EnabledOnOs(OS.WINDOWS)
void testForWindowsOnly() {
    // execute method and perform asserts
}
```

### @EnabledOnOs(OS.MAC)

```java
@Test
@EnabledOnOs(OS.MAC)
void testForMacOnly() {
    // execute method and perform asserts
}
```

### @EnabledOnOs({OS.MAC, OS.WINDOWS})

```java
@Test
@EnabledOnOs({OS.MAC, OS.WINDOWS})
void testForMacAndWindowsOnly() {
    // execute method and perform asserts
}
```

### @EnabledOnOs(OS.LINUX)

```java
@Test
@EnabledOnOs(OS.LINUX)
void testForLinuxOnly() {
    // execute method and perform asserts
}
```

### @EnabledOnJre(JRE.JAVA_17)

```java
@Test
@EnabledOnJre(JRE.JAVA_17)
void testForOnlyForJava17() {
    // execute method and perform asserts
}
```

### @EnabledForJreRange(min=JRE.JAVA_13, max=JRE.JAVA_18)

```java
@Test
@EnabledForJreRange(min=JRE.JAVA_13, max=JRE.JAVA_18)
void testOnlyForJavaRange() {
    // execute method and perform asserts
}   
```

### @EnabledForJreRange(min=JRE.JAVA_11)

```java
@Test
@EnabledForJreRange(min=JRE.JAVA_11)
void testOnlyForJavaRangeMin() {
    // execute method and perform asserts
}
```

### @EnabledIfEnvironmentVariable(named="LUV2CODE_ENV", matches="DEV")

```java
@Test
@EnabledIfEnvironmentVariable(named="LUV2CODE_ENV", matches="DEV")
void testOnlyForDevEnvironment() {
    // execute method and perform asserts
}
```


### @EnabledIfSystemProperty(named="LUV2CODE_SYS_PROP", matches="CI_CD_DEPLOY")

```java
@Test
@EnabledIfSystemProperty(named="LUV2CODE_SYS_PROP", matches="CI_CD_DEPLOY")
void testOnlyForSystemProperty() {
    // execute method and perform asserts
}
```