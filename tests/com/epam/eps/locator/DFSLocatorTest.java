package com.epam.eps.locator;

import com.epam.eps.RiskGroup;
import com.epam.eps.sector.Cell;
import com.epam.eps.sector.Sector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DFSLocatorTest {
    public DFSLocator locator;
    public List<RiskGroup> groupOfRisk;
    public Sector sector;
    public RiskGroup riskGroup;

    @Before
    public void setUp() throws Exception {
        riskGroup = new RiskGroup("NONE", 1, 2);
        groupOfRisk = Arrays.asList(riskGroup);
        sector = new Sector(2, 2);
        sector.setElement(0, 0, Cell.HUMAN);
        sector.setElement(0, 1, Cell.EMPTY);
        sector.setElement(1, 0, Cell.EMPTY);
        sector.setElement(1, 1, Cell.HUMAN);
        locator = new DFSLocator(sector, groupOfRisk);
    }

    @After
    public void tearDown() throws Exception {
        groupOfRisk = null;
        sector = null;
        locator = null;
    }

    @Test
    public void testFind() throws Exception {
        HashMap<RiskGroup, Integer> result = new HashMap<>();
        result.put(riskGroup, 2);
        assertEquals(locator.find(), result);
    }
}