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
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];
		
		boolean[][] check;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, 1, -1, 0};
		
		int year = 0;
		
		int[][] nextMap;
		
		while(true) {
			nextMap = new int[n][m];
			year++;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0) {
						int temp = map[i][j];
						for (int k = 0; k < 4; k++) {
							int nx = j + dx[k];
							int ny = i + dy[k];
							if (nx >= 0 && nx < m && ny >=0 && ny < n) {
								if (map[ny][nx] == 0) {
									temp -= 1;
								}
							}
						}
						if (temp < 0) {
							temp = 0;
						}
						nextMap[i][j] = temp;
					}
				}
			}
			map = nextMap;
			
			
			check = new boolean[n][m];
			int count = 0;
			Queue<xy> q = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0 && !check[i][j]) {
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
								if (nx >= 0 && nx<m && ny>=0 && ny<n) {
									if (map[ny][nx] != 0 && !check[ny][nx]) {
										check[ny][nx] = true;
										q.add(new xy(nx, ny));
									}
								}
							}
						}						
					}
				}
			}
			if (count >= 2) {
				System.out.println(year);
				break;
			}
			else if (count == 0) {
				System.out.println(0);
				break;
			}
		}	
	}
}
