package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class GasStationTest {
    @Test
    public void testCantCompleteCircuit() {
        int[] gas = new int[] { 1, 2, 3, 4, 5 };
        int[] cost = new int[] { 3, 4, 8, 1, 2 };
        Assert.assertEquals(-1, new GasStation().canCompleteCircuit(gas, cost));
    }

    @Test
    public void testCanCompleteCircuit() {
        int[] gas = new int[] { 1, 2, 3, 4, 5 };
        int[] cost = new int[] { 3, 4, 5, 1, 2 };
        Assert.assertEquals(3, new GasStation().canCompleteCircuit(gas, cost));
    }
}
