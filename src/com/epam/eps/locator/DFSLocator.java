package com.epam.eps.locator;

import com.epam.eps.RiskGroup;
import com.epam.eps.sector.Cell;
import com.epam.eps.sector.Sector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSLocator implements Locator {
    private Sector sector;
    private List<RiskGroup> groups;

    public DFSLocator(Sector sector, List<RiskGroup> groups) {
        this.groups = groups;
        this.sector = sector.clone();
    }

    @Override
    public Map<RiskGroup, Integer> find() {
        Map<RiskGroup, Integer> foundGroups = new HashMap<>();
        for (int x = 0; x < sector.getHeight(); x++) {
            for (int y = 0; y < sector.getWidth(); y++) {
                if (sector.getElement(x, y) == Cell.HUMAN) {
                    addFoundGroup(foundGroups, findSizeGroup(x, y));
                }
            }
        }
        return foundGroups;
    }

    private Integer findSizeGroup(int x, int y) {
        int humanCount = 1;
        sector.setElement(x, y, Cell.EMPTY);
        if (y + 1 < sector.getWidth() && sector.getElement(x, y + 1) == Cell.HUMAN) {
            humanCount += findSizeGroup(x, y + 1);
        }
        if (x + 1 < sector.getHeight() && sector.getElement(x + 1, y) == Cell.HUMAN) {
            humanCount += findSizeGroup(x + 1, y);
        }
        if (x - 1 >= 0 && sector.getElement(x - 1, y) == Cell.HUMAN) {
            humanCount += findSizeGroup(x - 1, y);
        }
        if (y - 1 >= 0 && sector.getElement(x, y - 1) == Cell.HUMAN) {
            humanCount += findSizeGroup(x, y - 1);
        }
        return humanCount;
    }

    private void addFoundGroup(Map<RiskGroup, Integer> target, int size) {
        for (RiskGroup e : groups) {
            if (e.sameSize(size)) {
                if (target.containsKey(e)) {
                    target.put(e, target.get(e) + 1);
                } else {
                    target.put(e, 1);
                }
                break;
            }
        }
    }
}

