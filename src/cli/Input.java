package cli;

public class Input {
    private String[] params;

    public Input(String[] params) {
        this.params = params;
    }

    public String execute() {
        try {
            int m = Integer.parseInt(params[0]);
            int n = Integer.parseInt(params[1]);
            double f = Double.parseDouble(params[2]);
            Matrix matrix = new Matrix(m, n, f);
            matrix.fill();
            return matrix.toString() + new Report(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String toString() {
        return execute();
    }
}
