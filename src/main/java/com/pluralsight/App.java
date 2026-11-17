package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Asset house1 = new House("House", "11/11/2011", new BigDecimal("99999999"), "222 Abc Rd", 2, 1000, 3000);
        Asset house2 = new House("Vacation", "11/11/2021", new BigDecimal("999999"), "224 Abc Rd", 1, 800, 2000);
        Asset vehicle1 = new Vehicle("Car", "11/10/2026", new BigDecimal("10000"), "Hyundai Sonata", 2026, 100);
        Asset vehicle2 = new Vehicle("Motorcycle", "03/10/2026", new BigDecimal("7000"), "Harley Davidson", 2022, 100000);

        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(house1);
        assets.add(vehicle1);
        assets.add(house2);
        assets.add(vehicle2);

        for (Asset asset : assets) {
            System.out.println("Date Acquired: " + asset.getDateAcquired() + "\nDescription: " + asset.getDescription() + "\nCost: " + asset.getOriginalCost() + "\nValue: " + asset.getValue());
        }
    }
}
