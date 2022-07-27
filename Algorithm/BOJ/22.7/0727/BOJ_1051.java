package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);		
		int m = Integer.parseInt(temp[1]);		
		
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s1 = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s1.charAt(j)-'0';
			}
		}
		
		int maxSize=1;
		
		int[] dx = {1, 1, 0};
		int[] dy = {0, 1, 1};
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int now = map[i][j];
				for (int k = 1; k <= 50; k++) {
					int count = 0;
					for (int l = 0; l < 3; l++) {
						int nx = j+dx[l]*k;
						int ny = i+dy[l]*k;
						if (nx >=0 && nx < m && ny >=0 && ny < n) {
							if (map[ny][nx] == now) {
								count += 1;
							}
						}
					}
					if (count == 3) {
						if ((k+1)*(k+1) > maxSize) {
							maxSize = (k+1)*(k+1);
						}
					}
				}
			}
		}
		System.out.println(maxSize);
	}
}
