package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < t; T++) {
			int n = Integer.parseInt(br.readLine());
			int ans =  0;
			int[][] map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String r = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = r.charAt(j) - '0';
				}
			}
			for (int i = 0; i < n-n/2; i++) {
				for (int j = 0; j < n; j++) {
					if (j >= n/2 - i && j <= n/2+i ) {
						ans += map[i][j];
					}
				}
			}
			for (int i = n/2+1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (j >= n/2 - (n-i-1) && j <= n/2+(n-i-1) ) {
						ans += map[i][j];
					}
				}
			}
			System.out.printf("#%d %d\n", T+1, ans);
		}
			
	}

}