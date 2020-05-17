/*
Task. Given an integer 𝑛, find the last digit of the sum 𝐹0 + 𝐹1 + · · · + 𝐹𝑛.

Input Format. The input consists of a single integer 𝑛.

Constraints.
0 ≤ 𝑛 ≤ 10^18

Output Format. Output the last digit of 𝐹0 + 𝐹1 + · · · + 𝐹𝑛.

Sample 1.
Input:
3

Output:
4

𝐹0 + 𝐹1 + 𝐹2 + 𝐹3 = 0 + 1 + 1 + 2 = 4.

Sample 2.
Input:
100

Output:
5

The sum is equal to 927 372 692 193 078 999 175, the last digit is 5.
*/

/*
With the help of Pisano period, we can easy to compute the last digit of any Fi.
We have F0 + F1 + … + Fn = F(n+2) — 1. The algorithm will be easy to implement.
A trick plus 10 here to make sure we return positive remainder in case of get_fibonacci_huge(n+2, 10) has last digit is 0.
*/

import java.io.*;
import java.util.*;
 
public class LastDigitOfSumOfFibo {
    
    static MyScanner sc = new MyScanner();

    static long find_pisano(long m) {

        long a = 0, b = 1;

        for(int i = 0; i < m * m; ++i) {

            long c = (a + b) % m;
            a = b;
            b = c;

            if(a == 0 && b == 1) 
                return i + 1;
        }

        return -1;
    }

    static long find_fibo_mod_m(long n, long m) {

        long rem = n % find_pisano(m);

        long a = 0, b = 1, c = rem;

        for(int i = 1; i < rem; ++i) {

            c = (a + b) % m;
            a = b;
            b = c;
        }

        return(c % m);
    }

    static long sumLastDigit(long n) {

        return (find_fibo_mod_m(n + 2, 10) - 1 + 10) % 10;
    }
    
    public static void main(String[] args) {
        
        long n = sc.nextLong();

        out.println(sumLastDigit(n));

        out.close();
 
    }
    
                        /****        Fast I/O        ****/
    
    
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

