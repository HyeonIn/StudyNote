package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	static int n, m;
	static int[] arr;
	static boolean[] select;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        
        arr = new int[n];
        select = new boolean[n];
        result = new int[m];
        
        for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
        
        perm(0);

        System.out.println(sb);
        
    }
    public static void perm(int idx) {
    	
    	if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(result[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
    	
    	for (int i = 0; i < n; i++) {
			result[idx] = arr[i];
			perm(idx+1);
		}
    	
    }
}