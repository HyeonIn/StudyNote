package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				boolean answer = true;
				int l = map[i][0];
				int count = 1;
				for (int j = 1; j < N; j++) {
					if (map[i][j] + 1 == l) {
						for (int x = j; x < j+X; x++) {
							if (x >= N) {
								answer = false;
								break;
							}
							if (map[i][x] != map[i][j]) {
								answer = false;
								break;
							}
						}
						if (answer) {
							l = map[i][j];
							count = 0;
							j += X-1;							
						}else {
							break;
						}
					}
					else if (map[i][j] - 1 == l) {
						if (count < X) {
							answer = false;
							break;
						}
					l = map[i][j];
					count=1;
					}
					else if (map[i][j] == l) {
						count++;
					}
					else {
						answer= false;
						break;
					}
				}
				if (answer) {
					result += 1;
				}
			}
			for (int i = 0; i < N; i++) {
				boolean answer = true;
				int l = map[0][i];
				int count = 1;
				for (int j = 1; j < N; j++) {
					if (map[j][i] + 1 == l) {
						for (int x = j; x < j+X; x++) {
							if (x >= N) {
								answer = false;
								break;
							}
							if (map[x][i] != map[j][i]) {
								answer = false;
								break;
							}
						}
						if (answer) {
							l = map[j][i];
							count = 0;
							j += X-1;							
						}else {
							break;
						}
					}
					else if (map[j][i] - 1 == l) {
						if (count < X) {
							answer = false;
							break;
						}
					l = map[j][i];
					count=1;
					}
					else if (map[j][i] == l) {
						count++;
					}
					else {
						answer= false;
						break;
					}
				}
				if (answer) {
					result += 1;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, result);
		}
	}
}
