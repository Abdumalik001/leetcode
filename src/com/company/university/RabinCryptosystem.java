package com.company.university;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class RabinCryptosystem {
    public static void main(String[] args) {
        BigInteger[] key = Cryptography.generateKey(512);
        BigInteger n = key[0];
        BigInteger p = key[1];
        BigInteger q = key[2];
        String finalMessage = null;
        int i = 1;
        String s = "Mamatov";

        System.out.println("Junativcchi yuborgan habar : " + s);

        BigInteger m
                = new BigInteger(
                s.getBytes(
                        StandardCharsets.US_ASCII));
        BigInteger c = Cryptography.encrypt(m, n);

        System.out.println("Shifrlangan habar : " + c);

        BigInteger[] m2 = Cryptography.decrypt(c, p, q);
        for (BigInteger b : m2) {
            String dec = new String(
                    b.toByteArray(),
                    StandardCharsets.US_ASCII);
            if (dec.equals(s)) {
                finalMessage = dec;
            }
            i++;
        }
        System.out.println(
                "Qabul qilingn habar : "
                        + finalMessage);
    }
}