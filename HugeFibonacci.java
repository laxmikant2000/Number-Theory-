/*
Task. Given two integers 𝑛 and 𝑚, output 𝐹𝑛 mod 𝑚 (that is, the remainder of 𝐹𝑛 when divided by 𝑚).

Input Format. The input consists of two integers 𝑛 and 𝑚 given on the same line (separated by a space).

Constraints.
1 ≤ 𝑛 ≤ 10^18
2 ≤ 𝑚 ≤ 10^3

Output Format. Output 𝐹𝑛 mod 𝑚.

Sample 1.
Input:
239 1000

Output:
161

𝐹239 mod 1 000 = 39 679 027 332 006 820 581 608 740 953 902 289 877 834 488 152 161 (mod 1 000) = 161.
*/

/* Why below code works ?
   To compute,
say, 𝐹2015 mod 3 we just need to find the remainder of 2015 when divided by 8. Since 2015 = 251 · 8 + 7, we
conclude that 𝐹2015 mod 3 = 𝐹7 mod 3 = 1.
This is true in general: for any integer 𝑚 ≥ 2, the sequence 𝐹𝑛 mod 𝑚 is periodic. The period always
starts with 01 and is known as Pisano period.
*/


import java.io.*;
import java.util.*;
 
public class HugeFibonacci {
    
    static MyScanner sc = new MyScanner();

    static long find_pisano(long m) {

        long a = 0, b = 1;
        long res = 0;
        
        for(int i = 0; i < m * m; ++i) {

            long c = (a + b) % m;
            a = b;
            b = c;

            if(a == 0 && b == 1) { 
                res = i + 1;
                break;
            }
        }

        return res;
    }

    static void find_fibo_mod_m(long n, long m) {

        long rem = n % find_pisano(m);

        long a = 0, b = 1, c = rem;

        for(int i = 1; i < rem; ++i) {

            c = (a + b) % m;
            a = b;
            b = c;
        }

        out.println(c % m);
    }
    
    public static void main(String[] args) {
        
        long n = sc.nextLong();
        long m = sc.nextLong();

        find_fibo_mod_m(n,m);

        out.close();
 
    }
    
    
/********************************************************************************************************************/
    
    // array of int type taking input
    public static int[] init(int n) {
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
            
        return arr;
    }
    
    //return gcd of two numbers
    public static int gcd(int a, int b) {
        
        if(a == 0)
            return b;
            
        return gcd(b % a, a);
    }
    
    
    //checks whether a number is prime or not
    public static boolean prime(int n) {
        
        if(n < 2)
            return false;
        
        for(int i = 2; i * i <= n; ++i)
            if(n % i == 0)
                return false;
                
        return true;
    }
    
/*******************************************************************************************************************/
    
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
    //--------------------------------------------------------
}
