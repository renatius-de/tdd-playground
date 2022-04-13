package de.renatius.tdd_playground.tipps;

@SuppressWarnings({"ClassCanBeRecord", "java:S1854", "unused", "UnusedReturnValue"})
public class Implicit {
    private final Dependency dependency;

    public Implicit(Dependency dependency) {
        this.dependency = dependency;
    }

    public int someOtherMethod(final int i) {
        String s = dependency.someMethod(new Object(), i);

        return i;
    }

    @SuppressWarnings({"java:S1172", "java:S3400"})
    public interface Dependency {
        String someMethod(final Object object, final Integer integer);
    }
}
