# ReflectionTestUtils


## Table of Contents
* [Use Case](#use-case)
* [Private Fields](#private-fields)
    * [Reading Private Fields](#reading-private-fields)
    * [Setting Private Fields](#setting-private-fields)
* [Private Methods](#private-methods)
    * [Invoking Private Methods](#invoking-private-methods)


## Use Case

```
⭐ Need to access non-public fields

⭐ Invoke non-public methods
```

## Private Fields

### Reading Private Fields

```java
public class CollegeStudent implements Student {
 private int id;
 ...
}
```

```java
CollegeStudent theStudent = (CollegeStudent) context.getBean("collegeStudent");
ReflectionTestUtils.getField(theStudent, "id");
```

### Setting Private Fields

```java
public class CollegeStudent implements Student {
 private int id;
 ...
}
```

```java
CollegeStudent theStudent = (CollegeStudent) context.getBean("collegeStudent");
ReflectionTestUtils.setField(theStudent, "id", 1);
```

## Private Methods

### Invoking Private Methods

```java
public class CollegeStudent implements Student {
 ...
 private String getFirstNameAndId() {
 return getFirstname() + " " + getId();
 }
}
```
```java
CollegeStudent theStudent = (CollegeStudent) context.getBean("collegeStudent");
ReflectionTestUtils.invokeMethod(theStudent, "getFirstNameAndId");
```