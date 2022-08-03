package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String[] temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]), m= Integer.parseInt(temp[1]);
			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				temp = br.readLine().split(" ");
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(temp[j]);
				}
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= n-m; i++) {
				for (int j = 0; j <= n-m; j++) {
					int count = 0;
					for (int k = i; k < i+m; k++) {
						for (int l = j; l < j+m; l++) {
							count += arr[k][l];
						}
					}
					max = Integer.max(max, count);
					
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}

}
