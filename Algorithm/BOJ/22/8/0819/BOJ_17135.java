import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
    static int N, M, D;
    static int[][] map;
    static int count;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {0, -1, 0};
    static boolean[] select;
    static class coord{
    	int x, y, d;
    	
    	public coord(int x, int y, int d) {
    		this.x = x;
    		this.y = y;
    		this.d = d;
    	}
    }
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        D = Integer.parseInt(temp[2]);
        map = new int[N][M];
        select = new boolean[M];
        for (int i = 0; i < N; i++) {
        	temp = br.readLine().split(" ");
        	for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
        comb(0,0);
        System.out.println(answer);
    }
    public static void comb(int idx, int cnt) {
    	if (cnt == 3) {
    		int[][] copy = deepcopy(map);
    		ArrayList<coord> del;
    		count = 0;
    		for (int i = 0; i < N; i++) {
    			del = new ArrayList<>();
    			for (int j = 0; j < M; j++) {
    				if (select[j]) {
    					del.add(shoot(j, copy));
    				}
    			}
    			for (int j = 0; j < 3; j++) {
    				if (copy[del.get(j).y][del.get(j).x] == 1) {
    					copy[del.get(j).y][del.get(j).x] = 0;
    					count++;
    				}
				}
    			rotate(copy);
			}
    		answer = Math.max(answer, count);
    		return;
		}
    	if (idx == M) {
			return;
		}
    	select[idx] = true;
    	comb(idx+1, cnt+1);
    	select[idx] = false;
    	comb(idx+1, cnt);
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
    public static coord shoot(int idx, int[][] copy) {
    	boolean[][] check = new boolean[N][M];
    	ArrayDeque<coord> q = new ArrayDeque<>();
    	if (copy[N-1][idx] == 1) {
			return new coord(idx, N-1, 1);
		}
    	check[N-1][idx] = true;
    	q.add(new coord(idx, N-1, 1));
    	while (!q.isEmpty()) {
			coord temp = q.poll();
			for (int i = 0; i < 3; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				int nd = temp.d + 1;
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && nd <= D && !check[ny][nx]) {
					if (copy[ny][nx] == 1) {
						return new coord(nx, ny, nd);
					}
					else {
						check[ny][nx] = true;
						q.add(new coord(nx, ny, nd));
					}
				}
			}
		}
    	return new coord(idx, N-1, 1);
    }
    public static void rotate(int[][] map) {    	
    	for (int i = N-1; i > 0; i--) {
			for (int k = 0; k < M; k++) {
				map[i][k]= map[i-1][k];
			}
    		
		}
    	for (int i = 0; i < M; i++) {
			map[0][i] = 0;
		}
    }
}