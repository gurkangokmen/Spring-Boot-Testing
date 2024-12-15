<H1>EDIT ENVIRONMENT VARIABLE</H1>
![Screenshot 2024-10-23 224915](https://github.com/user-attachments/assets/7656f5ff-f7be-4f8a-9b9a-6758fbf7c7de)


```java
@Test
@EnabledIfEnvironmentVariable(named="LUV2CODE_ENV", matches="DEV")
void testOnlyForDevEnvironment() {
// execute method and perform asserts
}
```




<H1>EDIT SYSTEM PROPERTY</H1>
![Screenshot 2024-10-23 225518](https://github.com/user-attachments/assets/29156feb-dbdf-4b75-981f-e69682bc79f2)
![Screenshot 2024-10-23 225643](https://github.com/user-attachments/assets/e956f5bf-788c-4c4e-bf51-ec2931474895)


```java
@Test
@EnabledIfSystemProperty(named="LUV2CODE_SYS_PROP", matches="CI_CD_DEPLOY")
void testOnlyForSystemProperty() {
    // execute method and perform asserts
}
```