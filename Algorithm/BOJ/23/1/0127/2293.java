package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N][K];
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < K; i++) {
			if ((i+1) % nums[0] == 0) {
				dp[0][i] = 1;
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < K; j++) {
				if (j-nums[i] < 0) {
					if ((j+1) % nums[i] == 0) {
						dp[i][j] = 1;
					}
				}
				else {
					for (int l = 0; l <= i; l++) {
						dp[i][j] += dp[l][j-nums[i]];
					}
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += dp[i][K-1];
		}
		System.out.println(answer);
	}
}
