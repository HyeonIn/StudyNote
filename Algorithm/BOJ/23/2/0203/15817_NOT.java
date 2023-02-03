package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] count = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][x+1];
		
		for (int i = 1; i < x+1; i++) {
			if (i/arr[0] <= count[0]) {
				if (i%arr[0] == 0) {
					dp[0][i] = 1;					
				}
				else {
					dp[0][i] = 0;
				}
			}
			else {
				dp[0][i] = 0;
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < x+1; j++) {
				if (j/arr[i] <= count[i]) {
					if (j-arr[i] >= 0 ) {
						if (j - arr[i] == 0) {
							dp[i][j] = 1 + dp[i-1][j];						
						}
						else {
							dp[i][j] = dp[i][j-arr[i]] + dp[i-1][j];						
						}
					}
					else {
						dp[i][j] = dp[i-1][j];
					}
				}
				else {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-(arr[i]*count[i])];
				}
			}
		}
		System.out.println(dp[N-1][x]);
	}
}
