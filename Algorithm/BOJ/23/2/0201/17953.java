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
		int M = Integer.parseInt(st.nextToken());
		
		//ют╥б
		int[][] desertTable = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				desertTable[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dp
		int[][] dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			dp[i][0] = desertTable[i][0];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					if (j == k) {
						dp[j][i] = Math.max(dp[j][i], dp[k][i-1] + (desertTable[j][i]/2));
					}
					else {
						dp[j][i] = Math.max(dp[j][i], dp[k][i-1] + desertTable[j][i]);
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			max = Math.max(max, dp[i][N-1]);
		}
		System.out.println(max);
	}
}
