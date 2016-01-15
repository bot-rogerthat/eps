package cli;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void testParseForNull() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.parse(null), null);
    }

    @Test
    public void testParseForInvalidArgs() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.parse(new String[]{""}), null);
        assertEquals(parser.parse(new String[]{"1"}), null);
    }

    @Test
    public void testParseIsResult() throws Exception {
        Parser parser = new Parser();
        Matrix matrix = new Matrix(1, 1, 1);
        matrixEquals(parser.parse(new String[]{"-m", "1", "-n", "1", "-f", "1.0"}), matrix);
    }

    private boolean matrixEquals(Matrix first, Matrix second) {
        if (first.getColumn() == second.getColumn() && first.getRow() == second.getRow()) {
            for (int i = 0; i < first.getRow(); i++) {
                for (int j = 0; j < first.getColumn(); j++) {
                    if (first.getElement(i, j) == null || !first.getElement(i, j).equals(second.getElement(i, j))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}