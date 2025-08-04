# Testing Spring Boot MVC Web Apps - Database Integration Testing


## Table of Contents

* [Annotations](#annotations)
* [H2 Database (in-memory, embedded db)](#h2-database-in-memory-embedded-db)
* [Database Initialization and Cleanup](#private-fields)
* [Test with @Sql](#test-with-sql)

## Annotations

```java
@TestPropertySource("/application.properties")
```

```
The @TestPropertySource annotation in Spring Boot is used to configure the locations of properties files specific to tests. It helps in overriding the default properties or adding additional properties for the test environment. This is particularly useful when you want to have different configurations for your tests compared to your main application.
```

## H2 Database (in-memory, embedded db)

```
• In-memory, embedded db is good for testing

• Quickly set up and tear down

• No network latency so tests run faster

• Minimizes left over data in the database
```

## Database Initialization and Cleanup

```
⭐ When we are performing integration testing with a database
    ➡️ Each test should run from a known state

⭐ Before each test, perform initialization
    ➡️ Insert sample data

⭐ After each test, perform cleanup
    ➡️ Delete the sample data
```

![Screenshot 2024-12-19 210556](https://github.com/user-attachments/assets/d44c29f4-4cd0-4e27-8190-4ff8048f4eed)


![Screenshot 2024-12-19 210700](https://github.com/user-attachments/assets/44ab21ca-63b3-4639-ade7-e1eb3ef3aef8)

![Screenshot 2024-12-19 210746](https://github.com/user-attachments/assets/a3d70d0e-90c0-418d-bb69-c0413819ffbb)

## Test with @Sql

```java

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @BeforeEach
    public void setupDatabase() {
        jdbc.execute("insert into student (id, firstname, lastname, email_address) " +
                "values (1, 'Eric', 'Roby', 'eric.roby@luv2code_school.com')");
    }


    // Execute the SQL before the test method
    // The @BeforeEach will execute first Then it will execute @Sql
    @Sql("/insertData.sql")
    @Test
    public void getGradeBookService(){
        Iterable<CollegeStudent> iterableCollegeStudents = studentService.getGradeBook();
        List<CollegeStudent> collegeStudents = new ArrayList<>();

        for (CollegeStudent collegeStudent : iterableCollegeStudents) {
            collegeStudents.add(collegeStudent);
        }

        // Test passes because we have 5 students in the database
        // 1 from @BeforeEach
        // 4 from @Sql("insertData")
        assertEquals(5, collegeStudents.size());
    }

}
```