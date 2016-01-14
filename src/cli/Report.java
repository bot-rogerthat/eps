package cli;

import java.util.*;

public class Report {
    private Matrix matrix;

    public Report(Matrix matrix) {
        this.matrix = matrix.clone();
    }

    public String getRiskGroupsReport() {
        StringBuilder report = new StringBuilder();
        report.append("\r\nRisk groups report:\r\n----------------------------------------------------\r\n");
        Map<DegreeOfRisk, Integer> groups = new SearchAlgorithm(matrix).getGroups();
        List<Map.Entry<DegreeOfRisk, Integer>> entries = sortGroupByValue(groups);
        for (Map.Entry<DegreeOfRisk, Integer> pair : entries) {
            report.append(pair.getKey()).append(": ").append(pair.getValue()).append(" groups;\r\n");
        }
        return report.toString();
    }

    private List<Map.Entry<DegreeOfRisk, Integer>> sortGroupByValue(Map<DegreeOfRisk, Integer> map) {
        List<Map.Entry<DegreeOfRisk, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> {
            int v1 = e1.getValue();
            int v2 = e2.getValue();
            return (v1 < v2) ? 1 : (v1 == v2) ? 0 : -1;
        });
        return list;
    }

    @Override
    public String toString() {
        return getRiskGroupsReport();
    }
}
