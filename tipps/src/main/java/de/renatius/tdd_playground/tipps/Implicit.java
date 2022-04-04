package de.renatius.tdd_playground.tipps;

@SuppressWarnings({"java:S1854", "unused"})
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
    public static class Dependency {
        public String someMethod(final Object object, final Integer integer) {
            return "lid";
        }
    }
}
