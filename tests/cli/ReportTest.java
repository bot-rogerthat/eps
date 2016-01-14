package cli;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReportTest {

    @Test
    public void testGetRiskGroupsReport() throws Exception {
        Report report = new Report(new Matrix(5, 5, 0));
        String result =  "Risk groups report:\r\n----------------------------------------------------\r\n";
        assertEquals(report.getRiskGroupsReport(), result);
    }
}