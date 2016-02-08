package com.epam.eps;

public class RiskGroup {
    private final String name;
    private final int min;
    private final int max;

    public RiskGroup(String name, int min, int max) {
        if (name == null || min > max) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public boolean sameSize(int value) {
        return value >= min && value <= max;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " = {" + min + ", " + max + "}";
    }
}
