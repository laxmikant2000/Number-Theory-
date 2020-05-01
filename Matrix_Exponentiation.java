
import java.io.*;
import java.util.*;
 
public class Matrix_Exponentiation {
    
    static MyScanner sc = new MyScanner();
    
	static long mod = (long)(1000000007);
	static long[][] base, identity;

	static void mul(long[][] A, long[][] B, int m) {
		
		long[][] res = new long[m][m];
		
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < m; ++j) {
				res[i][j] = 0;
				for(int k = 0; k < m; ++k)
					res[i][j] += (A[i][k] * B[k][j]) % mod;
			}
		}
		
		for(int i = 0; i < m; ++i)
			for(int j = 0; j < m; ++j)
				identity[i][j] = res[i][j];
	}
	
	static void power(long[][] A_Base, int m, int n) {
		
    /* Below approach is the optimised one with O(M^3 * logn) time complexity */
		while(n > 0) {
			if(n % 2 != 0) {
				mul(identity, A_Base, m);
				n--;
			}
			else {
				mul(A_Base, A_Base, m);
				n /= 2;
			}
		}
    
    /* Below commented line is the naive approach for finding MAT^n which takes O(M^3 * n) time complexity */
		// for(int i = 0; i < n; ++i) 
		// 	mul(A_Base, identity, m);
			
		for(int i = 0; i < m; ++i)
			for(int j = 0; j < m; ++j)
				A_Base[i][j] = identity[i][j];
 	}
 	
 	static void print(long[][] A_Base, int m) {
 		
 		for(long[] arr : A_Base) {
 			for(long a : arr)
 				System.out.print(a + " ");
 			System.out.println();
 		}
 	}


    public static void main(String[] args) {
        
        int t = sc.nextInt();
        while(t-- > 0) {

           int m = sc.nextInt();
			int n = sc.nextInt();
			
			base = new long[m][m];
			identity = new long[m][m];
			
			for(int i = 0; i < m; ++i) {
				for(int j = 0; j < m; ++j) {
					base[i][j] = sc.nextLong();
					if(i == j)
						identity[i][j] = 1;
				}
			}
			
			power(base, m, n);
			print(base, m);

        }
        
        
        
        out.close();
 
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
