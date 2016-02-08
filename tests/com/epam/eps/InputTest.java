package com.epam.eps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class InputTest {
    public Input input;

    @Before
    public void setUp() {
        input = new Input(3, 5, 0.5);
    }

    @After
    public void tearDown() {
        input = null;
    }

    @Test
    public void testGetHeight() throws Exception {
        assertEquals(input.getFillFactor(), 0.5);
    }

    @Test
    public void testGetWidth() throws Exception {
        assertEquals(input.getHeight(), 3);
    }

    @Test
    public void testGetFillFactor() throws Exception {
        assertEquals(input.getWidth(), 5);
    }
}