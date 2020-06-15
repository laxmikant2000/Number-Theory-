/*
The following is a detailed algorithm for finding factorial.

factorial(n)
1) Create an array ‘digit[]’ of MAX size where MAX is number of maximum digits in output.
2) Initialize value stored in ‘digit[0]’ as 1 and initialize ‘digit_length’ (size of ‘digit[]’) as 1.
3) Do following for all numbers from x = 2 to n.
   a) Multiply x with digit[] and update digit[] and digit_length to store the multiplication result.

multiply(x, digit_length, digit[])
1) Initialize carry as 0.
2) Do following for i = 0 to digit_length – 1
   a) Find value of digit[i] * x + carry. Let this value be product.
   b) Update digit[i] by storing last digit of product in it.
   c) Update carry by storing remaining digits in carry.
3) Put all digits of carry in digit[] and increase digit_length by number of digits in carry.
*/

import java.util.*;
import java.io.*;

public class Main {
    
    // fast I/O
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);
    
    
    // Below function finds factorial of large numbers and prints them
    
    public static void factorial(int n) {
        
        int[]  digit = new int[500];  // max size of digits in factorial
        
        int digit_length = 1;  // stores total length after calculating factorial
        digit[0] = 1;
        
        //Apply simple factorial formula n! = 1 * 2 * 3 * 4...* n
        
        for(int i = 2; i <= n; ++i) 
            digit_length = multiply(i, digit_length, digit);
        
        for(int i = digit_length - 1; i >= 0; --i)
            out.print(digit[i]);
    }
    
    public static int multiply(int x, int digit_length, int[] digit) {
        
        int carry = 0;
        
        for(int i = 0; i < digit_length; ++i) {
            
            int product = digit[i] * x + carry;
            digit[i] = product % 10;           // stores last digit of product in digit[i]
            carry = product / 10;              // rest in carry
        }
        
        while(carry != 0) {
            digit[digit_length++] = carry % 10;
            carry /= 10;
        }
        
        return digit_length;
    }
    
    public static void main(String[] args) throws Exception {
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            factorial(n);
            out.println();
        }
        
        out.flush();
        out.close();
    }
    
}
