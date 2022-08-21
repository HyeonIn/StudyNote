import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] check;
    static ArrayList<Integer> counts = new ArrayList<>();
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int count;
    
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

        for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !check[i][j]) {
					count = 1;
					check[i][j] = true;
					dfs(i, j);
					counts.add(count);
				}
			}
		}
        Collections.sort(counts);
        System.out.println(counts.size());
        for (int i = 0; i < counts.size(); i++) {
			System.out.println(counts.get(i));
		}
    }
    public static void dfs(int i, int j) {
    	
    	for (int k = 0; k < 4; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && !check[ni][nj] && map[ni][nj] == '1') {
				check[ni][nj] = true;
				count++;
				dfs(ni, nj);
			}
		}
    }
}