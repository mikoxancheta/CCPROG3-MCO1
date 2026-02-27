package com.verdantsun;

public class Plant {

    private String name;
    private int seedPrice;
    private int yield;
    private int maxGrowth;
    private int currentGrowth;
    private String preferredSoil;
    private boolean watered;
    private int cropPrice;

    public Plant(String name, int seedPrice, int yield, int maxGrowth, String preferredSoil, int cropPrice) {
        this.name = name;
        this.seedPrice = seedPrice;
        this.yield = yield;
        this.maxGrowth = maxGrowth;
        this.preferredSoil = preferredSoil;
        this.cropPrice = cropPrice;
        this.currentGrowth = 0;
        this.watered = false;
    }

    public void water() {
        this.watered = true;
    }

    public void grow(String soilType, boolean fertilized) {
        if (!this.watered) {
            return;
        }

        int growthAmount = 1;

        if (soilType.equalsIgnoreCase(this.preferredSoil)) {
            growthAmount++;
        }

        if (fertilized) {
            growthAmount++;
        }

        this.currentGrowth += growthAmount;

        if (this.currentGrowth > this.maxGrowth) {
            this.currentGrowth = this.maxGrowth;
        }
    }

    public void resetWater() {
        this.watered = false;
    }

    public boolean isMature() {
        return this.currentGrowth >= this.maxGrowth;
    }

    public String getName() {
        return name;
    }

    public int getSeedPrice() {
        return this.seedPrice;
    }

    public int getYieldValue() {
        return this.yield * cropPrice;
    }
}
