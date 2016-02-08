package com.epam.eps;

public class Input {

    private final int height;
    private final int width;
    private final double fillFactor;

    public Input(int height, int width, double fillFactor) {
        this.height = height;
        this.width = width;
        this.fillFactor = fillFactor;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getFillFactor() {
        return fillFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Input input = (Input) o;

        if (height != input.height) return false;
        if (width != input.width) return false;
        return Double.compare(input.fillFactor, fillFactor) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = height;
        result = 31 * result + width;
        temp = Double.doubleToLongBits(fillFactor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
