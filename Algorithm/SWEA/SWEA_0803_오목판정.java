package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		char[][] arr;
		boolean[][] check;
		int[] dx = {1, 1,0,-1};
		int[] dy = {0, 1, 1,1,};
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			arr = new char[n][n];
			
			for (int i = 0; i < n; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp[j];
				}
			}
			
			Queue<coord> q = new LinkedList<coord>();
			boolean answer = false;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 'o') {
						q.add(new coord(j, i));
						while (!q.isEmpty()) {
							coord c = q.poll();
							for (int k = 0; k < 4; k++) {
								int count = 1;
								for (int mul = 1; mul < 5; mul++) {
									int nx = c.x + dx[k]*mul;
									int ny = c.y + dy[k]*mul;
									
									if (nx >= 0 && nx < n && ny>=0 && ny < n) {
										if (arr[ny][nx] == 'o') {
											count++;
											
											if (count == 5) {
												answer = true;
											}
										}										
									}
								}
							}
						}
					}
				}
			}
			
			
			System.out.printf("#%d %s\n", t+1, answer? "YES" : "NO");
		}
	}
	static class coord{
		int x;
		int y;
		coord(int x, int y){
			this.x =x;
			this.y =y;
			
		}
	}

}
