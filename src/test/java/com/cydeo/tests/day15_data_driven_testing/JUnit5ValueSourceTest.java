package com.cydeo.tests.day15_data_driven_testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class JUnit5ValueSourceTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 23, 90, 33, 64, 10986, 456})
    public void numbersTest(int num) {
        System.out.println("num = " + num);
        assertThat(num , is(greaterThan(0)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Vugar", "Shina", "Dzerassa", "Eda", "Kevin","","Nadir"} )
    public void testNames(String name) {
        System.out.println("Hi! "+ name);
        assertThat(name, not(blankOrNullString()));
    }

    @ParameterizedTest
    @ValueSource(ints = {22102, 22031, 22034, 11209, 15090, 15237,12345,20879,21224,33433})
    public void zipCodeTest(int zipCode) {

    }


}
