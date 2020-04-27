
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static final int MAX = (int)1e7;  
    static int[] arr;

    /* Calculating Smallest Prime Factor for every 
       number till MAX in O(nlog(logn)) */
    public static void sieve() {

        arr = new int[MAX + 1];
        arr[1] = 1;

        for(int i = 2; i <= MAX; ++i) 
            if(arr[i] == 0)
                for(int j = i; j <= MAX; j += i)
                    if(arr[j] == 0)
                        arr[j] = i;
    }

    /* A O(logn) function returning primefactorization 
       by dividing by smallest prime factor at every step */ 
    public static List<Integer> getFactorization(int n) {

        List<Integer> ans = new ArrayList<>();

        while(n != 1) {
            ans.add(arr[n]);
            n /= arr[n];
        }

        return ans;
    }  

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        
        sieve();  // precalculating Smallest Prime Factor 

        int t = sc.nextInt();  //Number of test cases
        while(t-- > 0) {

            int n = sc.nextInt();

            List<Integer> result = getFactorization(n);

            for(Integer e : result)
                System.out.print(e + " ");

            System.out.println();

        }       
        sc.close();
    }
}
