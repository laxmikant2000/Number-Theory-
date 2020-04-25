
/* Let's assume we have to find 2^5 (i.e 2 power 5)
    Here 2 is base and 5 is power

    result     base     power
      1         2         5
      2         2         4
      2         4         2
      2         16        1
      32        16        0

So, when power is ODD, we multiply base with result and reduce power by 1
    when power is EVEN, we multiply base with base(squared) and half the power 
and when power becomes 0, stop the iteration

*/


import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    /* Below function finds the Exponentation in O(logn)  */
    public static void expo(int base, int power) {

        int result = 1;

        while(power > 0) { 

            if((power & 1) != 0) {   // checks it power is odd
                result *= base;      // odd power, then multiply result by base and reduce one power
                power--;
            }
            else {
                base *= base;       // even number, square the base and half the power
                power /= 2;
            }
        }

        System.out.println(result);
    }


    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  //Number of test cases
        while(t-- > 0) {

            int base = sc.nextInt();
            int power = sc.nextInt();

            expo(base, power);
            
        }
        
        sc.close();
    }
}
