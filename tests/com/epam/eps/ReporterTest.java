package com.epam.eps;

import com.epam.eps.sector.Sector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReporterTest {
    public Reporter reporter;

    @Before
    public void setUp() throws Exception {
        reporter = new Reporter();
    }

    @After
    public void tearDown() throws Exception {
        reporter = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetReportForNull() throws Exception {
        reporter.getReport(null, 0, null, null);
    }

    @Test
    public void testGetReportForResult() throws Exception {
        List<RiskGroup> groupOfRisk = Arrays.asList(new RiskGroup("NONE", 1, 2));
        Map<RiskGroup, Integer> foundGroups = new HashMap<>();
        foundGroups.put(new RiskGroup("NONE", 1, 2), 0);
        String result = "Emergency Prevention System\n" +
                "----------------------------------------------------\n" +
                "m = 2, n = 2, f = 0.0\n" +
                "NONE = {1, 2}\n" +
                "----------------------------------------------------\n" +
                " -  - \n" +
                " -  - \n" +
                "\n" +
                "Risk groups report: \n" +
                "----------------------------------------------------\n" +
                "NONE: 0 groups;\n";

        assertEquals(reporter.getReport(new Sector(2, 2), 0, foundGroups, groupOfRisk), result);
    }
}