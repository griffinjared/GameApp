package com.gameapp.gameapp;

import java.util.Random;

/**
 * Created by griff on 2/10/2016.
 */
public class SeedGenerator {
    private Random seeder = new Random();
    private final int SEED = seeder.nextInt(10);

    public SeedGenerator() {}

    public int getSeed() {
        return SEED;
    }
}

