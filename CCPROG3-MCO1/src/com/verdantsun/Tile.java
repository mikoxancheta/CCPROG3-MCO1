package com.verdantsun;

public class Tile {

    private String soilType;
    private Plant plant;
    private Fertilizer fertilizer;
    private boolean meteoriteAffected;
    private boolean permanentlyFertilized;
    private String originalSoilType;

    public Tile(String soilType) {
        this.soilType = soilType;
        this.originalSoilType = soilType;
        this.plant = null;
        this.fertilizer = null;
        this.meteoriteAffected = false;
        this.permanentlyFertilized = false;
    }

    public boolean plantSeed(Plant plant) {
        if (this.plant != null) {
            return false;
        }

        if(this.isMeteoriteAffected()) {
            return false;
        }

        this.plant = plant;
        return true;
    }

    public void removePlant() {
        this.plant = null;
    }

    public int harvestPlant() {
        if (this.plant != null && plant.isMature()) {
            int value = plant.getYieldValue();
            this.plant = null;
            return value;
        }
        return 0;
    }

    public boolean waterPlant() {
        if (this.plant == null) {
            return false;
        }

        plant.water();
        return true;
    }

    public boolean applyFertilizer(Fertilizer fertilizer) {
        if (this.fertilizer != null) {
            return false;
        }

        this.fertilizer = fertilizer;
        return true;
    }

    public void growPlant() {
        if (this.plant == null) {
            return;
        }

        boolean fertilized = this.permanentlyFertilized || (this.fertilizer != null && !fertilizer.isExpired());

        plant.grow(this.soilType, fertilized);
        plant.resetWater();
    }

    public void reduceFertilizer() {
        if (this.fertilizer != null) {
            fertilizer.decreaseEffect();
            if (fertilizer.isExpired()) {
                this.fertilizer = null;
            }
        }
    }

    public void excavate() {
        this.meteoriteAffected = false;
        this.permanentlyFertilized = true;
    }

    public boolean hasPlant() {
        return this.plant != null;
    }

    public boolean isEmpty() {
        return this.plant == null;
    }

    public boolean isMeteoriteAffected() {
        return meteoriteAffected;
    }

    public void setMeteoriteAffected(boolean value) {
        this.meteoriteAffected = value;
    }
}
