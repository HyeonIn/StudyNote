import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] check;
    static ArrayList<Integer> counts = new ArrayList<>();
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    
    static class coord{
    	int i, j;
    	
    	public coord(int i, int j) {
    		this.i = i;
    		this.j = j;
    	}
    }
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        check = new boolean[N][N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !check[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}
        Collections.sort(counts);
        System.out.println(count);
        for (int i = 0; i < counts.size(); i++) {
			System.out.println(counts.get(i));
		}
    }
    public static void bfs(int i, int j) {
    	ArrayDeque<coord> q = new ArrayDeque<>();
    	check[i][j] = true;
    	int count = 1;
    	q.add(new coord(i, j));
    	while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ni = temp.i + di[k];
				int nj = temp.j + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !check[ni][nj]) {
					if (map[ni][nj] == '1') {
						count++;
						check[ni][nj] = true;
						q.add(new coord(ni, nj));
					}
				}
			}
		}
    	counts.add(count);
    }
}