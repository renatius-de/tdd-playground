package de.renatius.tipps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleOneUnitTest {
    private de.renatius.tipps.ExampleOneUnit exampleOneUnit;

    @BeforeEach
    void setUp() {
        exampleOneUnit = new de.renatius.tipps.ExampleOneUnit();
    }

    // tag::contains[]
    @Test
    void firstParameterIsNull() {
        assertThrows(IllegalArgumentException.class,() -> exampleOneUnit.noneNullEquals(null, "second"));
    }
    @Test
    void secondParameterIsNull() {
        assertThrows(IllegalArgumentException.class,() -> exampleOneUnit.noneNullEquals("first", null));
    }
    @Test
    void bothParametersAreNull() {
        assertThrows(IllegalArgumentException.class, () -> exampleOneUnit.noneNullEquals(null, null));
    }
    @Test
    void firstIsEqualToSecond() {
        assertTrue(exampleOneUnit.noneNullEquals("equals", "equals"));
    }
    @Test
    void firstIsNotEqualToSecond() {
        assertFalse(exampleOneUnit.noneNullEquals("equals", "not equals"));
    }
    // end::contains[]
}
