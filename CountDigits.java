
import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {

            int n = sc.nextInt();

            int digits = (int)Math.floor(Math.log10(n)) + 1;  // O(1)

            System.out.println(digits); 
        } 
    }
    
}
