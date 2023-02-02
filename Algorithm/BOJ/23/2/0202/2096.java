package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] nums = new int[N][3];
		
		StringTokenizer st; 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] minDP = new int[N][3];
		int[][] maxDP = new int[N][3];
		
		int[][] index = {{0,1}, {0,2}, {1,2}};
			
		for (int i = 0; i < 3; i++) {
			minDP[0][i] = nums[0][i];
			maxDP[0][i] = nums[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				minDP[i][j] = Integer.MAX_VALUE;
				maxDP[i][j] = Integer.MIN_VALUE;
			}
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = index[j][0]; k <= index[j][1]; k++) {
					minDP[i][j] = Math.min(minDP[i-1][k] + nums[i][j], minDP[i][j]);
					maxDP[i][j] = Math.max(maxDP[i-1][k] + nums[i][j], maxDP[i][j]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, maxDP[N-1][i]);
			min = Math.min(min, minDP[N-1][i]);
		}
		System.out.println(max + " " + min);
	}
}
