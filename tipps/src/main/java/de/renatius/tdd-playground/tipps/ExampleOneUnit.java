package de.renatius.tipps;

import java.util.Objects;

public class ExampleOneUnit {
    // tag::contains[]
    public boolean noneNullEquals(String first, String second) {
        if (Objects.isNull(first) || Objects.isNull(second)) {
            throw new IllegalArgumentException("Input can't be 'null'!");
        }
        return first.equals(second);
    }
    // end::contains[]
}
