package com.skotarenko.quiz;

/**
 * Reverse bits of a given 32 bits unsigned integer.

    For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
        return 964176192 (represented in binary as 00111001011110000010100101000000).

    Follow up:
    If this function is called many times, how would you optimize it?

 * @author maxyms
 *
 */
public class ReverseBits {
    public int reverseBits(int n) {
        long v = n;
        if (n < 0) {
            v = n & 0xffffffffL;
        }
        long res = 0;
        int i = 0;
        for (; i < 32 && v > 0; i++) {
            res += (v % 2);
            res = res << 1;
            v = v >>> 1;
        }
        res = res >> 1;
        res = res << (32 - i);
        return (int) res;
    }
}
