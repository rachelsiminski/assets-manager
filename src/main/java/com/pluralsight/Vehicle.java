package com.pluralsight;

import java.math.BigDecimal;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public BigDecimal getValue() {
        BigDecimal value = BigDecimal.ZERO;
        switch (getYear()) {
            case 0, 1, 2, 3 -> value = getOriginalCost().multiply(new BigDecimal(.03));
            case 4, 5, 6 -> value = getOriginalCost().multiply(new BigDecimal(.06));
            case 7, 8, 9, 10 -> value = getOriginalCost().multiply(new BigDecimal(.08));
            default -> value = new BigDecimal(1000);
        }
        if (odometer > 100000 && !getMakeModel().contains("Honda") && ! getMakeModel().contains("Toyota")) {
            value = value.subtract(value.multiply(new BigDecimal(.25)));
        }

        return value;
    }
}
