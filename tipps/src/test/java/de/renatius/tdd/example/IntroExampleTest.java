package de.renatius.tdd.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.logging.Logger;

@SuppressWarnings("java:S6068")
class IntroExampleTest {
    // tag::contains[]
    @Test
    void test0() {
        Logger logger = Mockito.mock(Logger.class);
        IntroExample.StringUtil stringUtil = Mockito.mock(IntroExample.StringUtil.class);
        IntroExample example = new IntroExample(logger, stringUtil);

        Mockito.when(stringUtil.transform(ArgumentMatchers.eq("input 1"))).thenReturn("test 1");

        String transformed = example.wrapTransform("input 1");
        int callCounter = IntroExample.getCallCounter();

        Mockito.verify(logger, Mockito.atLeastOnce()).info(ArgumentMatchers.anyString());

        Assertions.assertNotNull(transformed);
        Assertions.assertNotEquals(callCounter, 0);
    }

    @Test
    void test1() {
        Logger logger = Mockito.mock(Logger.class);
        IntroExample.StringUtil stringUtil = Mockito.mock(IntroExample.StringUtil.class);
        IntroExample example = new IntroExample(logger, stringUtil);

        Mockito.when(stringUtil.transform(ArgumentMatchers.eq("input 2"))).thenReturn("result 2");

        String transformed = example.wrapTransform("input 3");
        int callCounter = IntroExample.getCallCounter();

        Mockito.verify(logger, Mockito.atLeastOnce()).info(ArgumentMatchers.anyString());

        Assertions.assertNull(transformed);
        Assertions.assertNotEquals(callCounter, 0);
    }
    // end::contains[]
}
