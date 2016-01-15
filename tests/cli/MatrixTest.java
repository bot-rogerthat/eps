package cli;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void testGetColumn() throws Exception {
        Matrix matrix = new Matrix(2, 3, 1);
        assertEquals(matrix.getColumn(), 3);
    }

    @Test
    public void testGetRow() throws Exception {
        Matrix matrix = new Matrix(2, 3, 1);
        assertEquals(matrix.getRow(), 2);
    }

    @Test
    public void testGetElement() throws Exception {
        Matrix matrix = new Matrix(2, 3, 1);
        assertEquals(matrix.getElement(1, 1), "|X|");
    }

    @Test
    public void testSetElement() throws Exception {
        Matrix matrix = new Matrix(2, 3, 1);
        matrix.setElement(1, 1, " - ");
        assertEquals(matrix.getElement(1, 1), " - ");
    }
}