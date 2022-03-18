package de.renatius.tipps;

import java.util.logging.Logger;

@SuppressWarnings("java:S2629")
public class IntroExample {
    // tag::contains[]
    private static int callCounter = 0;
    private final Logger logger;
    private final StringUtil util;

    public IntroExample(Logger logger, StringUtil dependency) {
        this.logger = logger;
        this.util = dependency;
    }

    public static int getCallCounter() {
        return callCounter;
    }

    public String wrapTransform(String input) {
        callCounter++;
        final String transformed = util.transform(input);
        logger.info("transform: " + input + " into:" + transformed);
        logger.info("call counter: " + callCounter);
        return transformed;
    }

    interface StringUtil {
        String transform(String information);
    }
    // end::contains[]
}
