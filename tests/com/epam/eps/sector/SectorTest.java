package com.epam.eps.sector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SectorTest {
    public Sector sector;

    @Before
    public void setUp() throws Exception {
        sector = new Sector(2, 2);
    }

    @After
    public void tearDown() throws Exception {
        sector = null;
    }

    @Test
    public void testGetElement() throws Exception {
        assertEquals(sector.getElement(0, 0), null);
        sector.setElement(0, 0, Cell.EMPTY);
        assertEquals(sector.getElement(0, 0), Cell.EMPTY);
    }

    @Test
    public void testSetElement() throws Exception {
        sector.setElement(0, 0, Cell.EMPTY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementForOutOfBound() throws Exception {
        sector.setElement(3, 3, Cell.EMPTY);
    }
}