package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
class coord{
    int x, y, w;
     
    public coord(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}
 
public class Main {
    static char[][] map;
    static int[][] check;
    static int[][] check2;
    static int[] dx = { 0, 0,-1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        map = new char[n][m];
        check = new int[n][m];
        check2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }   
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				check[i][j] = Integer.MAX_VALUE;
			}
		}
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		check2[i][j] = Integer.MAX_VALUE;
        	}
        }
        if (n == 1 && m == 1) {
			answer = 1;
		}
        
        bfs(new coord(0,0,1));
        bfs2(new coord(m-1,n-1,1));
        checkOne();       
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        
    }
    public static void bfs(coord c) {
    	Queue<coord> q = new LinkedList<>();
    	check[c.y][c.x] = c.w;
    	int nx = c.x; 
		int ny = c.y;
		
    	q.add(c);
    	
    	while (!q.isEmpty()) {
			coord temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				nx = temp.x + dx[i];
				ny = temp.y + dy[i];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if (nx == m-1 && ny == n-1) {
						answer = temp.w+1;
					}
					if (map[ny][nx] == '0'){
						if (check[ny][nx] > temp.w+1) {
							q.add(new coord(nx, ny, temp.w+1));
							check[ny][nx] = temp.w + 1;
						}
					}
				}
			}
    	}
    }
    public static void bfs2(coord c) {
    	Queue<coord> q = new LinkedList<>();
    	check2[c.y][c.x] = c.w;
    	int nx = c.x; 
		int ny = c.y;
		
    	q.add(c);
    	
    	while (!q.isEmpty()) {
			coord temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				nx = temp.x + dx[i];
				ny = temp.y + dy[i];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if (map[ny][nx] == '0'){
						if (check2[ny][nx] > temp.w+1) {
							q.add(new coord(nx, ny, temp.w+1));
							check2[ny][nx] = temp.w + 1;
						}
					}
				}
			}
    	}
    }
    public static void checkOne() {
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '1') {
					int min1 = Integer.MAX_VALUE;
					int min2 = Integer.MAX_VALUE;
					for (int k = 0; k < 4; k++) {
						int nx = j+dx[k];
						int ny = i+dy[k];
						if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
							if (map[ny][nx] == '0') {
								min1 = (int)Math.min(min1, check[ny][nx]);
								min2 = (int)Math.min(min2, check2[ny][nx]);
							}
						}
					}
					if (min1 != Integer.MAX_VALUE && min2 != Integer.MAX_VALUE) {
						answer = (int)Math.min(answer, min1+min2+1);
					}
				}
			}
		}
    }
}