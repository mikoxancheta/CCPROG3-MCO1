package com.verdantsun;

public class Fertilizer {

    private String name;
    private int price;
    private int effectDays;

    public Fertilizer(String name, int price, int effectDays) {
        this.name = name;
        this.price = price;
        this.effectDays = effectDays;
    }

    public void decreaseEffect() {
        if (this.effectDays > 0) {
            this.effectDays--;
        }
    }

    public boolean isExpired() {
        return this.effectDays <= 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isActive() {
        return this.effectDays > 0;
    }
}
