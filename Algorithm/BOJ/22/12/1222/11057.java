package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	
	public static void main(String[] args) throws IOException {
		long[][] dp = new long[1001][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 10-i;
		}
		for (int i = 2; i < 1001; i++) {
			long sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += dp[i-1][j]%10007;
			}
			dp[i][0] = sum%10007;
			for (int j = 1; j < 10; j++) {
				sum -= dp[i-1][j-1]%10007;
				dp[i][j] = sum%10007;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(dp[N][0]);
	}
}