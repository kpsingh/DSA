package com.java.practice;
/*
https://stackoverflow.com/questions/2385909/what-would-be-the-fastest-method-to-test-for-primality-in-java

 */
public class IsPrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(23));

    }

    public static boolean isPrime(int n) {

        if (n < 2) return false;

        if (n == 2 || n == 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        int sqrtN = (int) Math.sqrt(n) + 1;

        for (int i = 6; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

}
