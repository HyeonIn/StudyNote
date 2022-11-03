package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		
		long dp[][] = new long[65][10];
		
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 10-i;
		}
		for (int i = 2; i <= 64; i++) {
			for (int j = 0; j < 10; j++) {
				dp[i][0] += dp[i-1][j];
			}
			for (int j = 1; j < 10; j++) {
				dp[i][j] = dp[i][j-1] - dp[i-1][j-1];
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())][0]);
		}
	}
}