package com.epam.eps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    public Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @After
    public void tearDown() throws Exception {
        parser = null;
    }

    @Test
    public void testParseForNull() throws Exception {
        assertEquals(parser.parse(null), new Input(0, 0, 0.0));
    }

    @Test
    public void testParseForInvalidArgs() throws Exception {
        assertEquals(parser.parse(new String[]{""}), new Input(0, 0, 0.0));
        assertEquals(parser.parse(new String[]{"1"}), new Input(0, 0, 0.0));
    }

    @Test
    public void testParseIsResult() throws Exception {
        assertEquals(parser.parse(new String[]{"-m", "1", "-n", "1", "-f", "1.0"}), new Input(1, 1, 1.0));
    }
}