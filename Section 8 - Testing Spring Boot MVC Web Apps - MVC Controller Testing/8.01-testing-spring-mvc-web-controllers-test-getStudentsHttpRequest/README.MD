Development Process (Step-By-Step)
1. Add annotation @AutoConfigureMockMvc
2. Inject the MockMvc
3. Perform web requests
4. Define expectations
5. Assert results

8.00-testing-spring-mvc-web-controllers-test-setup
```
💥 GradebookControllerTest.java

Step 1: Add annotation @AutoConfigureMockMvc
Step 2: Inject the MockMvc
```

8.01-testing-spring-mvc-web-controllers-test-getStudentsHttpRequest

```java
@Test
public void getStudentsHttpRequest() throws Exception {
    CollegeStudent studentOne = new CollegeStudent("Eric","Roby", "eric.roby@luv2code_school.com");
    CollegeStudent studentTwo= new CollegeStudent("Chad","Darby", "chad.darby@luv2code_school.com");

    List<CollegeStudent> collegeStudentList = List.of(studentOne, studentTwo);

    when(studentAndGradeServiceMock.getGradeBook()).thenReturn(collegeStudentList);

    assertIterableEquals(collegeStudentList, studentAndGradeServiceMock.getGradeBook());
}
```