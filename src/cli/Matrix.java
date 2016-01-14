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
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public String getElement(int i, int j) {
        return matrix[i][j];
    }

    public void setElement(int i, int j, String element) {
        matrix[i][j] = element;
    }

    public void fill() {
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
        sb.append(" ");
        for (int k = 0; k < matrix[0].length; k++) {
            sb.append("  ").append(k);
        }
        sb.append("\r\n");
        for (int i = 0; i < matrix.length; i++) {
            sb.append(i).append(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
