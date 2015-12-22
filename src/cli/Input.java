package cli;

public class Input {
    private String[] params;

    public Input(String[] params) {
        this.params = params;
    }

    private String run() {
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(params[0]);
        int n = Integer.parseInt(params[1]);
        double f = Double.parseDouble(params[2]);
        Matrix matrix = new Matrix(m, n, f);
        matrix.fill();
        sb.append(matrix);
        sb.append(new Report(matrix));
        return sb.toString();
    }

    @Override
    public String toString() {
        return run();
    }
}
