package com.cydeo.tests.day08_hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class HamcrestMatchersIntro {
    @Test
    public void numbersTest() {
        //MatcherAssert.assertThat( 1 + 3, Matchers.is(4));
        assertThat(1 + 3, is(4));
        assertThat(5 + 5, equalTo(10));
        assertThat(10 + 5, is(equalTo(15)));

        assertThat( 100 + 4, is(greaterThan(99)));
        //assertTrue(100 + 4 > 99); JUnit
    }
}
