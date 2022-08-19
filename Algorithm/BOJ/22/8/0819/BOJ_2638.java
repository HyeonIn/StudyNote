package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class coord{
    	int x, y;
    	
    	public coord(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
        	temp = br.readLine().split(" ");
        	for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
        int[][] copy;
        int hour = 0;
        while (true) {
            if (!cheeseCheck()) {
				break;
			}
        	copy = deepcopy(map);
            airCheck(copy);
            melt(copy);
            hour++;
            map = deepcopy(copy);
		}
        System.out.println(hour);
    }
    public static void airCheck(int[][] copy) {
    	check = new boolean[N][M];
    	ArrayDeque<coord> q = new ArrayDeque<>();
    	q.add(new coord(0,0));
    	check[0][0] = true;
    	copy[0][0] = 9;
    	while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && !check[ny][nx]) {
					if (copy[ny][nx] == 0 || copy[ny][nx] == 9) {
						copy[ny][nx] = 9;
						check[ny][nx] = true;
						q.add(new coord(nx, ny));
					}
				}
			}
		}
    }
    public static void melt(int[][] copy) {
    	for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				if (copy[i][j] == 1) {
					int countAir = 0;
					for (int k = 0; k < 4; k++) {
						int ni = i + dy[k];
						int nj = j + dx[k];
						if (copy[ni][nj] == 9) {
							countAir++;
						}
					}
					if (countAir >= 2) {
						copy[i][j] = 0;
					}
				}
			}
		}
    }
    public static int[][] deepcopy(int[][] origin){
    	int[][] copy = new int[N][M];
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = origin[i][j];
			}
		}
    	return copy;
    }
    
    
    public static boolean cheeseCheck() {
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			if (map[i][j] == 1) {
					return true;
				}
    		}
    	}
    	return false;
    }
}