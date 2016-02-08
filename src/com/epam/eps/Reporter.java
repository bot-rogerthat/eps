package com.epam.eps;

import com.epam.eps.sector.Cell;
import com.epam.eps.sector.Sector;

import java.util.List;
import java.util.Map;

public class Reporter {

    public String getReport(Sector sector, double fillFactor, Map<RiskGroup, Integer> foundGroups,
                            List<RiskGroup> groupOfRisk) {
        if (sector == null || foundGroups == null || groupOfRisk == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder report = new StringBuilder();
        report.append(printHead(sector));
        report.append(printFillFactor(fillFactor));
        report.append(printGroupsOfRisk(groupOfRisk));
        report.append(printLine());
        report.append(printSector(sector));
        report.append(printFoundGroups(foundGroups, groupOfRisk));
        return report.toString();
    }

    private String printGroupsOfRisk(List<RiskGroup> groupOfRisk) {
        StringBuilder sb = new StringBuilder();
        for (RiskGroup e : groupOfRisk) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }

    private String printLine() {
        return "----------------------------------------------------\n";
    }

    private String printHead(Sector sector) {
        StringBuilder sb = new StringBuilder();
        sb.append("Emergency Prevention System\n");
        sb.append(printLine());
        sb.append("m = ");
        sb.append(sector.getHeight());
        sb.append(", n = ");
        sb.append(sector.getWidth());
        return sb.toString();
    }

    private String printFillFactor(double fillFactor) {
        return ", f = " + fillFactor + "\n";
    }

    private String printSector(Sector sector) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < sector.getHeight(); x++) {
            for (int y = 0; y < sector.getWidth(); y++) {
                if (sector.getElement(x, y) == Cell.HUMAN) {
                    sb.append("|X|");
                } else {
                    sb.append(" - ");
                }
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    private String printFoundGroups(Map<RiskGroup, Integer> foundGroups, List<RiskGroup> groupOfRisk) {
        StringBuilder sb = new StringBuilder();
        sb.append("Risk groups report: \n");
        sb.append(printLine());
        for (RiskGroup e : groupOfRisk) {
            if (foundGroups.containsKey(e)) {
                sb.append(e.getName()).append(": ").append(foundGroups.get(e)).append(" groups;\n");
            } else {
                sb.append(e.getName()).append(": 0 groups;\n");
            }
        }
        return sb.toString();
    }
}
