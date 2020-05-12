
/* You are given a string and a substring. Count how many times the given substring occurrs in a string. 
  Print -1 if no given substring occurrs.
  For Example : 
  Given a String str = "aaaaa";
  and a String s = "aa";
  Here output will be 4 including overlapping matches.
*/

import java.util.*;

public class Main {

  public static void main(String[]args) {

      String str = sc.next();
      String s = sc.next();
      
      int count = 0, lastIndex = 0;
      
      while(lastIndex != -1) {

        lastIndex = str.indexOf(s, lastIndex);
        if(lastIndex != -1) {
            ++count;
            ++lastIndex;
        }
     }
     System.out.println(count);
  }
}
