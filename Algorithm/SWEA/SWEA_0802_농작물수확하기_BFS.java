package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class coord{
	int x;
	int y;
	int d;
	public coord(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}


public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, -1, 1, 0};
		
		
		for (int T = 0; T < t; T++) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			boolean[][] check = new boolean[n][n];
			Queue<coord> q = new LinkedList<coord>();
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			
			coord c = new coord(n/2,n/2,0);
			check[n/2][n/2] = true;
			int ans = map[n/2][n/2];
			q.add(c);
			
			while (!q.isEmpty()) {
				coord temp = q.poll();
				if (temp.d < n/2) {
					for (int i = 0; i < 4; i++) {
						int nx = temp.x + dx[i];
						int ny = temp.y + dy[i];
						if (!check[ny][nx]) {
							ans += map[ny][nx];
							check[ny][nx] = true;
							q.add(new coord(nx, ny, temp.d+1));
						}
					}
					
				}
			}
			
			System.out.printf("#%d %d\n", T+1, ans);
		}
			
	}

}