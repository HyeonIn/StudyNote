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
        int[][] arr = new int[n+1][n+1];
        int[][] arr2 = new int[n+1][n+1]; 
        
        
        
        for (int i = 1; i <= n; i++) {
        	temp = br.readLine().split(" ");
        	for (int j = 1; j <= n; j++) {
        		arr[i][j] = arr[i][j-1]+Integer.parseInt(temp[j-1]);
			}
		}
        for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr2[i][j] = arr2[i-1][j]+arr[i][j];
			}
		}
        for (int i = 0; i < m; i++) {
        	int answer = 0;
            temp = br.readLine().split(" ");
            int y1 = Integer.parseInt(temp[0]);
            int x1 = Integer.parseInt(temp[1]);
            int y2 = Integer.parseInt(temp[2]);
            int x2 = Integer.parseInt(temp[3]);
            
            
            
            System.out.println(arr2[y2][x2]-arr2[y1-1][x2] - (arr2[y2][x1-1]-arr2[y1-1][x1-1]));
		}
    }
}