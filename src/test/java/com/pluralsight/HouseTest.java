package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class HouseTest {

    @Test
    void getValue_should_return235500ForHouseWithOriginalCost235500() {
        Asset house1 = new House("House", "11/11/2011", new BigDecimal("235500"), "222 Abc Rd", 2, 1800, 6000);
        BigDecimal expectedValue = new BigDecimal("235500.00");
        assertEquals(expectedValue, house1.getValue());
    }
}