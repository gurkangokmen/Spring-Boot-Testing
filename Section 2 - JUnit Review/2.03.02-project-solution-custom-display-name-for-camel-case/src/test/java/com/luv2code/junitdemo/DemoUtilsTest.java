package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/*
    Note:
    If you use both of them (@DisplayNameGeneration and @DisplayName), @DisplayName is dominant
 */


//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // Replaces underscores in test method name with spaces
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class) // Removes trailing parentheses from test method name
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class) // Generate sentence based on test class name and test method name
@DisplayNameGeneration(ReplaceCamelCase.class) // camel case diplay name
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    //@DisplayName("Equals and Not Equals!")
    void testEqualsAndNotEquals() {

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    // @DisplayName("Null and Not Null")
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "luv2code";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

    }

    /*
    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Running @AfterEach");
        System.out.println();
    }

    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("@AfterAll executes only once after all test methods execution in the class");
    }
    */
}






