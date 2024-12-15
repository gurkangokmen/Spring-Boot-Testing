
# Code Coverage with Maven - Part  1
```
Apache Maven Version: 3.9.8
Java version: 21
```


Command: clean the project (delete the target directory) and then run the tests in the project
```
mvn clean test
```
The Maven Surefire plugin is included with Maven by default.


```
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
![Screenshot 2024-03-08 122727](https://github.com/gurkangokmen/algorithms/assets/122023578/fd4d058c-b443-4de8-8e24-5602ee8de7d7)

The Maven Surefire plugin is added manually!
```
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



# Code Coverage with Maven - Part  2

The Maven Surefire report plugin is added.

```
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

# Code Coverage with Maven - Part  3

By default, Maven Surefire plugin will NOT generate reports if tests fail

```
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

# Code Coverage with Maven - Part  4

By default, Maven Surefire plugin will NOT show @DisplayName in reports

https://maven.apache.org/surefire/maven-surefire-plugin/examples/junit-platform.html


```
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


# Code Coverage with Maven - Part  5

JaCoCo provides a Maven plugin to generate code coverage reports

File: target/site/jacoco/index.html

```
mvn clean test //RUN THIS ONLY ON TERMINAL OR COMMAND PROMPT
```

```
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

