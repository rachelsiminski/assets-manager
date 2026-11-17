package com.pluralsight;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        House house = new House("House", "11/11/2011", new BigDecimal("99999999"), "222 Abc Rd", 2, 1000, 3000);

        System.out.println(house.getValue());

        Vehicle vehicle = new Vehicle("Car", "11/10/2026", new BigDecimal("10000"), "Hyundai Sonata", 2026, 100);

    }
}
