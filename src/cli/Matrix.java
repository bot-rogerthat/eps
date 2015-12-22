package cli;

public class Matrix {
    private int row;
    private int column;
    private String[][] matrix;
    private double fillFactor;

    public Matrix(int column, int row, double fillFactor) {
        this.column = column;
        this.row = row;
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

    public void fill() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String rand = (Math.random() < fillFactor) ? "|X|" : " - ";
                matrix[i][j] = rand;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("m = ").append(row).append(", n = ").append(column).append(", f = ").append(fillFactor).append("\r\n");
        sb.append("----------------------------------------------------").append("\r\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
