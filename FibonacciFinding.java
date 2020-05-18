/*
Problem Link : https://www.hackerrank.com/challenges/fibonacci-finding-easy/problem

As the constraint is 10^9, so normal naive approach won't work here. We can use Matrix exponentiation to solve this problem or 
any recurrence relation in O(logn) time. 
How? Let's see the code
*/

// I have used 1 based indexing over here

import java.util.*;
import java.math.*;
import java.io.*;

public class Main {

    static final long mod = (long)1e9 + 7;
    static long[] arr;  // used for taking first two input
    static long[][] I;  // Identity matrix
    static long[][] T;  // Transition matrix
    
    
    // below function performs matrix multiplication
    static void mul(long[][] A, long[][] B, int dim) {   

        long[][] res = new long[dim + 1][dim + 1];

        for(int i = 1; i <= dim; ++i) {

            for(int j = 1; j <= dim; ++j) {

                res[i][j] = 0;
                for(int k = 1; k <= dim; ++k) {

                    long x = (A[i][k] * B[k][j]) % mod;
                    res[i][j] = (res[i][j] + x) % mod;
                }
            }
        }
        
        for(int i = 1; i <= dim; ++i) {
            for(int j = 1; j <= dim; ++j) {
                A[i][j] = res[i][j];
            }
        }
    }

    static long myfibo(int n) {

         I = new long[3][3];
         T = new long[3][3];

         if(n <= 2) return arr[n];

        I[1][1] = I[2][2] = 1;
        I[1][2] = I[2][1] = 0;

        T[1][1] = 0;                            // a*F1 + b*F2 = F2...so when a will be 0 then we can obtain F2
        T[1][2] = T[2][1] = T[2][2] = 1;        // c*F1 + d*F2 = F3...here both have to be 1 i.e c and c

        n -= 1;          // we will do matrix multiplication till n - 1

        while(n > 0) {

            if(n % 2 == 0) {
                mul(T, T, 2);
                n /= 2;
            }
            else {
                mul(I, T, 2);
                n--;
            }
        }

        long fn = (arr[1] * I[1][1] + arr[2] * I[2][1]) % mod;  // main result

        return fn;
    }

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
    
        int t = sc.nextInt();
        while(t-- > 0) {

            arr = new long[3]; 

            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            int n = sc.nextInt();
            ++n; // for 1 based indexing

            long res = myfibo(n);
            System.out.println(res);
        }
    }
}
