package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		N = Integer.parseInt(br.readLine());
		dp = new int[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 1000000; i++) {
			dp[i] += dp[i-3];
			dp[i] = dp[i] % 1000000009;
			dp[i] += dp[i-2];
			dp[i] = dp[i] % 1000000009;
			dp[i] += dp[i-1];
			dp[i] = dp[i] % 1000000009;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int find = Integer.parseInt(br.readLine());
			sb.append(dp[find]).append('\n');
		}
		System.out.println(sb);
	}
}
