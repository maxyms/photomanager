package com.skotarenko.quiz;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

    For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
    
 * @author maxyms
 *
 */
public class NumberOfBits {
    public int hammingWeight(int n) {
        String binaryStr = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int hammingWeightShift(int n) {
        int count = 0;
        long v = n;
        if (n < 0) {
            v = n & 0x00000000ffffffffL;
        }
        while (v > 0) {
            if (v % 2 == 1) {
                count++;
            }
            v = v >> 1;
        }
        return count;
    }
}
