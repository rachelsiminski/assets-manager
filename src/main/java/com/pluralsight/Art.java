package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Art extends Asset {
    private String artist;
    private String medium;
    private int condition;

    public Art(String description, String dateAcquired, BigDecimal originalCost, String artist, String medium, int condition) {
        super(description, dateAcquired, originalCost);
        this.artist = artist;
        this.medium = medium;
        this.condition = condition;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal value = BigDecimal.ZERO;
        switch (this.getCondition()) {
            case 1 -> value = new BigDecimal(".8").multiply(getOriginalCost());
            case 2 -> value = new BigDecimal(".6").multiply(getOriginalCost());
            case 3 -> value = new BigDecimal(".4").multiply(getOriginalCost());
            case 4 -> value = new BigDecimal(".2").multiply(getOriginalCost());
            default -> System.out.println("Condition should be a value 1-4");
        }
        return getOriginalCost().add(value).setScale(2, RoundingMode.HALF_UP);
    }
}

