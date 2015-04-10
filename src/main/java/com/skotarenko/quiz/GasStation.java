package com.skotarenko.quiz;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

    You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Note:
        The solution is guaranteed to be unique.

 * @author maxyms
 *
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int start = 0;
        int totalTank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            totalTank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return (totalTank >= 0) ? (start <= gas.length ? start : gas.length) : -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[] { 1, 2, 3, 4, 5 };
        int[] cost = new int[] { 3, 4, 5, 1, 2 };
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
}
