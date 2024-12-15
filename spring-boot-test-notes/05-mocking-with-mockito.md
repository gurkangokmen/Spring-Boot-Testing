# Mocking with Mockito

## Table of Contents
* [Dependency](#dependency)
* [Testing Plan](#annotations)
* [Recap](#recap)
* [Steps](#steps)
    * [1. Create Mock for DAO](#1-create-mock-for-dao)
    * [2. Inject mock into Service](#2-inject-mock-into-service)
    * [3. Set up expectations](#3-set-up-expectations)
    * [4. Call method under test and assert results](#4-call-method-under-test-and-assert-results)
    * [5. Verify method calls](#5-verify-method-calls)

## Dependency

`Starter includes a transitive dependency on Mockito`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <!-- Set the scope to test, because we only want to use this given dependency when we're testing the application. -->
    <scope>test</scope>
</dependency>
```

## Testing Plan

![Screenshot 2024-11-04 081808](https://github.com/user-attachments/assets/6fe1bd05-adcc-45b2-af29-bac85be2254d)

## Recap

![Screenshot 2024-12-02 182436](https://github.com/user-attachments/assets/8f26e5f2-9bb0-4d33-8389-79a84e1b0ab4)

## Steps

### 1. Create Mock for DAO

![Screenshot 2024-11-04 083710](https://github.com/user-attachments/assets/16f252a0-a7d9-47ce-9465-9c4c6a268aa1)


### 2. Inject mock into Service

![Screenshot 2024-11-04 084035](https://github.com/user-attachments/assets/10652de1-5a58-4258-8350-50f03ed0beb7)

### 3. Set up expectations

![Screenshot 2024-12-02 181754](https://github.com/user-attachments/assets/6f7999f2-2cab-4eaa-a9c3-a0f7b81704f3)
![Screenshot 2024-12-02 181923](https://github.com/user-attachments/assets/33c90a3b-8cfa-4734-8105-e43a83d0405f)


### 4. Call method under test and assert results

![Screenshot 2024-12-02 182121](https://github.com/user-attachments/assets/0160249f-e045-4caf-9eb0-7c72b9e9c846)


### 5. Verify method calls

![Screenshot 2024-12-02 182219](https://github.com/user-attachments/assets/4444a658-4d98-4087-9c67-ea558dc22122)
