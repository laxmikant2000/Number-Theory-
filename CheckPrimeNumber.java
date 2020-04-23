
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    /* Below function checks whether the provided number is prime or not */
    public static boolean isPrime(int n) {

        if(n < 2) 
            return false;

        for(int i = 2; i * i <= n; ++i)
            if(n % i == 0)
                return false;

        return true;
    }

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  //Number of test cases
        while(t-- > 0) {

            int n = sc.nextInt();   //The number to check prime

            if(isPrime(n))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
        sc.close();
    }
}
