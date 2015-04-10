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
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n % 2);
            res = res << 1;
            n = n >> 1;
        }
        //        if (n < 0) {
        //            v = n & 0x00000000ffffffffL;
        //        }
        //        return (int) ~v;
        //        while (n > 0) {
        //            res += (n % 2);
        //            res = res << 1;
        //            if (n % 2 == 1) {
        //                res++;
        //            }
        //            n = n >> 1;
        //            
        //            if (n > 0) {
        //                res = res << 1;
        //            }
        //            res += n % 2;
        //            res = res << 1;
        //            n = n >> 1;
        //            if (n == 0) {
        //                res += n % 2;
        //            }
        //        }
        //        long v = n;
        //        if (n < 0) {
        //            v = n & 0x00000000ffffffffL;
        //        }
        //        return (int) ~v;
        return res;
    }
}
