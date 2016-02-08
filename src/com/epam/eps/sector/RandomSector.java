package com.epam.eps.sector;

import java.util.Random;

public class RandomSector implements SectorSource {
    private Sector sector;
    private Random random = new Random();

    public RandomSector(int height, int width, double probability) {
        if (probability < 0 || probability > 1) {
            throw new IllegalArgumentException();
        }
        sector = new Sector(height, width);
        fill(probability);
    }

    private void fill(double probability) {
        for (int x = 0; x < sector.getHeight(); x++) {
            for (int y = 0; y < sector.getWidth(); y++) {
                Cell rand = (random.nextDouble() < probability) ? Cell.HUMAN : Cell.EMPTY;
                sector.setElement(x, y, rand);
            }
        }
    }

    @Override
    public Sector getSector() {
        return sector;
    }
}
