package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class coordinate{
	int x;
	int y;
	public coordinate(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
public class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[][] map = new char[n][n];
		
		for (int i = 0; i < map.length; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = temp[j];
			}
		}
		
		Queue<coordinate> q = new LinkedList<>();
		boolean[][] check = new boolean[n][n];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		
		int count1 = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (!check[i][j]) {
					count1 += 1;
					coordinate c = new coordinate(j, i);
					q.add(c);
					check[i][j] = true;
					while (!q.isEmpty()) {
						coordinate now = q.poll();
						char color = map[now.y][now.x];
						for (int k = 0; k < 4; k++) {
							int nextX = now.x + dx[k];
							int nextY = now.y + dy[k];
							if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
								if (map[nextY][nextX] == color && !check[nextY][nextX]) {
									q.add(new coordinate(nextX, nextY));
									check[nextY][nextX] = true;
								}
							}
						}
					}
				}
			}
		}
		int count2 = 0;
		check = new boolean[n][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (!check[i][j]) {
					count2 += 1;
					coordinate c = new coordinate(j, i);
					q.add(c);
					check[i][j] = true;
					
					while (!q.isEmpty()) {
						coordinate now = q.poll();
						char color = map[now.y][now.x];

						for (int k = 0; k < 4; k++) {
							int nextX = now.x + dx[k];
							int nextY = now.y + dy[k];
							if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
								if (!check[nextY][nextX]) {
									char nowColor = map[nextY][nextX];
									if (color == 'G' || color == 'R') {
										if (nowColor == 'G' || nowColor == 'R') {
											q.add(new coordinate(nextX, nextY));
											check[nextY][nextX] = true;
										}
									} 
									else {
										if (nowColor == 'B') {
											q.add(new coordinate(nextX, nextY));
											check[nextY][nextX] = true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count1 + " " + count2);
	}
}
