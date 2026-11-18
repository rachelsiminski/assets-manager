package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

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

    @Override
    public BigDecimal getValue() {
        BigDecimal depreciation = BigDecimal.ZERO;
        LocalDate yearNow = LocalDate.now();
        int age = yearNow.getYear() - this.getYear();
        if (age < 0) {
            age = 0;
        }
        switch (age) {
            case 0 -> depreciation = this.getOriginalCost().multiply(new BigDecimal(".03"));
            case 1, 2, 3 -> depreciation = this.getOriginalCost().multiply(new BigDecimal(".03").multiply(new BigDecimal(age)));
            case 4, 5, 6 -> depreciation = this.getOriginalCost().multiply(new BigDecimal(".06").multiply(new BigDecimal(age)));
            case 7, 8, 9, 10 -> depreciation = this.getOriginalCost().multiply(new BigDecimal(".08").multiply(new BigDecimal(age)));
            default -> {
                return new BigDecimal("1000.00");
            }
        }
        if (odometer > 100000 && !this.getMakeModel().contains("Honda") && !this.getMakeModel().contains("Toyota")) {
            depreciation = depreciation.multiply(new BigDecimal("1.25"));
        }
        return this.getOriginalCost().subtract(depreciation).setScale(2, RoundingMode.HALF_UP);
    }
}
