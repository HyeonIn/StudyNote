package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String[] temp = br.readLine().split(" ");
        
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int[] arr = new int[n+1];
        temp = br.readLine().split(" ");
        
        for (int i = 1; i <= n; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(temp[i-1]);
		}
        
        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            System.out.println(arr[b] - arr[a-1]);
		}
        
    }
}