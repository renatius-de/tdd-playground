package de.renatius.tdd_playground.tipps;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ImplicitTest {
    private final Implicit.Dependency dependency = mock(Implicit.Dependency.class);
    private final Implicit implicit = mock(Implicit.class);

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

        verify(dependency).someMethod(new Object(), 123);
        // end::good_example[]
    }
}
