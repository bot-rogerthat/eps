package cli;

public class Matrix {
    private int row;
    private int column;
    private String[][] matrix;
    private double fillFactor;

    public Matrix(int row, int column, double fillFactor) {
        this.row = row;
        this.column = column;
        this.fillFactor = fillFactor;
        this.matrix = new String[row][column];
        fill();
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getElement(int i, int j) {
        try {
            return matrix[i][j];
        } catch (Exception e) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

    }

    public void setElement(int i, int j, String element) {
        try {
            matrix[i][j] = element;
        } catch (Exception e) {
            throw new RuntimeException("Illegal matrix dimensions.");
        }

    }

    private void fill() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String rand = (Math.random() < fillFactor) ? "|X|" : " - ";
                matrix[i][j] = rand;
            }
        }
    }

    @Override
    public Matrix clone() {
        Matrix clone = new Matrix(row, column, fillFactor);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                clone.setElement(i, j, this.getElement(i, j));
            }
        }
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("m = ").append(row).append(", n = ").append(column).append(", f = ").append(fillFactor).append("\r\n");
        sb.append("----------------------------------------------------\r\n");
        drawMatrix(sb);
        return sb.toString();
    }

    private void drawMatrix(StringBuilder sb) {
        for (String[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(aMatrix[j]);
            }
            sb.append("\r\n");
        }
    }
}
