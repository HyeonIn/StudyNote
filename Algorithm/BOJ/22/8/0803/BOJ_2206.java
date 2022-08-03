package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
class coord{
    int x;
    int y;
    int w;
    boolean canD;
    
     
    public coord(int x, int y, int w, boolean canD) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.canD = canD;
    }
}
 
public class Main {
    static char[][] map;
    static boolean[][] check;
    static int[] dx = { 0, 0,-1, 1};
    static int[] dy = {-1, 1, 0, 0};
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        map = new char[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }     
        int answer = bfs(new coord(0,0,1,true));
        System.out.println(answer);
    }
    public static int bfs(coord c) {
    	Queue<coord> q = new LinkedList<>();
    	int answer = -1;
    	int[] dx = {-1,1,0,0};
    	int[] dy = {0,0,-1,1};
    	check[0][0] = true;
    	int nx = 0; 
		int ny = 0;
		if (map[c.y][c.x] == '1') {
			c.canD = false;
		}
    	q.add(c);
    	
    	while (!q.isEmpty()) {
			coord temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				nx = temp.x + dx[i];
				ny = temp.y + dy[i];
				if (nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length) {
					if (map[ny][nx] == '1') {
						if(temp.canD && !check[ny][nx]) {
							if (nx == map[0].length-1 && ny == map.length-1) {
								answer = temp.w + 1;
								check[ny][nx] = true;
							}
							q.add(new coord(nx, ny, temp.w+1, false));
							check[ny][nx] = true;
						}
					}
					else if (map[ny][nx] == '0'){
						if (!check[ny][nx]) {
							if (nx == map[0].length-1 && ny == map.length-1) {
								answer = temp.w + 1;
								check[ny][nx] = true;
							}
							q.add(new coord(nx, ny, temp.w+1, temp.canD));
							check[ny][nx] = true;
						}
					}
				}
			}
		}
    	
    	
    	return answer;
    }
}