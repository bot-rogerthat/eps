package cli;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReportTest {

    @Test
    public void testReport() throws Exception {
        Report report = new Report(new Matrix(5, 5, 0));
        String result = "m = 5, n = 5, f = 0.0\r\n" +
                "----------------------------------------------------\r\n" +
                " -  -  -  -  - \r\n" +
                " -  -  -  -  - \r\n" +
                " -  -  -  -  - \r\n" +
                " -  -  -  -  - \r\n" +
                " -  -  -  -  - \r\n" +
                "\r\n" +
                "Risk groups report:\r\n" +
                "----------------------------------------------------\r\n" +
                "NONE = 0 groups;\r\n" +
                "MINOR = 0 groups;\r\n" +
                "NORMAL = 0 groups;\r\n" +
                "MAJOR = 0 groups;\r\n" +
                "CRITICAL = 0 groups;\r\n";
        assertEquals(report.getReport(), result);
    }
}