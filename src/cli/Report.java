package cli;

import java.util.Map;
import java.util.TreeMap;

public class Report {
    private Matrix matrix;

    public Report(Matrix matrix) {
        this.matrix = matrix.clone();
    }

    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(matrix.toString());
        report.append("\r\nRisk groups report:\r\n----------------------------------------------------\r\n");
        Map<DegreeOfRisk, Integer> foundGroups = new SearchAlgorithm(matrix).getGroupFound();
        addGroupsInReport(report, foundGroups);
        return report.toString();
    }

    private void addGroupsInReport(StringBuilder report, Map<DegreeOfRisk, Integer> target) {
        Map<DegreeOfRisk, Integer> map = new TreeMap<>();
        for (DegreeOfRisk e : DegreeOfRisk.values()) {
            map.put(e, 0);
        }

        target.entrySet().stream().filter(pair -> map.containsKey(pair.getKey())).forEach(pair -> {
            map.replace(pair.getKey(), pair.getValue());
        });

        for (Map.Entry<DegreeOfRisk, Integer> pair : map.entrySet()) {
            report.append(pair.getKey()).append(" = ").append(pair.getValue()).append(" groups;\r\n");
        }
    }

    @Override
    public String toString() {
        return getReport();
    }
}
