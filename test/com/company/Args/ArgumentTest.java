package com.company.Args;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentTest {
    private Argument argument = new Argument("l", "9090");

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getValue() {
        assertEquals(Integer.toString(9090), argument.getValue());
    }

    @Test
    public void getFlag() {
        assertEquals("l", argument.getFlag());
    }
}