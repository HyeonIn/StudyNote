package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			
			int count = 1;
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n-i; j++) {
					map[i][j] = count++;
				}
				
				for (int j = i+1; j < n-i; j++) {
					map[j][n-i-1] = count++;
				}
				for (int j = n-i-2; j >= i; j--) {
					map[n-i-1][j] = count++;
				}
				for (int j = n-2-i; j >= i+1; j--) {
					map[j][i] = count++;
				}
			}
			System.out.printf("#%d\n", t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}

}