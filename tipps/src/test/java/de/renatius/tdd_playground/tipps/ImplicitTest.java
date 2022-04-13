package de.renatius.tdd_playground.tipps;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SuppressWarnings({"java:S2699"})
class ImplicitTest {
    private final Implicit.Dependency dependency = mock(Implicit.Dependency.class);
    private final Implicit objectUnderTest = new Implicit(dependency);

    @Test
    void some_method_returns_string() {
        // tag::bad_example[]
        when(dependency.someMethod(new Object(), Integer.valueOf("123"))).thenReturn("Foo Bar Baz");
        // end::bad_example[]
    }

    @Test
    void another_method_return_string() {
        // tag::good_example[]
        when(dependency.someMethod(any(), any())).thenReturn("Foo Bar Baz");

        objectUnderTest.someOtherMethod(123);

        verify(dependency).someMethod(any(Object.class), eq(123));
        // end::good_example[]
    }
}
