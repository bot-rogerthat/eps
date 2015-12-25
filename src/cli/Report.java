package cli;

import java.util.*;

public class Report {
    private Matrix matrix;

    public Report(Matrix matrix) {
        this.matrix = matrix.clone();
    }

    public String getRiskGroupsReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Risk groups report:").append("\r\n");
        sb.append("----------------------------------------------------").append("\r\n");
        Map<DegreeOfRisk, Integer> map = getGroupsInMatrix();
        List<Map.Entry<DegreeOfRisk, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (e1, e2) -> {
            int v1 = e1.getValue();
            int v2 = e2.getValue();
            return (v1 < v2) ? 1 : (v1 == v2) ? 0 : -1;
        });
        for (Map.Entry<DegreeOfRisk, Integer> pair : entries) {
            sb.append(pair.getKey()).append(": ").append(pair.getValue()).append(" groups;\r\n");
        }
        return sb.toString();
    }

    private Map<DegreeOfRisk, Integer> getGroupsInMatrix() {
        Map<DegreeOfRisk, Integer> map = new HashMap<>();
        List<DegreeOfRisk> listGroups = findGroupsInMatrix();
        for (DegreeOfRisk element : listGroups) {
            map.put(element, Collections.frequency(listGroups, element));
        }
        return map;
    }

    private List<DegreeOfRisk> findGroupsInMatrix() {
        List<DegreeOfRisk> list = new ArrayList<>();
        int count = 0;
        int row  = matrix.getRow();
        int column   = matrix.getColumn();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ("|X|".equals(matrix.getElement(i, j))) {
                    count += checkSideToFind(i, j);
                    if (count > 0 && count < 3) {
                        list.add(DegreeOfRisk.NONE);
                        count = 0;
                        continue;
                    }
                    if (count > 2 && count < 5) {
                        list.add(DegreeOfRisk.MINOR);
                        count = 0;
                        continue;
                    }
                    if (count > 4 && count < 8) {
                        list.add(DegreeOfRisk.NORMAL);
                        count = 0;
                        continue;
                    }
                    if (count > 7 && count < 14) {
                        list.add(DegreeOfRisk.MAJOR);
                        count = 0;
                        continue;
                    }
                    if (count > 13) {
                        list.add(DegreeOfRisk.CRITICAL);
                        count = 0;
                    }
                }
            }
        }
        return list;
    }

    private int checkSideToFind(int i, int j) {
        int count = 1;
        matrix.setElement(i, j, " - ");
        //top
        count += checkTop(i, j);
        //right
        count += checkRight(i, j);
        //bot
        count += checkBot(i, j);
        //left
        count += checkLeft(i, j);

        return count;
    }

    private int checkTop(int i, int j) {
        if (i - 1 < 0) {
            return 0;
        }
        if ("|X|".equals(matrix.getElement(i - 1, j))) {
            matrix.setElement(i - 1, j, " - ");
            return checkSideToFind(i - 1, j);
        } else {
            return 0;
        }
    }

    private int checkRight(int i, int j) {
        if (j + 1 > matrix.getColumn() - 1) {
            return 0;
        }
        if ("|X|".equals(matrix.getElement(i, j + 1))) {
            matrix.setElement(i, j + 1, " - ");
            return checkSideToFind(i, j + 1);
        } else {
            return 0;
        }
    }

    private int checkBot(int i, int j) {
        if (i + 1 > matrix.getRow() - 1) {
            return 0;
        }
        if ("|X|".equals(matrix.getElement(i + 1, j))) {
            matrix.setElement(i + 1, j, " - ");
            return checkSideToFind(i + 1, j);
        } else {
            return 0;
        }
    }

    private int checkLeft(int i, int j) {
        if (j - 1 < 0) {
            return 0;
        }
        if ("|X|".equals(matrix.getElement(i, j - 1))) {
            matrix.setElement(i, j - 1, " - ");
            return checkSideToFind(i, j - 1);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return getRiskGroupsReport();
    }
}
