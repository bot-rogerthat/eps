package cli;

public class Report {
    private Matrix matrix;

    public Report(Matrix matrix) {
        this.matrix = matrix;
    }

    public String getRiskGroupsReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Risk groups report:").append("\r\n");
        sb.append("----------------------------------------------------").append("\r\n");
        for (int i = 0; i < matrix.getRow(); i++) {
            for (int j = 0; j < matrix.getColumn(); j++) {

            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getRiskGroupsReport();
    }
}
