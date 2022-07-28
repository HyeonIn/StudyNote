package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class xy {
	int x;
	int y;
	public xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] map = new int[n][n];
		
		boolean[][] check;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, 1, -1, 0};
		
		int rain = 0;
		int maxCount = 0;
		
		while (true) {
			check = new boolean[n][n];
			int count = 0;
			Queue<xy> q = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > rain && !check[i][j]) {
						xy now = new xy(j,i);
						check[i][j] = true;
						count++;
						q.add(now);
						while (!q.isEmpty()) {
							xy temp = q.poll();
							int x = temp.x;
							int y = temp.y;
							for (int k = 0; k < 4; k++) {
								int nx = x+dx[k];
								int ny = y+dy[k];
								if (nx >= 0 && nx<n && ny>=0 && ny<n) {
									if (map[ny][nx] > rain && !check[ny][nx]) {
										check[ny][nx] = true;
										q.add(new xy(nx, ny));
									}
								}
							}
						}
						
						
					}
				}
			}
			rain++;
			if (count == 0) {
				break;
			}
			else {
				if (count > maxCount) {
					maxCount = count;
				}
			}
		}
		System.out.println(maxCount);
	}
}
