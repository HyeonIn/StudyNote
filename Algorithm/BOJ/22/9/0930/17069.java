package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] d = {{0, 2}, {1,2}, {0,1,2}};
	static int[] di = {0, -1, -1};
	static int[] dj = {-1, 0, -1};
	
	static int[][] map; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		long[][][] dp = new long[N][N][3];
		String[] temp;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		dp[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (map[i][j] != 1) {
					boolean check[] = new boolean[3];
					for (int k = 0; k < 3; k++) {
						
						int ni = i+di[k];
						int nj = j+dj[k];
						if (ni < 0 || ni >= N || nj >= N) {
							continue;
						}
						if (map[ni][nj] == 1) {
							check[k] = true;
							continue;
						}
						if (k == 2) {
							if (check[0] || check[1]) {
								continue;
							}
						}
						long t = 0L;
						for (int dir : d[k]) {
							t += dp[ni][nj][dir]; 
						}
						dp[i][j][k] = t;
					}
				}
			}
		}
		long answer = dp[N-1][N-1][0]+ dp[N-1][N-1][1] + dp[N-1][N-1][2];
		System.out.println(answer);
		
	}
}