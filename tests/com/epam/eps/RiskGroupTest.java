package com.epam.eps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RiskGroupTest {
    public RiskGroup riskGroup;

    @Before
    public void setUp() throws Exception {
        riskGroup = new RiskGroup("abc", 1, 2);
    }

    @After
    public void tearDown() throws Exception {
        riskGroup = null;
    }

    @Test
    public void testSameSizeForTrue() throws Exception {
        assertTrue(riskGroup.sameSize(1));
        assertTrue(riskGroup.sameSize(2));
    }

    @Test
    public void testSameSizeForFalse() throws Exception {
        assertFalse(riskGroup.sameSize(0));
        assertFalse(riskGroup.sameSize(3));
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(riskGroup.getName(), "abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateRiskGroupForNullName() throws Exception {
        riskGroup = new RiskGroup(null, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateRiskGroupForWrongParams() throws Exception {
        riskGroup = new RiskGroup("a", 3, 2);
    }
}